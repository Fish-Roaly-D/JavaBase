package com.roily;

import com.roily.entity.Department;
import com.roily.entity.ResultEntity;
import com.roily.mapper.DepartmentMapper;
import com.roily.mapper.ResultMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Test
    void contextLoads() {

        System.out.println(sqlSessionTemplate.getConnection());

    }

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    void testConn(){

        List<Department> departments = departmentMapper.selectList(null);

        departments.forEach(System.out::println);

    }

    @Autowired
    ResultMapper resultMapper;

    @Test
    void testEntity(){

        ResultEntity reByID = resultMapper.getREByID(1001);
        System.out.println(reByID);

    }
    @Test
    void testEntity2(){

        Map<String, Object> reByIDMap = resultMapper.getREByIDMap(1001);
        System.out.println(reByIDMap);
        ResultEntity build = ResultEntity.builder()
                .empId((Integer) reByIDMap.get("empId"))
                .department((String) reByIDMap.get("department"))
                .empName((String) reByIDMap.get("empName"))
                .build();
        System.out.println(build);

        //
        //
        //System.out.println(reByID);

    }

}
