package com.roily.test01;

import java.io.InputStream;
import java.sql.*;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class MysqlTest01 {


    public static void main(String[] args) throws SQLException {

        //test1();
        //test2("部门一");
        //test2("部门一'"+"or'1 = 1 ");
        test3("部门一");
        //test3("部门一'"+"or'1 = 1 ");
    }

    public static void test1() throws SQLException {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String pass = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql
        String sql = "select * from department";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Object deptId = resultSet.getObject("deptId");
            Object deptName = resultSet.getObject("deptName");
            System.out.println("{" + deptId + "," + deptName + "}");
        }
        resultSet.close();
        statement.close();
        conn.close();
    }

    public static void test2(String deptName) throws SQLException {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String pass = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql
        String sql = "select * from department where deptName = " + "'" + deptName + "'";

        System.out.println(sql);
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Object deptId = resultSet.getObject("deptId");
            Object deptname = resultSet.getObject("deptName");
            System.out.println("{" + deptId + "," + deptname + "}");
        }
        resultSet.close();
        statement.close();
        conn.close();
    }
    public static void test3(String deptName) throws SQLException {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String pass = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql
        String sql = "select * from department where deptName = ?";

        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setString(1,deptName);

        ResultSet resultSet = prep.executeQuery();

        while (resultSet.next()) {
            Object deptId = resultSet.getObject("deptId");
            Object deptname = resultSet.getObject("deptName");
            System.out.println("{" + deptId + "," + deptname + "}");
        }
        resultSet.close();
        prep.close();
        conn.close();
    }



    public static void test4(String deptName) throws SQLException {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String pass = "123456";
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql
        String sql = "select * from department where deptName = ?";

        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setString(1,deptName);

        ResultSet resultSet = prep.executeQuery();

        while (resultSet.next()) {
            Object deptId = resultSet.getObject("deptId");
            Object deptname = resultSet.getObject("deptName");
            System.out.println("{" + deptId + "," + deptname + "}");
        }
        resultSet.close();
        prep.close();
        conn.close();
    }
}
