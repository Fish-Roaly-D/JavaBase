package com.roily.booknode.pdai._05annotation;

/**
 * @Date: 2022/10/31/15:53
 * @Description:
 */
public class OverrideSaveCompile {

    class Father{
        void m(){
            System.out.println(1);
        }
    }


    class Son extends Father{
        @Override
        void m(){
            System.out.println(2);
        }
    }

}

