package com.zhw.controller;

import com.zhw.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuaiwei
 * @date 2024/8/26 17:01
 */
@RestController
@RequestMapping("admin")
@SuppressWarnings("all")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

}
