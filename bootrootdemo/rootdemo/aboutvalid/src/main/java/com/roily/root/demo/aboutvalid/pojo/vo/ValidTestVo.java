package com.roily.root.demo.aboutvalid.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0.0
 * @Description
 * @ClassName ValidTestVo.java
 * @author: RoilyFish
 * @date: 2022/5/28 14:07
 */
@ApiModel(value = "ValidTestVo", description = "视图参数")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ValidTestVo extends BaseParam {

    @ApiModelProperty("参数1a，不为null校验")
    @NotNull(message = "参数不能为null")
    String param01a;

    @ApiModelProperty("参数1b，为null校验")
    @Null(message = "参数只能为null")
    String param01b;

    @ApiModelProperty("参数2，不为空校验")
    @NotBlank(message = "参数不为null，且不为空")
    String param02;

    @ApiModelProperty("参数3，集合")
    @NotEmpty(message = "集合不为null，且长度大于0")
    List<String> param03;

    @ApiModelProperty("参数4，数组")
    @NotEmpty(message = "数组不为null，且长度大于0") //或者
            String[] param04;

    @ApiModelProperty("参数5，Boolean")
    @AssertFalse(message = "只能为false")
    Boolean param05;

    @ApiModelProperty("参数6，Boolean")
    @AssertTrue(message = "只能为true")
    Boolean param06;

    @ApiModelProperty("参数7，存在size()Api的集合")
    @Size(min = 1, message = "集合长度不能为0")
    List<Object> param07;

    @ApiModelProperty("参数8，存在length()Api的集合")
    @Length(min = 1, message = "长度不能为0")
    String param08;

    @ApiModelProperty("参数8，存在length()Api的集合")
    @Size(min = 1, message = "长度不能为0")
    String[] param09;
    /**
     * List 没有length api  所已会报错
     */
    //@ApiModelProperty("参数9，存在length()Api的集合")
    //@Length(min = 1, message = "长度不能为0")
    //List<Object>  param09;

    @ApiModelProperty("参数10，过去的时间")
    @Past(message = "时间必须为，过去的时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Date param10;
}

