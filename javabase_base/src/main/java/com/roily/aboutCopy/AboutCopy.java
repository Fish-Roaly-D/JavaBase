package com.roily.aboutCopy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.attribute.AclFileAttributeView;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AboutCopy.java
 * @author: RoilyFish
 * @date: 2022/4/7 0:48
 */
public class AboutCopy {


    public static void main(String[] args) {
        Person person = new Person("yyc", 23);
        //这就是引用拷贝
        Person personClone = person;

        System.out.println(person == personClone);//返回true
    }

}

@Data
@AllArgsConstructor
class Person implements Cloneable {
    private String name;
    private Integer age;

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

@Data
@AllArgsConstructor
class Copy01 implements Cloneable {

    private Person person;

    @Override
    protected Copy01 clone() throws CloneNotSupportedException {

        return (Copy01) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //copy01
        Copy01 copy01 = new Copy01(new Person("person01", 22));

        Copy01 clone = copy01.clone();

        //两个对象不相等
        System.out.println(copy01 == clone);
        //但是其内部对象相等
        System.out.println(copy01.person == clone.person);

    }
}

@Data
@AllArgsConstructor
class Copy02 implements Cloneable {

    private Person person;

    @Override
    protected Copy02 clone() throws CloneNotSupportedException {

        Copy02 copy02 = (Copy02) super.clone();

        copy02.setPerson(person.clone());

        return copy02;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //copy02
        Copy02 copy02 = new Copy02(new Person("person01", 22));

        Copy02 clone = copy02.clone();

        //两个对象不相等
        System.out.println(copy02 == clone);//false
        //但是其内部对象也不相等
        System.out.println(copy02.person == clone.person);//false

    }
}

