package com.sky.advice;

import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jenson
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class BaseControllerException extends Exception {


    @ExceptionHandler(ArithmeticException.class)
    public Result processArithmeticException(HttpServletRequest request, HandlerMethod method, ArithmeticException exception) {
        if (log.isWarnEnabled()) {
            log.warn("BaseControllerException :", exception);
        }
       return Result.errorCode(401, "返回异常信息："+ exception.getMessage());
    }
}