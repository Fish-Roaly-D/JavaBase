package com.roily.C3P0;

import com.mchange.v2.c3p0.impl.NewProxyConnection;
import org.junit.Test;

import java.sql.Connection;
import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/7
 */
public class C3P0Test {

    @Test
    public void test() {
        long start = new Date().getTime();
        System.out.println(start);
        for (int i = 0; i < 40; i++) {
            Connection conn = C3P0Util.getConn();
            System.out.println(conn);
            C3P0Util.release(conn, null, null);
        }
        System.out.println(new Date().getTime() -start);
    }

    @Test
    public void test2() {
        Connection conn = C3P0Util.getConn();
        System.out.println((NewProxyConnection) conn);
        C3P0Util.release(conn, null, null);
    }


}
