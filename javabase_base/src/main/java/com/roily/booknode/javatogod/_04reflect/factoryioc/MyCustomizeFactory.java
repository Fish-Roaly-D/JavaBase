package com.roily.booknode.javatogod._04reflect.factoryioc;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * @classname：MyDefindFactory
 * @author: rolyfish
 * @description: 自定义工厂类
 * @date: 2022/8/26 00:05
 */
public class MyCustomizeFactory {

    final static HashMap<String, Object> mapFactory = new HashMap<>();

    /**
     * 不使用反射
     *
     * @param beanName
     */
    public static Fruit getInstance(String beanName) {
        Fruit fruit = (Fruit) mapFactory.get(beanName);
        if (!ObjectUtils.isEmpty(fruit)) {
            return fruit;
        }
        switch (beanName) {
            case "Apple":
                fruit = new Apple(beanName);
                break;
            case "Orange":
                fruit = new Orange(beanName);
                break;
            case "Banana":
                fruit = new Banana(beanName);
                break;
            default:
                System.out.println("error");
                break;
        }
        mapFactory.put(beanName, fruit);
        return fruit;
    }

    public static Fruit getInstanceWithReflect(String name, String className) {
        Fruit fruit = (Fruit) mapFactory.get(className);
        if (!ObjectUtils.isEmpty(fruit)) {
            return fruit;
        }
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            System.out.println("error");
        }
        mapFactory.put(name, fruit);
        return fruit;
    }

    public static Fruit getInstanceWithReflect(String name) {
        return (Fruit) mapFactory.get(name);
    }


}
