package com.roily.booknode.javatogod._07Annotation.a01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Date: 2022/08/30/14:05
 * @Description:
 */

@Target({ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,ElementType.PACKAGE})
public @interface MyTestTarget {
}


class xxxx{

    @MyTestTarget
    public xxxx() {
    }

    public void method(@MyTestTarget String a){
        @MyTestTarget
        String val = "";
    }
}
