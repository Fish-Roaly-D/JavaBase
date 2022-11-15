package com.roily.springioc.test;

import com.roily.springioc.injectbyname.ServiceComponent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/09/30/9:53
 * @Description:
 */
public class TestXmlConfig {

    @Test
    public void test(){

        final ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:application_xml_config.xml");

        System.out.println();
    }
}
