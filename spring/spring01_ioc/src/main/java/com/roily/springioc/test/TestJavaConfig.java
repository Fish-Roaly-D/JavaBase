package com.roily.springioc.test;

import com.roily.springioc.javaconfig.JavaConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/09/30/10:27
 * @Description:
 */
public class TestJavaConfig {


    @Test
    public void test01(){

        final ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

        System.out.println();

    }



}
