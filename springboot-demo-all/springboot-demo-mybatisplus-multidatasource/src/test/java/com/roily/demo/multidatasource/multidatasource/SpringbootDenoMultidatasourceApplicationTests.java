package com.roily.demo.multidatasource.multidatasource;

import com.roily.demo.multidatasource.multidatasource.entity.Student;
import com.roily.demo.multidatasource.multidatasource.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SpringbootDenoMultidatasourceApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() {


        List<Student> allMaster = studentService.getAllMaster();

        List<Student> allSlave = studentService.getAllSlave();

        log.info(allMaster.toString());
        log.info(allSlave.toString());


    }

    public static void main(String[] args) {

    }

}
