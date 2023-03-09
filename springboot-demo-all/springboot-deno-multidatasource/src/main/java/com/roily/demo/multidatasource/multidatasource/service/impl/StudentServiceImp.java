package com.roily.demo.multidatasource.multidatasource.service.impl;

import com.roily.demo.multidatasource.multidatasource.entity.Student;
import com.roily.demo.multidatasource.multidatasource.mysqlmapper.MysqlStudentMapper;
import com.roily.demo.multidatasource.multidatasource.postgresqlmapper.PostgresqlStudentMapper;
import com.roily.demo.multidatasource.multidatasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private PostgresqlStudentMapper postgresqlStudentMapper;
	@Autowired
	private MysqlStudentMapper mysqlStudentMapper;
	
	@Override
	public List<Student> getAllStudentsFromPostgresql() {
		return this.postgresqlStudentMapper.getAllStudents();
	}

	@Override
	public List<Student> getAllStudentsFromMysql() {
		return this.mysqlStudentMapper.getAllStudents();
	}

}
