package com.roily.mp01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author roilyFish
 * @since 2023-02-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("address")
@ApiModel(value = "User对象", description = "")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("city")
    private String city;

    @TableField("address")
    private String address;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
