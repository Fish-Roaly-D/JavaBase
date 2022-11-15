package com.roily.test01;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class MysqlTest03 {

    public static void main(String[] args) throws SQLException {
        //Department department = null;
        //List<Department> depts = new ArrayList<>();
        //for (int i = 0; i < 10; i++) {
        //    department = new Department();
        //    department.setDeptName("批量插入部门" + i);
        //    depts.add(department);
        //}
        //insertBash(depts);

        Integer[] integers = new Integer[20];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = 10+i;
        }
        deleteBash(integers);
    }

    public static void insertBash(List<Department> list) throws SQLException {
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

        String sql = "insert into department(deptName) " +
                "values";
        for (Department dept : list) {
            sql += "(?),";
        }
        sql = sql.substring(0, sql.lastIndexOf(","));

        PreparedStatement prep = conn.prepareStatement(sql);

        int count = 0;
        for (Department dept : list) {
            prep.setObject(++count, dept.getDeptName());
        }
        boolean execute = prep.execute();
        System.out.println(execute);
        prep.close();
        conn.close();
    }

    public static void deleteBash(Integer[] deptIds) throws SQLException {
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

        String sql = "delete from department  " +
                "where deptId in(";
        for (Integer deptId : deptIds) {
            sql += deptId+",";
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += ")";

        PreparedStatement prep = conn.prepareStatement(sql);

        int rows = prep.executeUpdate();
        System.out.println(rows);
        prep.close();
        conn.close();
    }
}
