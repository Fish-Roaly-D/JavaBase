package com.roily.booknode.javatogod._04reflect;

import org.junit.Test;

/**
 * @classname：AboutClass
 * @author: rolyfish
 * @description: Class类
 * @date: 2022/8/25 01:41
 */
public class AboutClass {

    /**
     * 获取Class对象的方式
     */
    @Test
    public void test() {
        final ClassPerson classPerson = new ClassPerson();
        //对象.getClass
        final Class<? extends ClassPerson> aClass = classPerson.getClass();
        //类名.class
        final Class<ClassPerson> classPersonClass = ClassPerson.class;

        try {
            //Class.forName  第二个参数boolean值表示是否触发初始化
            final Class<?> aClass1 = Class.forName("com.roily.booknode.javatogod._04reflect.ClassPerson");
            final Class<?> aClass2 = Class.forName("com.roily.booknode.javatogod._04reflect.ClassPerson", true, ClassLoader.getSystemClassLoader());
        } catch (Exception e) {

        }
    }


}
