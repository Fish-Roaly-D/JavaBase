package com.roily.designpatterns.dpmain.prototype.aboutclone.shallowclone;

import com.roily.designpatterns.dpmain.prototype.aboutclone.Person;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0.0
 * @Description 浅拷贝
 * @ClassName ShallowCopy.java
 * @author: RoilyFish
 * @date: 2022/6/5 22:05
 */
public class ShallowCopy {


    @Test
    public void shallowCopy() throws CloneNotSupportedException, InterruptedException {

        Person person = new Person();
        person
                .setAge(21)
                .setName("yyc")
                .setSex(new StringBuffer("男"))
                .setBirthDay(Calendar.getInstance().getTime());

        Person personCopy = person.clone();

        //lomBok重写了hashCode方法
        System.out.println(person.hashCode());
        System.out.println(personCopy.hashCode());
        //两个对象不相等
        System.out.println(personCopy == person);
        //内部属性 String
        System.out.println(person.getSex() == personCopy.getSex());
        //内部属性 Integer
        System.out.println(person.getAge() == personCopy.getAge());
        //内部属性 Date
        System.out.println(person.getBirthDay() == personCopy.getBirthDay());

        personCopy.getSex().append("123");

        System.out.println(person);
        System.out.println(personCopy);

    }

}
