package com.roily.demo.multidatasource.multidatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roily.demo.multidatasource.multidatasource.entity.Student;
import com.roily.demo.multidatasource.multidatasource.mapper.StudentMapper;
import com.roily.demo.multidatasource.multidatasource.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 默认主节点
@DS("master")
public class StudentServiceImp extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @DS("master")
    @Override
    public List<Student> getAllMaster() {
        return list();
    }

    @DS("slave_1")
    @Override
    public List<Student> getAllSlave() {
        return list();
    }
}
