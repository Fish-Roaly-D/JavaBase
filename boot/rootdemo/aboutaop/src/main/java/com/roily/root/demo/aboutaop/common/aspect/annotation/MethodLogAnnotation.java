package com.roily.root.demo.aboutaop.common.aspect.annotation;

import com.roily.root.demo.aboutaop.common.util.enums.Enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rolyfish
 * @Date: 2022/09/05/17:23
 * @Description:
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLogAnnotation {

    public Enums.BusinessType businessType();

    public String desc() default "";

}
