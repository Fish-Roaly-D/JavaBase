package com.roily.booknode.pdai._05annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * @Date: 2022/10/31/16:21
 * @Description:
 */
@Target(ElementType.TYPE_USE)
public @interface TargetTypeUser {


}

class TestTargetTypeUse{

    public static void main(String[] args) {

        final ArrayList<@TargetTypeUser String> objects = new ArrayList<>();

    }
}