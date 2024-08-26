package com.zhw.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhw.domain.entity.Admin;
import com.zhw.mapper.AdminMapper;
import com.zhw.service.AdminService;
import org.springframework.stereotype.Service;
/**
 * 用户表(Admin)表服务实现类
 *
 * @author zhanghuaiwei
 * @since 2024-08-26 16:28:11
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
