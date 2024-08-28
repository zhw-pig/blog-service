package com.zhw.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhw.domain.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * 用户表(Admin)表数据库访问层
 *
 * @author zhanghuaiwei
 * @since 2024-08-26 16:28:09
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
}
