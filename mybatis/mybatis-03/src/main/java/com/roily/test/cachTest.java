package com.roily.test;

import com.roily.entity.Department;
import com.roily.mapper.DepartmentMapper;
import com.roily.pojo.EmployeeMapper;
import com.roily.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
public class cachTest {


    @Test
    public void cachTest(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department1 = mapper.queryById(1);
        System.out.println(department1.hashCode());


        Department department2 = mapper.queryById(1);
        System.out.println(department2.hashCode());

        System.out.println(department1 == department2);
    }

    @Test
    public void cachTest2(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);


        Department department1 = mapper.queryById(1);
        System.out.println(department1.hashCode());

        //事务操作
        Department dept = Department.builder().deptName("事务刷新缓存").deptId(2).build();
        int i = mapper.updateByEntity(dept);
        sqlSession.commit();

        Department department2 = mapper.queryById(1);

        System.out.println(department1.hashCode());
        System.out.println(department2.hashCode());

        System.out.println(department1 == department2);
    }

    @Test
    public void cachTest3(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department1 = mapper.queryById(1);

        sqlSession.commit();
        Department department2 = mapper.queryById(1);

        System.out.println(department1 == department2);
    }

    @Test
    public void cachTest4(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department1 = mapper.queryById(1);

        sqlSession.commit();

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        DepartmentMapper mapper2 = sqlSession2.getMapper(DepartmentMapper.class);
        Department department2 = mapper2.queryById(1);
        System.out.println(department1 == department2);
    }

    @Test
    public void cachTest5(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Map<String, Object> map = mapper.selectAsMap(1001);
        System.out.println(map);
        //提交到缓存
        sqlSession.commit();

        //事务操作
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        int i = mapper1.modifyEmployee(1001);
        sqlSession1.commit();
        System.out.println(i);

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        DepartmentMapper mapper2 = sqlSession2.getMapper(DepartmentMapper.class);
        Map<String, Object> map2 = mapper2.selectAsMap(1001);
        System.out.println(map2);
        System.out.println(map2 == map);
    }

}
