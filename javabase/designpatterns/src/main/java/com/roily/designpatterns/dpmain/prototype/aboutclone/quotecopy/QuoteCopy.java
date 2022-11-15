package com.roily.designpatterns.dpmain.prototype.aboutclone.quotecopy;

import com.roily.designpatterns.dpmain.prototype.aboutclone.Person;
import org.junit.Test;

import java.util.Calendar;

/**
 * @version 1.0.0
 * @Description
 * @ClassName QuoteCopy.java
 * @author: RoilyFish
 * @date: 2022/6/5 21:48
 */
public class QuoteCopy {

    @Test
    public void quoteCopy() {
        Person person = new Person();
        person
                .setAge(21)
                .setName("yyc")
                .setSex(new StringBuffer("男"))
                .setBirthDay(Calendar.getInstance().getTime());

        Person personCopy = person;

        System.out.println(person.hashCode());
        System.out.println(personCopy.hashCode());
        System.out.println(personCopy == person);
    }


}
