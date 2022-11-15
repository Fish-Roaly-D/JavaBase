package com.roily.test03;

import com.roily.util.JdbcConnectionUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class TransactionTest {

    private static Connection conn;
    private static PreparedStatement prep;
    private static ResultSet resultSet;

    static {
        conn = JdbcConnectionUtil.getConn();
    }

    public static void main(String[] args) throws SQLException {

        //test01();
        test02();


    }


    static void test01() throws SQLException {
        String sql1 = "insert into department(deptName) values(?)";

        String sql2 = "insert into department(deptName) values(?)";

        prep = conn.prepareStatement(sql1);

        prep.setObject(1, "测试部门-事务一");

        prep.execute();

        double d = 1 / 0;
        prep = conn.prepareStatement(sql2);

        prep.setObject(1, "测试部门-事务二");

        prep.execute();
        prep.close();
        conn.close();
    }

    static void test02() throws SQLException {
        String sql1 = "insert into department(deptName) values(?)";
        String sql2 = "insert into department(deptName) values(?)";

        //关闭自动提交  并开启事务
        conn.setAutoCommit(false);
        try {
            prep = conn.prepareStatement(sql1);
            prep.setObject(1, "测试部门-事务操作一");
            prep.execute();
            double d = 1 / 0;
            prep = conn.prepareStatement(sql2);
            prep.setObject(1, "测试部门-事务操作二");
            prep.execute();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            prep.close();
            conn.close();
        }


    }
}
