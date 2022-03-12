package com.roily.pojo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
public interface EmployeeMapper {


    public List<Employee> getEmployeeList();


    public List<Employee> getEmployeeListByResult();

    int modifyEmployee(@Param("id") Integer id);
}
