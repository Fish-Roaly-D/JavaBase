package com.roily.Druid;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/7
 */
public class DruidTest {


    @Test
    public void test01() {

        Connection conn = DruidUtil.getConn();
        System.out.println(conn);
        DruidUtil.release(conn, null, null);

    }

    @Test
    public void test02() {
        for (int i = 0; i < 20; i++) {
            Connection conn = DruidUtil.getConn();
            System.out.println(conn);
            DruidUtil.release(conn, null, null);
        }
    }

    @Test
    public void test03() throws SQLException {

        Connection conn = DruidUtil.getConn();
        String sql = "select * from department";
        PreparedStatement prep = conn.prepareStatement(sql);
        ResultSet resultSet = prep.executeQuery();
        while (resultSet.next()) {
            System.out.println("[" + resultSet.getObject(1) +
                    "," +
                    resultSet.getObject(2) + "]");
        }

        DruidUtil.release(conn, prep, resultSet);

    }

}
