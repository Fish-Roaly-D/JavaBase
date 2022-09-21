package com.roily.booknode.javatogod._07Annotation.a03.testmyannotation;

import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyService;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValid;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValue;

/**
 * @Date: 2022/08/31/16:21
 * @Description:
 */
@RolyService
public class RolyValueBean {

    @RolyValue(value = "RolyValue给的值value1")
    String value1;

    @RolyValue(value = "RolyValue给的值value2")
    String value2;

    String value3;


    public void method(@RolyValid(value = String.class) StringBuilder sb){

    }

    @Override
    public String toString() {
        return "RolyValueBean{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                '}';
    }
}
