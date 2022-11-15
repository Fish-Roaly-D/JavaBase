package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import org.junit.Test;

/**
 * @className：ClientTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 21:43
 */
public class ClientTest {

    @Test
    public void test(){

        ConnectionPoll connectionPoll = new ConnectionPoll();

        for (int i = 0; i < 10; i++) {
            IConnection connection = connectionPoll.getConnection();
            System.out.println(connection);
            connection.release();
        }



    }


}
