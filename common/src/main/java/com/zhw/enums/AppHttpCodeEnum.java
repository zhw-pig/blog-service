package com.zhw.enums;

@SuppressWarnings("all")
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    PARAM_ERROR(400,"接口参数异常"),
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"全局捕获的系统错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PASSWORD_ERROR(504,"密码错误"),
    USER_NAME_ERROR(505,"用户名错误");
    int code;
    String msg;
    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
