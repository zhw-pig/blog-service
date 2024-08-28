package com.zhw.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhw.domain.ResponseResult;
import com.zhw.domain.dto.AdminLoginDto;
import com.zhw.domain.entity.Admin;
import com.zhw.domain.entity.LoginUser;
import com.zhw.mapper.AdminMapper;
import com.zhw.service.AdminService;
import com.zhw.util.JwtUtil;
import com.zhw.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;


/**
 * 用户表(Admin)表服务实现类
 *
 * @author zhanghuaiwei
 * @since 2024-08-26 16:28:11
 */
@Service("adminService")
@SuppressWarnings("all")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * @description:
     * @author: zhanghuaiwei
     * @date: 2024/8/26 18:34
     * @param: [userName: 不可重复, password: 通过sm4和rsa加密]
     * @return: com.zhw.domain.ResponseResult
     **/
    @Override
    public ResponseResult login(AdminLoginDto adminLoginDto)  {
        // 用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(adminLoginDto.getUserName(),adminLoginDto.getPassword());
        Authentication authenticate =
                authenticationManager.authenticate(authenticationToken);
        // 判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        // 认证通过
        // 通过id生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String adminId = loginUser.getAdmin().getId().toString();
        String token = JwtUtil.createJWT(adminId);
        HashMap<String, String> result = new HashMap<>();
        result.put("token",token);
        // 把完整的用户信息存入redis
        redisCache.setCacheObject("login:"+adminId,loginUser);

        return ResponseResult.okResult(result);
    }

    @Override
    public ResponseResult adminInfo(String authorization) {
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(authorization);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 根据token获取用户id
        String adminId = claims.getSubject();
        Admin admin = adminMapper.selectById(adminId);
        return ResponseResult.okResult(admin);
    }
}
