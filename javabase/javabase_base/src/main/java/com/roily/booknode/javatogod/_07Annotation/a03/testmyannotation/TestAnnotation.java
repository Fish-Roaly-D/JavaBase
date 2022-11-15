package com.roily.booknode.javatogod._07Annotation.a03.testmyannotation;

import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyComponent;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValid;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValue;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public static boolean testRolyService(Class classP) {
        final List<Annotation> annotations = Arrays.asList(classP.getDeclaredAnnotations());
        if (annotations.isEmpty()) {
            return false;
        } else {
            final List<? extends Class<? extends Annotation>> annotationTypes = annotations.stream().map(Annotation::annotationType).collect(Collectors.toList());
            if (annotationTypes.contains(RolyComponent.class)) {
                return true;
            }
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == RolyComponent.class) {
                    return true;
                }
                return testRolyService(annotation.annotationType());
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(testRolyService(RolyValueBean.class));
    }


}
