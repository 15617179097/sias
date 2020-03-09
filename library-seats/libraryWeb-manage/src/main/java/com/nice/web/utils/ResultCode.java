package com.nice.web.utils;

public enum ResultCode {

    //成功
    SUCCESS(200),
    //失败
    FAIL(400),
    //异常报错
    ERROR(500);
    public Integer code;
    ResultCode(Integer code){
        this.code=code;
    }
}
