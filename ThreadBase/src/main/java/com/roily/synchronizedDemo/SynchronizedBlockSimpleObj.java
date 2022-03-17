package com.roily.synchronizedDemo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName SynchronizedBlockSimpleObj.java
 * @author: RoilyFish
 * @date: 2022/3/17 22:19
 */
public class SynchronizedBlockSimpleObj {


    private static Integer a = 0;
    private static Integer b = 0;

    public static void main(String[] args) throws InterruptedException {

        System.out.println(b);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (a) {
                    for (int j = 0; j < 10000; j++) {
                        b++;
                    }
                }
            }).start();
        }

        Thread.sleep(5000);

        System.out.println(b);

    }


}
