package com.roily.demo.multidatasource.multidatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roily.demo.multidatasource.multidatasource.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
	List<Student> getAllStudents();
}
