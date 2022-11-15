package com.roily.designpatterns.dpmain.prototype.aboutclone.deepcopy;

import com.roily.designpatterns.dpmain.prototype.aboutclone.Person;
import org.junit.Test;

import java.util.Calendar;

/**
 * @version 1.0.0
 * @Description 深拷贝
 * @ClassName DeepCopy.java
 * @author: RoilyFish
 * @date: 2022/6/5 22:48
 */
public class DeepCopy {


    @Test
    public void deepCopy() throws CloneNotSupportedException {

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
        //内部属性 StringBuffer
        System.out.println(person.getSex() == personCopy.getSex());
        //内部属性 Integer
        System.out.println(person.getAge() == personCopy.getAge());
        //内部属性 Date
        System.out.println(person.getBirthDay() == personCopy.getBirthDay());
    }

}
