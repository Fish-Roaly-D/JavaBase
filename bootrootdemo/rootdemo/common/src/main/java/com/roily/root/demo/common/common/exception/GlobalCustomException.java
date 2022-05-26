package com.roily.root.demo.common.common.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0
 * @Description 全局自定义异常
 * @ClassName GlobalCustomException.java
 * @author: RoilyFish
 * @date: 2022/5/27 0:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "GlobalCustomException", description = "全区自定义异常")
public class GlobalCustomException extends RuntimeException {

    @ApiModelProperty("异常代码")
    private String code;
    @ApiModelProperty("异常描述")
    private String msg;

}
