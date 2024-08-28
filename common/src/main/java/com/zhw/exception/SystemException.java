package com.zhw.exception;

import com.zhw.enums.AppHttpCodeEnum;

@SuppressWarnings("all")
public class SystemException extends RuntimeException {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }
}