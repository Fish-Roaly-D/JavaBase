package com.roily.demo.multidatasource.multidatasource.postgresqlmapper;

import com.roily.demo.multidatasource.multidatasource.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostgresqlStudentMapper {
	List<Student> getAllStudents();
}
