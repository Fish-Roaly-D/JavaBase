package com.roily.base.jvm.classloader;

/**
 * @author rolyfish
 * @Date: 2022/07/25/16:19
 * @Description: 实例对象是否可以使用静态属性
 */
public class InstanceCanUseStaticField {

    private static String staticStr = "static";

    private final static String staticFinalStr = "finalStatic";


    public static void main(String[] args) {

        System.err.println("静态成员属性");
        System.out.println("属于类，使用类名+属性名调用" + InstanceCanUseStaticField.staticStr);
        System.out.println("可修改:" + (InstanceCanUseStaticField.staticStr = "staticModify"));
        System.err.println("被final修饰的静态成员属性");
        System.out.println("属于类,同样可以使用类名+属性名调用" + InstanceCanUseStaticField.staticFinalStr);
        System.out.println("不可修改" + "InstanceCanUseStaticField.staticFinalStr = '123'");

        System.out.println("使用示例名加属性名调用静态成员变量");
        InstanceCanUseStaticField instanceCanUseStaticField = new InstanceCanUseStaticField();
        System.out.println("静态成员变量属于类，可以被所有实例共享" + (staticStr));
        System.out.println("也可以修改" + (staticStr = "123"));

    }

}
