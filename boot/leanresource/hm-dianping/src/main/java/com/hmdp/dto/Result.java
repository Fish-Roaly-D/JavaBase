package com.hmdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private final static Long DEFAULT_SUCCESS_CODE = 200L;
    private final static Long DEFAULT_FAIL_CODE = 500L;
    private final static String DEFAULT_SUCCESS_MSG = "成功";
    private final static String DEFAULT_FAIL_MSG = "失败";

    /**
     * 必须为引用类型，success之前不加is，避免序列化出问题
     */
    private Boolean success;
    private Long code;
    private String msg;
    private T data;

    public static <T> Result<T> info(Long code, Boolean success, String msg, T data) {
        return new Result<>(success, code, msg, data);
    }

    public static <T> Result<T> success(Long code, String msg, T data) {
        return info(code, true, msg, data);
    }

    public static <T> Result<T> success(Long code, String msg) {
        return success(code, msg, null);
    }

    public static <T> Result<T> success(String msg) {
        return success(DEFAULT_SUCCESS_CODE, msg);
    }

    public static <T> Result<T> success(T data) {
        return success(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }
    public static <T> Result<T> success() {
        return success(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }


    public static <T> Result<T> fail(Long code, String msg) {
        return info(code, false, msg, null);
    }

    public static <T> Result<T> fail(String msg) {
        return success(DEFAULT_FAIL_CODE, msg, null);
    }

    public Boolean isSuccess() {
        return success != null && success.equals(true);
    }

}
