package com.zhw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@MapperScan("com.zhw.mapper")

public class BlogManageApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogManageApplication.class, args);
    }

}
