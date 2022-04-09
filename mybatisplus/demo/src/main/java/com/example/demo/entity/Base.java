package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName Base.java
 * @author: RoilyFish
 * @date: 2022/4/9 15:59
 */
@ApiModel(value = "Base",description = "基类")
@Data
public class Base {

    @ApiModelProperty(value = "父类属性",position = 1)
    private String value;

}
