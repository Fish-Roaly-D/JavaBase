package com.roily.booknode.javatogod._07Annotation.a02;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Date: 2022/08/30/23:52
 * @Description:
 */
@Data
public class TestClass {

    @AnnotationWithValue(value = "注解赋值")
    public String value1;

    @AnnotationWithValue
    public String value2;



    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {

        final TestClass testClass = new TestClass();
        final Field value1 = TestClass.class.getField("value1");
        final String str1 = value1.getAnnotation(AnnotationWithValue.class).value();
        value1.set(testClass,str1);
        final Field value2 = TestClass.class.getField("value2");
        final String str2 = value2.getAnnotation(AnnotationWithValue.class).value();
        value2.set(testClass,str2);
        System.out.println(testClass);

    }

}
