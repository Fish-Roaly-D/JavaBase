package com.roily.booknode.javatogod._07Annotation.a01;

import java.lang.annotation.Repeatable;

@Repeatable(Persons.class)
public  @interface Person{
    String role() default "";
}