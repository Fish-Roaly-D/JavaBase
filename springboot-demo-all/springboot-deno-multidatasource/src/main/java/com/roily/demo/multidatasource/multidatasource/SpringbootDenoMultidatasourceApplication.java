package com.roily.demo.multidatasource.multidatasource;

import cn.hutool.json.JSONUtil;
import com.roily.demo.multidatasource.multidatasource.entity.Student;
import com.roily.demo.multidatasource.multidatasource.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SpringBoot配置多数据源
 */
@Slf4j
@RestController
@SpringBootApplication
public class SpringbootDenoMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDenoMultidatasourceApplication.class, args);
    }

    @Autowired
    StudentService studentService;
    @PostMapping("/init")
    public void test(){
        System.out.println(1);
        log.info("Hello World");

        final List<Student> allStudentsFromPostgresql = studentService.getAllStudentsFromPostgresql();

        log.info(JSONUtil.toJsonStr(allStudentsFromPostgresql));

        final List<Student> allStudentsFromMysql = studentService.getAllStudentsFromMysql();

        log.info(JSONUtil.toJsonStr(allStudentsFromMysql));

    }

}
