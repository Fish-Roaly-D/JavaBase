package com.roily.mapper;

import com.roily.entity.Department;
import com.roily.vo.PageUtil;
import com.roily.vo.QueryParam;
import com.roily.vo.QueryParam2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/14
 */
public interface DepartmentMapper {

    List<Department> getAll(@Param("queryParam") QueryParam queryParam, @Param("pageUtil") PageUtil pageUtil);

    List<Department> getAll2(QueryParam queryParam);

    List<Department> getAll3(@Param("queryParam") QueryParam queryParam);


    List<Department> getAll4(@Param("queryParam") QueryParam2 queryParam);

}
