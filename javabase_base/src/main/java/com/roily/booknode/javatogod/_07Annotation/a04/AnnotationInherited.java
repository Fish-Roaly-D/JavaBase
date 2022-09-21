package com.roily.booknode.javatogod._07Annotation.a04;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
@Inherited // 声明注解具有继承性
@interface AnnotationInherited {
    String value() default "";
}