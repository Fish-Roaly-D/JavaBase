package com.roily.root.demo.common.common.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version 1.0.0
 * @Description 屈居异常处理器
 * @ClassName GlobalCustomExceptionHandler.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:30
 */
@RestControllerAdvice
public class GlobalCustomExceptionHandler {

    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String unKnownException(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = GlobalCustomException.class)
    public String globalCustomException(GlobalCustomException globalCustomException){
        System.out.println("xxxxxxxxxx");
        return globalCustomException.getMsg();
    }

}
