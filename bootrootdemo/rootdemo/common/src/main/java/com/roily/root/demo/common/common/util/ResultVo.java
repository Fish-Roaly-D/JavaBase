package com.roily.root.demo.common.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @Description 全局统一结果返回类
 * @ClassName ResultVo.java
 * @author: RoilyFish
 * @date: 2022/5/27 23:48
 */
@ApiModel(value = "ResultVo", description = "全局统一结果返回类")
@Data
@Accessors(chain = true)
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -5803751259196687981L;

    //默认失败代码
    private static final String DEFAULT_ERROR_CODE = "5000";
    // 默认成功代码
    private static final String DEFAULT_SUCCESS_CODE = "2000";
    //默认失败消息
    private static final String DEFAULT_ERROR_MSG = "请求失败";
    // 默认成功消息
    private static final String DEFAULT_SUCCESS_MSG = "请求成功";

    @ApiModelProperty("状态码")
    private String code;

    @ApiModelProperty("结果描述")
    private String msg;

    @ApiModelProperty("信息")
    private T data;

    /**
     * 参数完全的返回对象
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> info(String code, String msg, T data) {
        return new ResultVo<T>()
                .setCode(code)
                .setMsg(msg)
                .setData(data);
    }

    /**
     * 成功返回消息和信息
     *
     * @param msg
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> success(String msg, T data) {
        return info(DEFAULT_SUCCESS_CODE, msg, data);
    }

    /**
     * 成功返回消息
     *
     * @param msg
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> success(String msg) {
        return success(msg, null);
    }


    /**
     * 成功返回data
     *
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> success(T data) {
        return success(DEFAULT_SUCCESS_MSG, data);
    }

    /**
     * 使用默认模板返回结果
     *
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> success() {
        return success(DEFAULT_SUCCESS_MSG, null);
    }

    /**
     * 失败返回消息和信息
     *
     * @param msg
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> error(String msg, T data) {
        return info(DEFAULT_ERROR_CODE, msg, data);

    }

    /**
     * 成功返回消息
     *
     * @param msg
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> error(String msg) {
        return error(msg, null);
    }


    /**
     * 成功返回data
     *
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> error(T data) {
        return error(DEFAULT_SUCCESS_MSG, data);
    }

    /**
     * 使用默认模板返回结果
     *
     * @return ResultVo<T>
     */
    public static <T> ResultVo<T> error() {
        return success(DEFAULT_ERROR_MSG, null);
    }

}
