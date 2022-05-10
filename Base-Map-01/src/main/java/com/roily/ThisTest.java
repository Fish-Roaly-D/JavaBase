package com.roily;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/25
 */
public class ThisTest {


    public void thisTest(){
        System.out.println(this);
    }

    public static void main(String[] args) {
        ThisTest thisTest = new ThisTest();
        thisTest.thisTest();

        int i1 = 1, i2;

        ThisTest2 thisTest2 = new ThisTest2();
        thisTest2.thisTest2();
    }


}

class ThisTest2{

    public void thisTest2(){
        System.out.println(this);
    }

}