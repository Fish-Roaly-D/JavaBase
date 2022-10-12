package com.roily.autowriteresourceinject.resource.byfieldname;

import com.roily.autowriteresourceinject.resource.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2022/10/12/10:31
 * @Description:
 */
public class TestMain {


    public static void main(String[] args) {

        final ApplicationContext acp = new AnnotationConfigApplicationContext(JavaConfig2.class);

        System.out.println();

    }

}
