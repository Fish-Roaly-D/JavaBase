package com.roily.booknode.pdai._05annotation.javadoc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DocumentedTest {

     String name() default "fieldName";
     String setFuncName() default "setField";
     String getFuncName() default "getField";
     boolean defaultDBValue() default false;
}