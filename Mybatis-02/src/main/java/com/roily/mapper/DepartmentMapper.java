package com.roily.mapper;

import com.roily.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/8
 */
public interface DepartmentMapper {
    //查询所有记录
    List<Department> queryBatch();

    //查询所有记录
    List<Department> queryBatch2();

    //根据id查询
    Department queryById(@Param("id") Integer id);

    //插入记录
    int insertIntoDept(Department dept);

    //插入记录
    Boolean insertIntoDept2(Department dept);

    int deleteById(@Param("id") Integer id);

    int modifyById(Department dept);

    //查询所有记录
    List<Department> queryBatchAliasTest();

    //查询所有记录
    List<Department> queryBatchAliasTest2();

}
