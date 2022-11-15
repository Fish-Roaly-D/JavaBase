package com.roily.booknode.javatogod._07Annotation.a02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2022/08/30/23:41
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationWithValue {

    String value() default "默认值";

}
