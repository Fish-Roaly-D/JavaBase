package com.roily.designpatterns.dpmain.prototype.aboutclone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0.0
 * @Description 人
 * @ClassName Person.java
 * @author: RoilyFish
 * @date: 2022/6/5 21:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person implements Cloneable {
    String name;
    StringBuffer sex;
    Integer age;
    Date birthDay;

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        clone.setSex(new StringBuffer(sex.toString()));
        clone.setBirthDay((Date) birthDay.clone());
        return clone;
    }
}
