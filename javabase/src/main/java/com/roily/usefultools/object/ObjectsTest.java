package com.roily.usefultools.object;

import org.junit.Test;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * @className：ObjectsTest
 * @author: rolyfish
 * @description: Objects工具类
 * @dte: 2022/6/22 21:19
 */
public class ObjectsTest {


    /**
     * 判空
     * 只有当对象为null时返回true
     */
    @Test
    public void isNull() {
        String string = new String();
        System.out.println(Objects.isNull(string));
    }

    /**
     * spring提供的判空
     */
    @Test
    public void springBeanUtils() {
        System.out.println(ObjectUtils.isEmpty(""));
    }

    /**
     * 为空抛出异常
     */
    @Test
    public void ifNullThrow() {
        Object obj = null;
        //自定义异常信息
        Objects.requireNonNull(obj, "参数为空");
        //使用函数式接口，自定义异常
        Objects.requireNonNull(obj, () -> {
            return "参数为空";
        });
    }


    /**
     * 判断两个对象是否相等
     * 判断逻辑：两个对象完全相等，或equals方法返回true
     */
    @Test
    public void isEquals() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "123";
        System.out.println(Objects.equals(str1, str2));
        System.out.println(Objects.equals(str1, str3));
    }

    /**
     * 对于基本数据类型比较的坑
     * 如果是基本数据类型的包装类型和基本数据类型比较的话，需要注意自动拆箱的空指针异常
     */
    @Test
    public void testSimpleType() {
        Integer i1 = null;
        int i2 = 0;
        //抛出空指针异常
        System.out.println(i1 == i2);
    }
    @Test
    public void testSimpleType2() {
        long i1 = 1L;
        Integer i2 = 1;
        //true
        System.out.println(1 == 1L);
        //true
        System.out.println(i1 == i2);
        //false  这里是自动装箱的问题。long会装箱成Long 而不同类型的equals方法会返回false
        System.out.println(Objects.equals(i1, i2));
    }

    /**
     * 获取对象的hashCode
     */
    @Test
    public void getHashCode() {
        String str = "1223";
        //重写Object的hashCode方法，如多str为空会报空指针异常
        System.out.println(str.hashCode());
        //这里处理的好，为空返回0，不为空再调用hashCode方法
        System.out.println(Objects.hashCode(str));
    }
}
