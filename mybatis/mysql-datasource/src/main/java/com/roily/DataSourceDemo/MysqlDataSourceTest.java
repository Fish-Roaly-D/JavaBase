package com.roily.DataSourceDemo;

import org.junit.Test;

import java.sql.Connection;
import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/7
 */
public class MysqlDataSourceTest {

    @Test
    public void test(){

        Connection conn = MysqlDataSourceUtil.getConn();
        System.out.println(conn);
        MysqlDataSourceUtil.release(conn,null,null);
    }


    @Test
    public void test2(){

        long startTime = new Date().getTime();
        for (int i = 0; i < 10; i++) {
            Connection conn = MysqlDataSourceUtil.getConn();
            System.out.println(conn);
            MysqlDataSourceUtil.release(conn,null,null);
        }
        long endTime = new Date().getTime();
        System.out.println("花费时间："+(endTime-startTime));
    }

}
