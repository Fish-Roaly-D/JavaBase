package com.hmdp.common;

import com.alibaba.fastjson2.JSON;
import com.hmdp.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author rolyfish
 */
@RestControllerAdvice
@Slf4j
public class GlobalCustomExceptionHandler {
    /**
     * 未知异常
     *
     * @param e 异常
     * @return Result<String>
     */
    @ExceptionHandler(value = RuntimeException.class)
    public Result unKnownException(RuntimeException e) {
        log.error("系统出现异常:{}", e.getMessage());
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }

    /**
     * 请求参数不合法
     *
     * @param notValid 请求参数不合法异常
     * @return Result<String>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException notValid) {
        Map<String, Object> errorDesc = parse(notValid);
        log.error("请求参数不合法:{}", JSON.toJSONString(errorDesc));
        return Result.fail(errorDesc.toString());
    }

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