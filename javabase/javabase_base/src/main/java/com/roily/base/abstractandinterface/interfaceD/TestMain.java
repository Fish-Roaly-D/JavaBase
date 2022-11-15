package com.roily.base.abstractandinterface.interfaceD;

/**
 * @classname：TestMain
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 20:55
 */
public class TestMain {

    public static void main(String[] args) {
        final IPerson student = new Student();
        student.base();
        student.work();

        final IPerson teacher = new Teacher();
        teacher.base();
        teacher.work();

        /**
         * 此刻你会认为，没有任何区别
         *
         * 那么我们假设，如果现在，一个人除了吃喝拉撒 和 工作  他还有爱好，这两种方式如何实现扩展？
         *
         * 这里展示接口的实现方式，也就是IPersonHobby和Singer
         *
         * 他不会对原来的代码有任何影响
         *
         * 反过来看抽象类，如果扩展一个抽象方法的话，在AbstractPerson中添加hobby()抽象方法，那么原先的类都需要修改
         *
         * 继承的目的是为了，实现代码复用。不过抽象类中可定义抽象方法有一定程度上可实现约束
         * 接口的目的是为了实现约束，我定义这些方法，实现类去实现即可
         *
         * 总的来说使用接口，比使用抽象方法，扩展性好，且不会影响原先代码（也就是不会侵入式编程）
         */
    }

}
