package com.roily.demo.multidatasource.multidatasource.service;

import com.roily.demo.multidatasource.multidatasource.entity.Student;

import java.util.List;

public interface StudentService {
	List<Student> getAllStudentsFromPostgresql();
	List<Student> getAllStudentsFromMysql();
}
