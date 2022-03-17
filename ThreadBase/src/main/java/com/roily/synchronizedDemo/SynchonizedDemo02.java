package com.roily.synchronizedDemo;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName SynchonizedDemo02.java
 * @author: RoilyFish
 * @date: 2022/3/16 15:55
 */
public class SynchonizedDemo02 {


    //共享资源
    private static Age age = new Age();
    //共享资源
    private static Integer a = 0;

    public static void main(String[] args)  {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //获取monitor
                    for (int i1 = 0; i1 < 10000; i1++) {
                        a += 1;
                    }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a);

    }


}

class Age {
    private Integer age = 0;

    void add() {
        age++;
    }

    public Integer getAge() {
        return age;
    }
}