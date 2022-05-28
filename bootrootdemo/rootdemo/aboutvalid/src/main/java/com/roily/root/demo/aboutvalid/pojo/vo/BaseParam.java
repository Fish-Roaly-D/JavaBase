package com.roily.root.demo.aboutvalid.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @version 1.0.0
 * @Description
 * @ClassName BaseParam.java
 * @author: RoilyFish
 * @date: 2022/5/28 21:09
 */
@ApiModel(value = "BaseParam", description = "基本参数")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BaseParam {

    @NotNull(message = "参数不能为null")
    String url;

    @NotNull(message = "参数不能为null")
    String ip;

}
