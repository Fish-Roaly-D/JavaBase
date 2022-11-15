package com.roily.test;

import com.roily.entity.Department;
import com.roily.mapper.DepartmentMapper;
import com.roily.util.mybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/8
 */
public class test01 {

    @Test
    public void testConn() throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        System.out.println(sqlSession);
        System.out.println(sqlSession.getConnection());


    }

    @Test
    public void testConn2() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();
        System.out.println(sqlSession);
        System.out.println(sqlSession.getConnection());
    }

    @Test
    public void testConn3() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.queryBatch();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void testConn4() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.queryBatch2();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void testConn5() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.queryById(1);
        System.out.println(department);

    }

    @Test
    public void testConn6() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);


        Department department = new Department();
        department.setDeptName("asdasdasd");
        department.setCreateTime(new Date());
        department.setModifyTime(new Date());
        Boolean i = mapper.insertIntoDept2(department);
        System.out.println(i);

    }

    @Test
    public void testConn7() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = Department.builder()
                .deptName("mybatis部门")
                .delete(0)
                .createTime(new Date())
                .modifyTime(new Date()).build();
        System.out.println(department);
        int i = mapper.insertIntoDept(department);
        sqlSession.commit();
        System.out.println(i);

    }

    @Test
    public void testConn8() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        int rows = mapper.deleteById(40);
        sqlSession.commit();

        System.out.println(rows);
    }
    @Test
    public void testConn9() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();


        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department deptOld = mapper.queryById(46);
        System.out.println(deptOld);
        //deptName字段只有10  截断
        deptOld.setDeptName((deptOld.getDeptName()+"更新").substring(3));
        deptOld.setModifyTime(new Date());
        int rows = mapper.modifyById(deptOld);
        sqlSession.commit();

        System.out.println(rows);
    }


    @Test
    public void testConn10() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.queryBatchAliasTest();
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    @Test
    public void testConn11() throws IOException {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.queryBatchAliasTest2();
        for (Department department : departments) {
            System.out.println(department);
        }
    }


}
