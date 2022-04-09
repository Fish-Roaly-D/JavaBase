package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName Address.java
 * @author: RoilyFish
 * @date: 2022/4/9 1:59
 */
@ApiModel(value = "Address", description = "地址", subTypes = Base.class)
@Data
public class Address extends Base {

    @ApiModelProperty(value = "地址", required = true, example = "xxxxx", allowEmptyValue = false)
    private String address;

    @ApiModelProperty(value = "附加信息")
    private String zDes;

}
