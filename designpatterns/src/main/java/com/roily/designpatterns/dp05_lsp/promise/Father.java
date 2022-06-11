package com.roily.designpatterns.dp05_lsp.promise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Father.java
 * @author: RoilyFish
 * @date: 2022/6/11 13:08
 */
@Data
@AllArgsConstructor
public class Father {


    public void method01(IPerson student) {
        System.out.println("父类");
        //System.out.println(student.getClass());

    }
    @Test
    public void test(){

        Father father1 = new Father();
        father1.method01(new Student());

        Son son = new Son();
        son.method01(new Student());
        son.method01(new Teacher());

        //父类的引用指向子类的实例
        Father father2 = new Son();

        father2.method01(new Student());

    }
}
