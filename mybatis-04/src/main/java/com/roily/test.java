package com.roily;

import com.roily.entity.Department;
import com.roily.mapper.DepartmentMapper;
import com.roily.util.MybatisUtil;
import com.roily.vo.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
public class test<T> {


    @Test
    public void test01(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();


        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrentPage(1L);
        pageUtil.setLimit(5L);

        List<Department> all = mapper.getAll(QueryParam.builder().keyWord("").build(), pageUtil);

        System.out.println(all);

    }


    @Test
    public void test02(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrentPage(1L);
        pageUtil.setLimit(5L);
        List<Department> all = mapper.getAll2(QueryParam.builder().keyWord("").pageUtil(pageUtil).build());
        System.out.println(all);

    }

    @Test
    public void test03(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrentPage(2L);
        pageUtil.setLimit(5L);
        List<Department> all = mapper.getAll3(QueryParam.builder().keyWord("").pageUtil(pageUtil).build());
        System.out.println(all);

    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurrentPage(2L);
        pageUtil.setLimit(5L);
        List<Department> all = mapper.getAll3(QueryParam.builder().keyWord("").pageUtil(pageUtil).build());
        PageResult pageResult = PageResult.builder()
                .totalCount(5L).totalPage(5L)
                .build();
        pageResult.setList(all);
        pageResult.setCurrentPage(pageUtil.currentPage);
        pageResult.setLimit(pageUtil.limit);
        Result result = Result.success("ok", pageResult);
        System.out.println(result);
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        QueryParam2 queryParam2 = new QueryParam2();
        queryParam2.setKeyWord("");
        queryParam2.setCurrentPage(1L);
        queryParam2.setLimit(5L);

        List<Department> all4 = mapper.getAll4(queryParam2);

        Result ok = Result.success("ok", 123, all4);

        System.out.println(ok);
    }

}
