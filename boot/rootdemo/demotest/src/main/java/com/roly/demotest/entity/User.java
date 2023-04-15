package com.roly.demotest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author roilyFish
 * @since 2022-09-05
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

}
