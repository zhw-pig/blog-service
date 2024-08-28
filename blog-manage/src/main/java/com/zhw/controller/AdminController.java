package com.zhw.controller;

import com.zhw.domain.ResponseResult;
import com.zhw.domain.dto.AdminLoginDto;
import com.zhw.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zhanghuaiwei
 * @date 2024/8/26 17:01
 */
@RestController
@RequestMapping("admin")
@SuppressWarnings("all")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public ResponseResult login(@RequestBody @Valid AdminLoginDto adminLoginDto) {
        ResponseResult result = adminService.login(adminLoginDto);
        return result;
    }
    @GetMapping("info")
    public ResponseResult adminInfo(@RequestHeader("Authorization") String authorization ) {
        ResponseResult result = adminService.adminInfo(authorization);
        return result;
    }
}
