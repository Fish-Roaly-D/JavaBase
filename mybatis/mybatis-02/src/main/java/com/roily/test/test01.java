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
    public void test01() {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.queryBatch();

        for (Department department : departments) {
            System.out.println(department);
        }

    }

    @Test
    public void test02() {

        SqlSession sqlSession = mybatisUtil.OpenSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept = Department.builder()
                .deptName("handler")
                .delete(0)
                .modifyTime(new Date())
                .createTime(new Date())
                .build();
        int i = mapper.insertIntoDept(dept);

        sqlSession.commit();

        System.out.println(i);

    }


}
