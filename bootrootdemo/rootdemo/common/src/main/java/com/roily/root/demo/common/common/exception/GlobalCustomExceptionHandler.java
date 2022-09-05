package com.roily.root.demo.common.common.exception;

import com.alibaba.fastjson.JSON;
import com.roily.root.demo.common.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

/**
 * @version 1.0.0
 * @Description 全局异常处理器
 * @ClassName GlobalCustomExceptionHandler.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:30
 */
@RestControllerAdvice
@Slf4j
public class GlobalCustomExceptionHandler {

    /**
     * 未知异常
     *
     * @param e 异常
     * @return ResultVo<String>
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResultVo<String> unKnownException(RuntimeException e) {
        log.error("系统出现异常:{}", e.getMessage());
        return ResultVo.error(e.getMessage());
    }

    /**
     * 全局异常
     *
     * @param globalCustomException 全局异常
     * @return ResultVo<String>
     */
    @ExceptionHandler(value = GlobalCustomException.class)
    public ResultVo<String> globalCustomException(GlobalCustomException globalCustomException) {
        log.error("系统出现异常:{}", globalCustomException.getMsg());
        return ResultVo.error(globalCustomException.getMsg());
    }

    /**
     * 请求参数不合法
     *
     * @param notValid 请求参数不合法异常
     * @return ResultVo<String>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultVo<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException notValid) {
        Map<String, Object> errorDesc = parse(notValid);
        log.error("请求参数不合法:{}", JSON.toJSONString(errorDesc));
        return ResultVo.error(errorDesc);
    }

    /**
     * 参数转换异常
     *
     * @param conversionException 参数转换异常
     * @return ResultVo<String>i
     */
    @ExceptionHandler(value = HttpMessageConversionException.class)
    public ResultVo<Map<String, Object>> MismatchedInputException(HttpMessageConversionException conversionException) {
        log.error("参数解析异常:{}", conversionException.getMessage());
        return ResultVo.error("参数解析异常" + conversionException.getMessage());
    }

    ///**
    // * 参数格式错误
    // *
    // * @param invalidFormat 请求参数不合法异常
    // * @return ResultVo<String>
    // */
    //@ExceptionHandler(value = InvalidFormatException.class)
    //public ResultVo<Map<String, Object>> invalidFormatException(InvalidFormatException invalidFormat) {
    //    System.err.println(invalidFormat.getValue());
    //    log.error("请求参数格式错误:{}", JSON.toJSONString(invalidFormat));
    //    return ResultVo.error(invalidFormat.toString());
    //}

    /**
     * 解析异常
     *
     * @param notValid 异常
     * @return Map<String, String>
     */
    private Map<String, Object> parse(MethodArgumentNotValidException notValid) {
        //方法名
        String methodName = Objects.requireNonNull(notValid.getParameter().getMethod()).getName();
        //异常信息保存于BindingResult
        BindingResult exceptions = notValid.getBindingResult();
        List<ObjectError> allErrors = exceptions.getAllErrors();
        //返回结果
        Map<String, Object> result = new HashMap<>();
        //参数错误
        Properties fieldErrorProp = new Properties();
        allErrors.forEach((error) -> {
            //转化为fieldError
            FieldError fieldError = (FieldError) error;
            //放入prop
            fieldErrorProp.setProperty(fieldError.getField(), fieldError.getDefaultMessage());
        });

        result.put("methodName", methodName);
        result.put("fieldErrorProp", fieldErrorProp);
        return result;
    }

}
