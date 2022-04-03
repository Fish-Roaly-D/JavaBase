package com.roily.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName IsDeleted.java
 * @author: RoilyFish
 * @date: 2022/4/3 14:41
 */
public enum IsDeleted{

    IS_DELETED(1, "已删除"),

    NOT_DELETED(0,"未删除");

    @EnumValue
    private final Integer deleted;

    private final String descp;

    IsDeleted(final Integer deleted, final String descp) {
        this.deleted = deleted;
        this.descp = descp;
    }
}
