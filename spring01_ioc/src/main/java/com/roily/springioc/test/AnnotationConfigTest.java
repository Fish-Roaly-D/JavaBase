package com.roily.springioc.test;

import com.roily.springioc.annotationconfig.JavaConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/09/30/10:46
 * @Description:
 */
public class AnnotationConfigTest {

    @Test
    public void test1() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println();

    }

}
