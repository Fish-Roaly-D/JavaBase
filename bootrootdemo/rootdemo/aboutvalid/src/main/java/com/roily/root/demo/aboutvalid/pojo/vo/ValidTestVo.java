package com.roily.root.demo.aboutvalid.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
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
public class ValidTestVo {

    @ApiModelProperty("参数一，不为null校验")
    @NotNull(message = "参数不能为null")
    String param01;

    @ApiModelProperty("参数二，不为空校验")
    @NotBlank(message = "参数不能为空")
    String param02;

    @ApiModelProperty("参数三，最大值校验")
    @Max(value = 100L, message = "参数不能超过指定值")
    Long param03;

    @ApiModelProperty("参数四，参数格式")
    @Email(message = "邮件格式不合法")
    String param04;

    @ApiModelProperty("参数五，数组")
    @NotEmpty(message = "数组长度不能为空") //或者
    //@Size(min = 1)
    List<Object> param05;

}
