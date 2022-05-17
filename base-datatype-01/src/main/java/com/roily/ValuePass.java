package com.roily;

/**
 * descripte: java值传递概念
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class ValuePass {

    /**
     * 1、String类型
     * 2、普通引用类型
     * 3、基本数据类型
     */

    public static void main(String[] args) {
        //test
        //string
        String str = "abc";
        changeStr(str);
        System.out.println(str);
        System.out.println("=============");

        Person person = new Person("于延闯");
        changeReference(person);
        System.out.println(person.toString());
        System.out.println("=============");

        int i = 0;
        changePrimitive(i);
        System.out.println(i);
        System.out.println("=============");
        /**
         * 结论：
         *      值传递，引用传递概念。：值传递只传递值，不传递对象
         * string不可变
         * 引用类型：传递的是对象的引用地址（也是值），在方法中复制一个引用，两个引用指向同一个内存地址（对象）
         *          通过引用地址可以操作对象。所以可变
         * 基本数据类型：
         *          基本数据类型只有其数值大小，属于值传递，不改变其数值。
         */

        //特殊

        Person person1 = new Person("Person1");
        Person person2 = new Person("Person2");
        changeReference(person1,person2);
        System.out.println("person1=>"+person1);
        System.out.println("person2=>"+person2);
        //对象并未受到影响
        /**
         * java值传递，复制一份对象引用，栈内存中当前存在（person1 person1副本 person2 person2副本）
         * 方法中对副本引用地址进行交换，不影响原引用。
         */
    }

    public static void changeStr(String str) {
        //string是不可变的
        str += "123";
    }

    public static void changeReference(Person p) {
        p.setName("newName");
    }

    public static void changePrimitive(int i) {
        i = 123;
    }


    public static void changeReference(Person p1, Person p2) {
        //p1  p2 交换

        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}


class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}