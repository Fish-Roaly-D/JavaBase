package com.roily.root.demo.aboutannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @version 1.0.0
 * @Description
 * @ClassName AboutAnnocationApplication.java
 * @author: RoilyFish
 * @date: 2022/5/29 16:22
 */
@SpringBootApplication(scanBasePackages =
        {
                "com.roily.root.demo.common.*",
                "com.roily.root.demo.aboutannotation"
        })
public class AboutAnnocationApplication {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                SpringApplication.run(AboutAnnocationApplication.class, args);
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
