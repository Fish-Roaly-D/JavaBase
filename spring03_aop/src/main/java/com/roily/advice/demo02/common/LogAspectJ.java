package com.roily.advice.demo02.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @classname：LogAspectJ
 * @author: rolyfish
 * @description: 日志切面
 * @date: 2022/10/14 14:29
 */
@Component
@Aspect
@Order(10)
public class LogAspectJ {

    @Pointcut(value = "bean(*Impl)")
    private void pointCut2() {
    }

    @Pointcut(value = "bean(*Impl)")
    private void pointCut3() {
    }

    @Pointcut(value = "bean(*Impl)")
    private void pointCut() {
    }

    @Pointcut(value = "bean(*Impl)")
    private void p() {
    }

    /**
     * 环绕通知
     *
     * @param pjp 切入点信息
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知 --- 开始");
        //方法签名
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("环绕通知 -- 方法名称:" + signature.getName());
        final Object o = pjp.proceed();
        System.out.println("环绕通知 -- 目标对象方法退出，返回结果：" + o);
        return o;
    }

    /**
     * 环绕通知
     *
     * @param pjp 切入点信息
     * @return
     * @throws Throwable
     */
    @Around("pointCut2()")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知2 --- 开始");
        //方法签名
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("环绕通知2 -- 方法名称:" + signature.getName());
        final Object o = pjp.proceed();
        System.out.println("环绕通知2 -- 目标对象方法退出，返回结果：" + o);
        return o;
    }

    @Around("pointCut3()")
    public Object around3(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知3 --- 开始");
        //方法签名
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("环绕通知3 -- 方法名称:" + signature.getName());
        final Object o = pjp.proceed();
        System.out.println("环绕通知3 -- 目标对象方法退出，返回结果：" + o);
        return o;
    }
    @Around("p()")
    public Object aroundp(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知p --- 开始");
        //方法签名
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("环绕通知p -- 方法名称:" + signature.getName());
        final Object o = pjp.proceed();
        System.out.println("环绕通知p -- 目标对象方法退出，返回结果：" + o);
        return o;
    }

    /**
     * 前置通知
     *
     * @return
     */
    @Before("pointCut()")
    public void before() {
        System.out.println("前置通知");
    }


    /**
     * 最终通知
     *
     * @return
     */
    @After("pointCut()")
    public void after() {
        System.out.println("最终通知");
    }

    /**
     * 后置通知
     *
     * @return
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(String result) {
        System.out.println("后置通知,返回值：" + result);
    }

    /**
     * 异常通知
     *
     * @return
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("异常通知，异常" + e.getMessage());
    }

}
