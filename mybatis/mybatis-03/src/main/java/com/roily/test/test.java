package com.roily.test;

import com.roily.entity.Department;
import com.roily.entity.ResultEntity;
import com.roily.mapper.DepartmentMapper;
import com.roily.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
public class test {


    @Test
    public void test() {

        System.out.println(MybatisUtil.getSqlSession().getConnection());

    }

    @Test
    public void testwhere() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.queryById(1);

        System.out.println(department);

    }

    @Test
    public void testIf() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.queryByIdIf(1);

        for (Department dept : departments) {
            System.out.println(dept);
        }

    }

    @Test
    public void testxx() {

        int i = 10;
        switch (i) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 10:
                System.out.println("10");
                break;

            default:
                System.out.println("default");
        }


    }

    @Test
    public void test3() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department dept = Department.builder()
                .deptId(1)
                .delete(1)
                .deptName("set标签修改")
                .build();
        int i = mapper.updateByEntity(dept);
        System.out.println(i);
    }

    @Test
    public void test4() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        int[] ids = {4, 5, 6};
        List<Department> departments = mapper.queryIn(ids);

        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    @Test
    public void test5() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("id1", 1);
        map.put("id2", 2);
        map.put("id3", 3);

        List<Department> departments = mapper.queryInMap(map);

        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    @Test
    public void test6() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.trimToWhere(1);

        System.out.println(department);

    }

    @Test
    public void test7() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.baseColum(1);

        System.out.println(department);

    }

    @Test
    public void test8() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<ResultEntity> resultEntities = mapper.resultTypeTest();

        for(ResultEntity r:resultEntities){
            System.out.println(r);
        }
    }

    @Test
    public void test9() {

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<ResultEntity> resultEntities = mapper.resultMapTest();

        for(ResultEntity r:resultEntities){
            System.out.println(r);
        }
    }

}
