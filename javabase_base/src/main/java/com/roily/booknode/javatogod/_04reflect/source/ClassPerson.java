package com.roily.booknode.javatogod._04reflect.source;

import lombok.Data;
import lombok.Setter;
import lombok.Value;

import java.util.Arrays;

/**
 * @classname：ClassPersomn
 * @author: rolyfish
 * @description:
 * @date: 2022/8/25 01:42
 */
public class ClassPerson {

    public ClassPerson() {
        System.out.println("公开构造器");
    }
    public ClassPerson(String name) {
        this.name = name;
        System.out.println("有参构造");
    }

    static {
        System.out.println("初始化");
    }

    public String name;

    Integer age;

    int num;

    String[] values;

    public void publicMethod(){
        System.out.println("执行public  无参方法");
    }
    public void publicWithParamMethod(String str, int num){
        System.out.println("执行public  有参方法  参数:[str = " +str+",num = "+num);
    }
    private void method2(){
        System.out.println("执行private方法");
    }

    @Override
    public String toString() {
        return "ClassPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num=" + num +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}

