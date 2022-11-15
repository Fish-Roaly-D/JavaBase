package com.roily.usefultools.reflectionutils;

import com.roily.usefultools.beanutils.Person;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @className：ReflectionUtilsTest
 * @author: rolyfish
 * @description: 反射工具类
 * @dte: 2022/6/24 01:17
 */
public class ReflectionUtilsTest {

    public void testXx(String param1, String param2) {

    }

    @Test
    public void testSimple() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        //1、获取构造器,底层也是反射
        Constructor<Person> personConstructor = ReflectionUtils.accessibleConstructor(Person.class);
        //反射也行
        Person.class.getConstructor();

        //2、获取方法
        ReflectionUtils.findMethod(ReflectionUtilsTest.class, "testXx", String.class, String.class);
        //反射也行
        ReflectionUtilsTest.class.getMethod("testXx", String.class, String.class);

        //3、获取字段,这里就不用管这个属性是否私有了
        ReflectionUtils.findField(Person.class, "name");
        //这个需要考虑全限制
        //Person.class.getField("name");
        Person.class.getDeclaredField("name");

        //4、执行方法
        final Method testXx = ReflectionUtils.findMethod(ReflectionUtilsTest.class, "testXx", String.class, String.class);
        ReflectionUtils.invokeMethod(testXx, new ReflectionUtilsTest(), "param1", "param2");
        //反射也行,只不过需要抛出异常
        testXx.invoke(new ReflectionUtilsTest(), "param1", "param2");

        //判断某个字段是否为常量

        //判断某个方法是否为 equals hashCode等等

    }

}
