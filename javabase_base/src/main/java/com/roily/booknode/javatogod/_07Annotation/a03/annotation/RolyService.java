package com.roily.booknode.javatogod._07Annotation.a03.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2022/08/31/16:02
 * @Description: 继承自  @RolyComponent
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RolyComponent
public @interface RolyService {

}
