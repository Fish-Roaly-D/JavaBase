package com.roily.designpatterns.dpmain.prototype.aboutclone.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @version 1.0.0
 * @Description 原型对象
 * @ClassName Prototype.java
 * @author: RoilyFish
 * @date: 2022/6/6 11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Prototype implements Cloneable {

    /**
     * 基本数据类型、包装类型、String可以不用拷贝
     */
    int id;
    Integer age;
    String name;

    /**
     * 对于可变的数据类型得主动拷贝
     */
    StringBuffer sb;
    Date createTime;

    /**
     * 访问权限扩大
     * 返回对象范围缩小
     */
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Prototype clone = (Prototype) super.clone();
        clone.setSb(new StringBuffer(sb));
        clone.setCreateTime((Date) createTime.clone());
        return clone;
    }
}
