package com.guli.servicebase.myexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
//@ResponseBody
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public String MyGlobalException (Exception e){
        System.out.println("系统繁忙");
        return e.getMessage();
    }

}
