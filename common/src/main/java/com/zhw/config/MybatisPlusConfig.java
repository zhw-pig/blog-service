package com.zhw.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new
                MybatisPlusInterceptor();
        // mybatis plus的分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new
                PaginationInnerInterceptor(DbType.MYSQL));
        // mybatis plus的乐观锁插件
        // mybatisPlusInterceptor.addInnerInterceptor(new
        //         OptimisticLockerInnerInterceptor());
        // 防止全局修改和删除
        // mybatisPlusInterceptor.addInnerInterceptor(new
        //         BlockAttackInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}