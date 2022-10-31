package com.roily.booknode.pdai._05annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 普通日志注解
 * @author rolyfish
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})//可标注在 类 接口 、方法、属性上
@Retention(RetentionPolicy.RUNTIME)//在运行期间可见
public @interface Log {

    //日志
    String log();
    //描述
    String desc();
    //编号
    int num();

}
