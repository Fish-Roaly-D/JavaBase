package com.roily.designpatterns.dpmain.strategy.strategydemo;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className：Context
 * @author: rolyfish
 * @description: 转发策略
 * @dte: 2022/6/17 00:55
 */
public class Context {

    private final static List<Person> personList = new ArrayList<>();
    private final static Map<String, String> interfaceNos = new HashMap<>();

    static {
        //初始化一些数据，模仿数据库查询
        personList.add(new Person("yyc1", 21, new Date(System.currentTimeMillis())));
        personList.add(new Person("yyc2", 22, new Date(System.currentTimeMillis())));
        personList.add(new Person("yyc3", 23, new Date(System.currentTimeMillis())));
        personList.add(new Person("yyc4", 24, new Date(System.currentTimeMillis())));

        //接口号数据初始化,接口号，接口名称（这个数据可以配置到数据库内）
        interfaceNos.put("22061601", AddAction.class.getName());
        interfaceNos.put("22061602", DeleteAction.class.getName());
        interfaceNos.put("22061603", ModifyAction.class.getName());
        interfaceNos.put("22061604", SearchAction.class.getName());
    }

    private ActionInterface getInstance(String interfaceNo) throws ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        final String interfaceName = interfaceNos.get(interfaceNo);
        final Class<?> aClass = Class.forName(interfaceName);
        final Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        return (ActionInterface) declaredConstructor.newInstance();
    }

    public void doStrategy(String interfaceNo, Person person) throws ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ActionInterface instance = getInstance(interfaceNo);
        instance.doAction(person);
    }


    /**
     * 对外暴露方法
     */
    public static void addAction(Person person) {
        personList.add(person);
        System.out.println("======" + "addAction" + "======");
        personList.forEach(System.out::println);
    }

    public static void deleteAction(Person person) {
        final boolean remove = personList.remove(person);
        System.out.println("======" + "deleteAction" + "======");
        if (remove) {
            System.out.println("success");
        } else {
            System.out.println("faild");
        }
        personList.forEach(System.out::println);
    }

    public static void searchAction(Person person) {
        final Person person1 = personList.get(personList.lastIndexOf(person));
        if (ObjectUtils.isEmpty(person1)) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了：" + person1);
        }
        personList.forEach(System.out::println);
    }

    /**
     * 通过name修改
     *
     * @param person
     */
    public static void modifyAction(Person person) {
        personList.forEach(obj -> {
            if (obj.getName().equals(person.getName())) {
                System.out.println("找到了、开始修改");
                BeanUtils.copyProperties(person, obj);
                personList.forEach(System.out::println);
                return;
            }
        });
//        System.out.println("没找到，不修改");
    }
}
