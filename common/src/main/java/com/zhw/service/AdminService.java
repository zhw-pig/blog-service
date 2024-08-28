package com.zhw.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhw.domain.ResponseResult;
import com.zhw.domain.dto.AdminLoginDto;
import com.zhw.domain.entity.Admin;

/**
 * 用户表(Admin)表服务接口
 *
 * @author zhanghuaiwei
 * @since 2024-08-26 16:28:11
 */
public interface AdminService extends IService<Admin> {
    ResponseResult login(AdminLoginDto adminLoginDto);

    ResponseResult adminInfo(String authorization);
}
