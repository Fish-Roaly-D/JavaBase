package com.roily.test01;

import java.io.InputStream;
import java.sql.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class MysqlTest01 {


    public static void main(String[] args) throws SQLException {

        test1();
        //test2("部门一");
        //test2("部门一'"+"or'1 = 1 ");
        //test3("部门一");
        //test3("部门一'"+"or'1 = 1 ");

        // test5();


        // test6();


    }


    public static void test6() throws SQLException {
        final ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        final Iterator<Driver> iterator = load.iterator();
        while (iterator.hasNext()) {
            final Driver next = iterator.next();

            String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
            String user = "root";
            String pass = "123456";

            final Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", pass);

            if (next instanceof com.mysql.cj.jdbc.Driver) {

                final Connection connect = next.connect(url, properties);
                final PreparedStatement prst = connect.prepareStatement("select * from user limit ?");
                prst.setInt(1, 10);
                final ResultSet resultSet = prst.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getObject(2));
                }
                resultSet.close();
                prst.close();
                connect.close();
            }

        }
    }

    public static void test1() throws SQLException {
        // try {
        //     //注册驱动
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
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

        prep.setString(1, deptName);

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

        prep.setString(1, deptName);

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

    /**
     * 原生jdbc实现动态sql缺陷
     *
     * @param
     * @throws SQLException
     */

    public static void test5() throws SQLException {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String pass = "123456";

        //查询条件
        String deptN = "部门二";
        Integer isDelete = 0;

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql
        String sql = "select * from department where 1 = 1";

        if (deptN != null)
            sql += "and deptName = ?";
        if (isDelete != null)
            sql += "and `delete` = ?";
        PreparedStatement prep = conn.prepareStatement(sql);

        System.out.println(sql);

        if (deptN != null)
            prep.setString(1, deptN);

        if (isDelete != null)
            prep.setInt(2, isDelete);


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
