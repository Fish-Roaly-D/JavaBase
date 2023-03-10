package com.roily.demo.multidatasource.multidatasource.mysqlmapper;

import com.roily.demo.multidatasource.multidatasource.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MysqlStudentMapper {

	List<Student> getAllStudents();

}
