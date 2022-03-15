package com.roily.vo;

import lombok.Builder;
import lombok.ToString;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
@Builder
@ToString
public class Result<T> {

    private static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private static final String DEFAULT_ERROR_MESSAGE = "error";
    private static final Integer DEFAULT_SUCCESS_CODE = 1;
    private static final Integer DEFAULT_ERROR_CODE = 0;

    private String message;
    private Integer code;
    private T data;

    public static Result error(String msg) {

        return Result.error(msg, DEFAULT_ERROR_CODE);

    }

    public static Result error(String msg, Integer code) {

        return Result.builder().message(msg).code(code).build();

    }

    public static <T> Result success(String msg, Integer code, T data) {

        return Result.builder().code(code).message(msg).data(data).build();

    }

    public static <T> Result success(String msg,  T data) {

        return Result.success(msg,DEFAULT_SUCCESS_CODE,data);

    }

    public static <T> Result success(String msg) {

        return Result.success(msg,DEFAULT_SUCCESS_CODE,null);

    }


}
