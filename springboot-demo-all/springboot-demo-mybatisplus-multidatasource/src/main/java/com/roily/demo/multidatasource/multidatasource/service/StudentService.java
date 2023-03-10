package com.roily.demo.multidatasource.multidatasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roily.demo.multidatasource.multidatasource.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {


    List<Student> getAllMaster();

    List<Student> getAllSlave();

}
