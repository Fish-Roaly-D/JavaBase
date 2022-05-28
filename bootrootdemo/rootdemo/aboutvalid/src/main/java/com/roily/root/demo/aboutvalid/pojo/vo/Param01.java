package com.roily.root.demo.aboutvalid.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Param01.java
 * @author: RoilyFish
 * @date: 2022/5/28 21:13
 */
@ApiModel(value = "Param01", description = "Param01")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Param01 {

    @ApiModelProperty("参数1，不为null校验")
    @NotNull(message = "参数不能为null")
    String param01;

    @Valid
    Param02 param02;

}
