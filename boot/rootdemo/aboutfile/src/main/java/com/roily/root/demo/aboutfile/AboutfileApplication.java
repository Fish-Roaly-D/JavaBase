package com.roily.root.demo.aboutfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages =
        {
                "com.roily.root.demo.common.*",
                "com.roily.root.demo.aboutfile.*"
        })
public class AboutfileApplication {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                SpringApplication.run(AboutfileApplication.class, args);
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
