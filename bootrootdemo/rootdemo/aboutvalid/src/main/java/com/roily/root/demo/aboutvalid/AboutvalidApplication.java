package com.roily.root.demo.aboutvalid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages =
        {
                "com.roily.root.demo.common.*",
                "com.roily.root.demo.aboutvalid.*"
        })
public class AboutvalidApplication {


    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                SpringApplication.run(AboutvalidApplication.class, args);
        displayAllBeans();
    }

    /**
     * 打印所以装载的bean
     */
    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.err.println(beanName);
        }
    }

}
