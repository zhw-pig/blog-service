package com.zhw.handler.exception;

import com.zhw.domain.ResponseResult;
import com.zhw.enums.AppHttpCodeEnum;
import com.zhw.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // 1、全局异常处理，代替局部try catch 2、统一对message信息返回
@Slf4j
@SuppressWarnings("all")
public class GlobalExceptionHandler {

    // RequestBody 参数校验不通过处理处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleValidException(MethodArgumentNotValidException e) {
        // 打印异常信息
        log.error("接口参数！ {}", e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_ERROR.getCode(), objectError.getDefaultMessage());
    }
    @ExceptionHandler(SystemException.class)   // 指定需要处理的异常类型
    public ResponseResult systemExceptionHandler(SystemException e) {
        // 打印异常信息
        log.error("出现了异常！ {}", e);
        // 从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        // 打印异常信息
        log.error("出现了异常！ {}", e);
        // 从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}