package com.roily.dbcp;

import com.roily.DataSourceDemo.MysqlDataSourceUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.DelegatingConnection;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/7
 */
public class DBCPTest {


    @Test
    public void testConn() {
        Connection conn = DBCPDataSourceUtil.getConn();
        System.out.println(conn);
        System.out.println(conn.getClass());
        System.out.println(conn);
        DBCPDataSourceUtil.release(conn, null, null);
    }

    @Test
    public void testConn2() {
        long startTime = new Date().getTime();
        for (int i = 0; i < 10; i++) {
            Connection conn = DBCPDataSourceUtil.getConn();
            System.out.println(conn.hashCode());
            DBCPDataSourceUtil.release(conn, null, null);
            System.out.println((BasicDataSource)(DBCPDataSourceUtil.dataSource));
        }
        long endTime = new Date().getTime();
        System.out.println("花费时间：" + (endTime - startTime));
    }


    @Test
    public void testConn3() throws SQLException {
        for (int i = 0; i < 100; i++) {
            Connection conn = DBCPDataSourceUtil.getConn();
            Class<?>[] interfaces = conn.getClass().getInterfaces();

            for (int i1 = interfaces.length - 1; i1 >= 0; i1--) {
                System.out.println(interfaces[i]);
            }

            System.out.println(conn.getClass());
            DBCPDataSourceUtil.release(conn, null, null);

        }
    }

    @Test
    public void testConn4() throws SQLException {
        for (int i = 0; i < 100; i++) {
            Connection conn = DBCPDataSourceUtil.getConn();
            Class<?>[] interfaces = conn.getClass().getInterfaces();
            System.out.println(conn.getClass());
            //DBCPDataSourceUtil.release(conn, null, null);
        }
    }

}
