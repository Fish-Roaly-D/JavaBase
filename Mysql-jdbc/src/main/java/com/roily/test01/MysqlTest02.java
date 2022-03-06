package com.roily.test01;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class MysqlTest02 {

    public static void main(String[] args) throws SQLException {
        //test1("部门一");

        //插入
        //Department department = new Department();
        //department.setDeptName("测试部门");
        //insert(department);

        // 更新
        //Department department = new Department();
        //department.setDeptId(9);
        //department.setDeptName("测试部门更新");
        //department.setModify_time(new Date());
        //update(department);

        // 删除
        Department department = new Department();
        department.setDeptId(9);
        delete(department);

    }

    public static void test1(String deptName) throws SQLException {
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

        Department department = null;

        while (resultSet.next()) {
            department = new Department();
            System.out.println(resultSet.getObject("create_time").getClass());
            department.setDeptId((Integer) resultSet.getObject("deptId"));
            department.setDeptName((String) resultSet.getObject("deptName"));
            department.setDelete((Integer) resultSet.getObject("delete"));
            department.setCreate_time(Date.from(((LocalDateTime) resultSet.getObject("create_time")).atZone(ZoneId.systemDefault()).toInstant()));
            department.setModify_time(Date.from(((LocalDateTime) resultSet.getObject("modify_time")).atZone(ZoneId.systemDefault()).toInstant()));
            System.out.println(department.toString());
        }
        resultSet.close();
        prep.close();
        conn.close();
    }

    public static void insert(Department department) throws SQLException {
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
                "values (?)";

        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setString(1, department.getDeptName());

        boolean execute = prep.execute();

        System.out.println(execute);
        prep.close();
        conn.close();
    }

    public static void update(Department department) throws SQLException {
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
        String sql = "update department ";
        if(department.getDeptName()!=null){
            sql+="set deptName = ?, ";
        }if(department.getDelete()!=null){
            sql+=" delete  = ?, ";
        }if(department.getCreate_time()!=null){
            sql+=" create_time = ?, ";
        }if(department.getModify_time()!=null){
            sql+=" modify_time = ?, ";
        } if(department.getModify_time()==null){
            sql+=" modify_time = CURRENT_TIMESTAMP() , ";
        }
        //去掉最后一个 ，
        sql = sql.substring(0, sql.lastIndexOf(","));

        sql+="where deptId = ?";
        PreparedStatement prep = conn.prepareStatement(sql);
        //占位符个数
        int count = 0;
        if(department.getDeptName()!=null){
            prep.setObject(++count,department.getDeptName());
        }if(department.getDelete()!=null){
            prep.setObject(++count,department.getDelete());
        }if(department.getCreate_time()!=null){
            prep.setObject(++count,department.getCreate_time());
        }if(department.getModify_time()!=null){
            prep.setObject(++count,department.getModify_time());
        }
        prep.setObject(++count,department.getDeptId());

        int rows = prep.executeUpdate();
        System.out.println(rows);
        prep.close();
        conn.close();
    }

    public static void delete(Department department) throws SQLException {
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
        String sql = "delete from department where deptId = ? ";

        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setObject(1,department.getDeptId());

        int rows = prep.executeUpdate();
        System.out.println(rows);
        prep.close();
        conn.close();
    }
}
