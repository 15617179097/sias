package com.nice.web.interceptor;

import com.nice.web.utils.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Company: 全局统一异常处理 <br>
 * Description:  <br>
 * Date: 2020-03-21 12:04
 *
 * @author wmj
 * @version 1.0
 */
@RestControllerAdvice
public class WebExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DataResult runtimeExceptionHandler(){
        return DataResult.fail(500,"系统运行异常",null);
    }

}
