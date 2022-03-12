package com.roily.mapper;

import com.roily.entity.Department;
import com.roily.entity.ResultEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/8
 */
public interface DepartmentMapper {
    //baseColum
    Department baseColum(@Param("id") Integer id);

    //根据id查询
    Department trimToWhere(@Param("id") Integer id);

    //根据id查询
    Department queryById(@Param("id") Integer id);

    //根据id查询
    List<Department> queryByIdIf(@Param("id") Integer id);

    //更新
    int updateByEntity(Department dept);

    //in   ids
    List<Department> queryIn(@Param("ids") int[] ids);


    //in   map
    List<Department> queryInMap(@Param("map") Map map);


    //resultMapTest
    List<ResultEntity> resultTypeTest();

    //resultMapTest
    List<ResultEntity> resultMapTest();


}
