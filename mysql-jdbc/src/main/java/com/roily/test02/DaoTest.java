package com.roily.test02;

import com.roily.test01.Department;
import com.roily.util.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/6
 */
public class DaoTest extends BaseDao {

    private static Connection conn;
    private static PreparedStatement prep;
    private static ResultSet resultSet;

    //查询所有部门
    public static List<Department> queryAllDept() throws SQLException {
        List<Department> depts = new ArrayList<>();
        Department department = null;
        String sql = "select * from department";
        conn = JdbcConnectionUtil.getConn();
        resultSet = query(conn, prep, resultSet, null, sql);

        while (resultSet.next()) {
            department = new Department();
            department.setDeptId((Integer) resultSet.getObject("deptId"));
            department.setDeptName((String) resultSet.getObject("deptName"));
            department.setDelete((Integer) resultSet.getObject("delete"));
            department.setCreate_time(Date.from(((LocalDateTime) resultSet.getObject("create_time")).atZone(ZoneId.systemDefault()).toInstant()));
            department.setModify_time(Date.from(((LocalDateTime) resultSet.getObject("modify_time")).atZone(ZoneId.systemDefault()).toInstant()));
            System.out.println(department.toString());
            depts.add(department);
        }
        JdbcConnectionUtil.CloseSource(conn, prep, resultSet);

        return depts;
    }

    //查询所有部门{1,2,3}
    public static List<Department> queryDept(Integer[] deptIds) throws SQLException {
        List<Department> depts = new ArrayList<>();
        Department department = null;
        String sql = "select * from department where deptId in (";
        for (int i = 0; i < deptIds.length; i++) {
            sql += "?, ";
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += ")";
        conn = JdbcConnectionUtil.getConn();
        resultSet = query(conn, prep, resultSet, deptIds, sql);
        System.out.println(sql);
        while (resultSet.next()) {
            department = new Department();
            department.setDeptId((Integer) resultSet.getObject("deptId"));
            department.setDeptName((String) resultSet.getObject("deptName"));
            department.setDelete((Integer) resultSet.getObject("delete"));
            department.setCreate_time(Date.from(((LocalDateTime) resultSet.getObject("create_time")).atZone(ZoneId.systemDefault()).toInstant()));
            department.setModify_time(Date.from(((LocalDateTime) resultSet.getObject("modify_time")).atZone(ZoneId.systemDefault()).toInstant()));
            System.out.println(department.toString());
            depts.add(department);
        }
        JdbcConnectionUtil.CloseSource(conn, prep, resultSet);

        return depts;
    }

    //更新
    public static void update(Department dept){

        if(dept == null) return;
        List<Object> list = new ArrayList<>();
        list.add(dept.getDeptName());
        list.add(dept.getDeptId());

        Object[] params = list.toArray();
        conn = JdbcConnectionUtil.getConn();
        String sql = "update department set deptName = ?, " +
                "modify_time = current_timestamp " +
                "where deptId = ?";
        Integer rows = update(conn, prep, params, sql);

        System.out.println(rows);

    }

    //更新
    public static void insert(Department dept){

        if(dept == null) return;
        List<Object> list = new ArrayList<>();
        list.add(dept.getDeptName());
        Object[] params = list.toArray();
        conn = JdbcConnectionUtil.getConn();
        String sql = "insert into department(deptName) values(?) ";
        Boolean status = insert(conn, prep, params, sql);

        System.out.println(status);

    }


    public static void main(String[] args) throws SQLException {
        //查询所有
        //List<Department> departments = queryAllDept();
        //System.out.println(departments);

        // 查询 【1，2，3】
        //Integer[] deptIds = new Integer[]{1, 2, 3};
        //List<Department> departments = queryDept(deptIds);
        //System.out.println(departments);

        //更新
        //Department department = new Department();
        //department.setDeptName("新部门");
        //department.setDeptId(1);
        //update(department);

        //插入
        Department department = new Department();
        department.setDeptName("新添加部门");
        insert(department);
    }



}
