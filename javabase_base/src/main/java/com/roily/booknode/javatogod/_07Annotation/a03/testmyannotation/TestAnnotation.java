package com.roily.booknode.javatogod._07Annotation.a03.testmyannotation;

import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyComponent;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValid;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValue;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @Date: 2022/08/31/16:19
 * @Description:
 */
public class TestAnnotation {

    /**
     * 测试@RolyValue注解
     */
    @Test
    public void testRolyValue() throws IllegalAccessException {
        final RolyValueBean rolyValueBean = new RolyValueBean();
        System.out.println("原对象: ==>" + rolyValueBean);
        final Field[] declaredFields = rolyValueBean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            final RolyValue rolyValue = declaredField.getAnnotation(RolyValue.class);
            if (null != rolyValue) {
                declaredField.set(rolyValueBean, rolyValue.value());
            }
        }
        System.out.println("处理后: ==>" + rolyValueBean);
    }

    @Test
    public void testRolyValid() throws IllegalAccessException {
        final Method[] declaredMethods = RolyValueBean.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            final Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                final RolyValid declaredAnnotation = parameter.getDeclaredAnnotation(RolyValid.class);
                if (null != declaredAnnotation) {
                    if (!parameter.getType().equals(declaredAnnotation.value())) {
                        throw new RuntimeException(declaredMethod.getName() +
                                "方法参数不合法:" +
                                "require:" + declaredAnnotation.value() +
                                "given:" + parameter.getType());
                    }
                }
            }
        }
    }

    @Test
    public void testRolyService(){

        final Annotation[] declaredAnnotations = RolyValueBean.class.getDeclaredAnnotations();

        System.out.println(Arrays.asList(declaredAnnotations).contains(RolyComponent.class));


    }

}
