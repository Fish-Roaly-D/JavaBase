package com.roily.test;

import com.roily.pojo.Department2;
import com.roily.pojo.Department2Mapper;
import com.roily.pojo.Employee;
import com.roily.pojo.EmployeeMapper;
import com.roily.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
public class test2 {


    @Test
    public void test01() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        Department2Mapper mapper = sqlSession.getMapper(Department2Mapper.class);

        List<Department2> deptInfo = mapper.getDeptList();

        for (Department2 dept : deptInfo) {
            System.out.println(dept);
        }

    }

    @Test
    public void test02() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.getEmployeeList();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void test03() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.getEmployeeListByResult();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void test04() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        Department2Mapper mapper = sqlSession.getMapper(Department2Mapper.class);

        List<Department2> depts = mapper.getDeptListInfo();

        for (Department2 dept : depts) {
            System.out.println(dept);
        }

    }

    @Test
    public void test05() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        Department2Mapper mapper = sqlSession.getMapper(Department2Mapper.class);

        List<Department2> depts = mapper.getDeptListInfoResult();

        for (Department2 dept : depts) {
            System.out.println(dept);
        }

    }


}

