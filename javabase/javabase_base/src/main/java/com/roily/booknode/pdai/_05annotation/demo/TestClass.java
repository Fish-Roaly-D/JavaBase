package com.roily.booknode.pdai._05annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @classname：TestClass
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/1 00:51
 */
@Job(job = "学生")
@Job(job = "服务员")
public class TestClass {

    @Job(job = "学生")
    @Job(job = "服务员")
    public String[] jobs;

    @Log(log = "setter", desc = "set方法", num = 1)
    @Desc(desc = "set方法")
    public void setValue(String[] jobs) {
        this.jobs = jobs;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        classC();
        fieldD();
        methodD();
    }

    public static void classC() throws NoSuchFieldException {
        final Annotation[] annotations = TestClass.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Jobs) {
                Jobs jobsT = (Jobs) annotation;
                final Job[] value = jobsT.value();
                for (Job job : value) {
                    System.out.println(job.job());
                }
            }
        }
        //返回所有注解  如果是重复注解则返回注解容器
        final Annotation[] annotations1 = TestClass.class.getAnnotations();
        //返回所有注解  如果是重复注解则返回注解容器，忽略父类注解
        final Annotation[] declaredAnnotations1 = TestClass.class.getDeclaredAnnotations();

        //返回指定类型注解，如果是重复注解则返回注解容器。 Job.class返回空
        final Jobs annotation = TestClass.class.getAnnotation(Jobs.class);
        //返回指定类型注解，如果是重复注解则返回注解容器 忽略父类注解。Job.class返回空
        final Jobs declaredAnnotation = TestClass.class.getDeclaredAnnotation(Jobs.class);

        //返回指定类型注解，可返回重复注解
        final Annotation[] annotationsByType = TestClass.class.getAnnotationsByType(Job.class);
        //返回指定类型注解，可返回重复注解，忽略父类注解
        final Annotation[] declaredAnnotationsByType = TestClass.class.getDeclaredAnnotationsByType(Job.class);

    }

    public static void fieldD() throws NoSuchFieldException {
        final AnnotatedElement jobs = TestClass.class.getField("jobs");
        final Annotation[] annotations = jobs.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Jobs) {
                Jobs jobsT = (Jobs) annotation;
                final Job[] value = jobsT.value();
                for (Job job : value) {
                    System.out.println(job.job());
                }
            }
        }

        //返回所有注解  如果是重复注解则返回注解容器
        final Annotation[] annotations1 = jobs.getAnnotations();
        //返回所有注解  如果是重复注解则返回注解容器，忽略父类注解
        final Annotation[] declaredAnnotations1 = jobs.getDeclaredAnnotations();

        //返回指定类型注解，如果是重复注解则返回注解容器。 Job.class返回空
        final Jobs annotation = jobs.getAnnotation(Jobs.class);
        //返回指定类型注解，如果是重复注解则返回注解容器 忽略父类注解。Job.class返回空
        final Jobs declaredAnnotation = jobs.getDeclaredAnnotation(Jobs.class);

        //返回指定类型注解，可返回重复注解
        final Annotation[] annotationsByType = jobs.getAnnotationsByType(Job.class);
        //返回指定类型注解，可返回重复注解，忽略父类注解
        final Annotation[] declaredAnnotationsByType = jobs.getDeclaredAnnotationsByType(Job.class);
    }

    public static void methodD() throws NoSuchFieldException, NoSuchMethodException {


        final Method setValue = TestClass.class.getDeclaredMethod("setValue", String[].class);

        final Annotation[] annotations = setValue.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Log) {
                Log log = (Log) annotation;
                System.out.println("log:" + log.log() + "  desc:" + log.desc() + "  num:" + log.num());
            }
            //运行期间不可见
            if (annotation instanceof Desc) {
                Desc desc = (Desc) annotation;
                System.out.println("  desc:" + desc.desc());
            }
        }

    }

}
