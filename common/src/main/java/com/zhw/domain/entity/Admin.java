package com.zhw.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

/**
 * 用户表(Admin)表实体类
 *
 * @author zhanghuaiwei
 * @since 2024-08-26 16:28:10
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin")
public class Admin {
//主键
@TableId
    private String id;
//用户名

    private String userName;
//昵称
    private String nickName;
//密码
    private String password;
//用户类型：0代表普通管理员，1代表超级管理员
    private String type;
//账号状态（0正常 1停用）
    private String status;
//邮箱
    private String email;
//手机号
    private String phone;
//用户性别（0男，1女，2未知）
    private String sex;
//头像
    private String avatar;
//创建人的用户id
    private String createBy;
//创建时间
    private Date createTime;
//更新人
    private String updateBy;
//更新时间
    private Date updateTime;
//删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
