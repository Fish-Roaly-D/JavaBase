package com.roily.abstractandinterface.abs;

/**
 * @classname：TestMain
 * @author: rolyfish
 * @description: todo
 * @date: 2022/10/20 20:55
 */
public class TestMain {

    public static void main(String[] args) {
        final AbstractPerson student = new Student();
        student.base();
        student.work();

        final AbstractPerson teacher = new Teacher();
        teacher.base();
        teacher.work();

    }

}
