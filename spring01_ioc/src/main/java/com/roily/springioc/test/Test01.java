package com.roily.springioc.test;

import com.roily.springioc.injectbyname.ServiceComponent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2022/09/30/9:53
 * @Description:
 */
public class Test01 {

    @Test
    public void test(){

        final ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:application_inject_byname.xml");

        final ServiceComponent serviceComponent = cpx.getBean("serviceComponent", ServiceComponent.class);


    }

    @Test
    public void testx(){

        System.out.println();
    }


}
