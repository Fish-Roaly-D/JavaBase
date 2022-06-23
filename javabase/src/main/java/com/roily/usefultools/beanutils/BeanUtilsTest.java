package com.roily.usefultools.beanutils;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @className：BeanUtilsTest
 * @author: rolyfish
 * @description: BeanUtilsTest
 * @dte: 2022/6/23 23:37
 */
public class BeanUtilsTest {

    /**
     * 拷贝
     */
    @Test
    public void copyPropertiesEquals() {
        Person person = Person.getDefault();
        Person personCopy = new Person();
        System.out.println("原对象");
        System.out.println(person);
        System.out.println(personCopy);
        BeanUtils.copyProperties(person, personCopy, "name");
        System.out.println("拷贝后");
        System.out.println(person);
        System.out.println(personCopy);
    }

    /**
     * 支持不同对象的属性拷贝，只要属性名称相同，也就是setter相同
     * 将person 转化 成personDTO
     */
    @Test
    public void copyProperties() {
        Person person = Person.getDefault();
        PersonDTO personDTO = new PersonDTO();

        System.out.println("原对象");
        System.out.println(person);
        System.out.println(personDTO);
        BeanUtils.copyProperties(person, personDTO);
        System.out.println("拷贝后");
        System.out.println(person);
        System.out.println(personDTO);
    }

    /**
     * 实例化某个类
     */
    @Test
    public void instant() throws NoSuchMethodException {
        //实例化一个空属性类
        System.out.println(BeanUtils.instantiateClass(Person.class));
        //实例化一个类并指定其引用类型，前提是可转化（也就是是父子关系，或接口实现类关系）
        System.out.println(BeanUtils.instantiateClass(Person.class, Object.class));
        System.out.println(BeanUtils.instantiateClass(ArrayList.class, Collection.class));
        //构造器实例化一个类，可以初始化属性
        System.out.println(BeanUtils.instantiateClass(Person.class.getDeclaredConstructor(String.class), "yyc"));
    }

    /**
     * 获取指定类的指定方法
     */
    @Test
    public void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //通过反射实现
        final Method method = Person.class.getDeclaredMethod("getName");
        //当方法是私有的化，可以使用此方法破坏私有
        method.setAccessible(true);
        final Object name = method.invoke(Person.getDefault());
        System.out.println("通过反射实现：" + name);

        //使用工具类实现，底层也是反射
        Method getName = BeanUtils.findDeclaredMethod(Person.class, "getName");
        assert getName != null;
        System.out.println("通过工具类实现：" + getName.invoke(Person.getDefault()));

    }

    /**
     * 获取属性的名称（属性的setter getter）
     */
    @Test
    public void getMethodParams() {
        Method testMethodParams = BeanUtils.findDeclaredMethod(Person.class, "setName",
                String.class);
        final PropertyDescriptor setName = BeanUtils.findPropertyForMethod(testMethodParams);
        System.out.println(setName);
    }

    public void testMethodParams(String param1) {

    }
}
