package com.roily.booknode.javatogod._07Annotation.a03.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2022/08/31/15:55
 * @Description: @Value替代品   可用于方法、字段上
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RolyValue {
    String value() default "";
}
