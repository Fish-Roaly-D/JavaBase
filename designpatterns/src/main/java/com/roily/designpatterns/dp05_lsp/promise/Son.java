package com.roily.designpatterns.dp05_lsp.promise;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Son.java
 * @author: RoilyFish
 * @date: 2022/6/11 13:09
 */
@Data
@AllArgsConstructor
public class Son extends Father {

    public void method01(Student student) {
        System.out.println("子类");

        //super.method01(student);
    }

}
