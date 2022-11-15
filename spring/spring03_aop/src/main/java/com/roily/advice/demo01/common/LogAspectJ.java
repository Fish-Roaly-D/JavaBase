package com.roily.advice.demo01.common;

import com.roily.advice.demo01.service.ILog;
import com.roily.advice.demo01.service.ServiceDemo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @classname：LogAspectJ
 * @author: rolyfish
 * @description: 日志切面
 * @date: 2022/10/14 14:29
 */
@Component
@Aspect
public class LogAspectJ {

    /**
     * 匹配指定方法
     * 语法格式：execution([方法的访问级别] 返回类型 [方法所在类的全路径名] 方法名(参数列表) [方法抛出异常类型])
     */
    // @Pointcut(value = "execution(* com.roily.advice.demo01.service.impl.*.*(..))")
    // private void pointCut() {
    // }
    // @Pointcut(value = "execution(public * methodeArgs(..) throws RuntimeException)")
    // private void pointCut() {
    // }
    // @Pointcut(value = "execution(public * *(..))")
    // private void pointCut() {
    // }

    /**
     * 匹配指定参数列表的方法
     */
    // @Pointcut(value = "args(..)")
    // private void pointCut() {
    // }
    // @Pointcut(value = "args(String, Comparable+, ..)")
    // private void pointCut() {
    // }

    /**
     * 匹配方法：指定注解
     */
    // @Pointcut(value = "@annotation(com.roily.advice.demo01.common.LogAnnotation)")
    // private void pointCut() {
    // }

    /**
     * 匹配方法：参数列表持有指定注解
     */
    // @Pointcut(value = "@args(..)")
    // private void pointCut() {
    // }
    // @Pointcut(value = "@args(com.roily.advice.demo01.common.LogAnnotation, *, ..)")
    // private void pointCut() {
    // }

    /**
     * 匹配指定类，及其子类所有方法
     */
    // @Pointcut(value = "within(com.roily.advice.demo01.service.impl.*)")
    // private void pointCut() {
    // }

    /**
     * 匹配可以向上转型为this指定的类型的代理对象的所有方法
     */
    // @Pointcut(value = "this(com.roily.advice.demo01.service.ServiceDemo)")
    // private void pointCut() {
    // }

    /**
     * 匹配可以向上转型为target指定的类型的目标对象的所有方法
     */
    // @Pointcut(value = "target(com.roily.advice.demo01.service.ServiceDemo+)")
    // private void pointCut() {
    // }

    /**
     * 匹配被标注了指定注解的类的所有方法
     */
    // @Pointcut(value = "@within(com.roily.advice.demo01.common.LogAnnotation)")
    // private void pointCut() {
    // }

    // 匹配被标注了指定注解的类的所有方法
    // @Pointcut(value = "@target(com.roily.advice.demo01.common.LogAnnotation)")
    // private void pointCut() {
    // }


    // 匹配对象，指定bean id
    // @Pointcut(value = "bean(serviceMethodArgs)")
    // private void pointCut() {
    // }

    //任意public方法， 第一个*代表返回类型，第二个*代表方法名称
    // @Pointcut(value = "execution(public * * (..))")

    //任意以`met`开头的方法
    // @Pointcut(value = "execution(public * met* (..))")

    // com.roily.advice.demo01.service.ServiceDemo接口下的任意方法
    // @Pointcut(value = "execution(public * com.roily.advice.demo01.service.ServiceDemo.*(..))")

    // com.roily.advice.demo01.service 包下的任意方法
    // @Pointcut(value = "execution(public * com.roily.advice.demo01.service.*.*(..))")

    // com.roily.advice.demo01.service 包下及其子包的任意方法
    // @Pointcut(value = "execution(public * com.roily.advice.demo01.service..*.*(..))")

    // within同理
    // @Pointcut(value = "within(com.roily.advice.demo01.service.*)")
    // @Pointcut(value = "within(com.roily.advice.demo01.service..*)")

    // 代理对象，可以向上转型为com.roily.advice.demo01.service.ServiceDemo任意连接点，及实现此接口的类的任意方法
    // @Pointcut(value = "this(com.roily.advice.demo01.service.ServiceDemo)")

    // 目标对象，可以向上转型为com.roily.advice.demo01.service.ServiceDemo任意连接点，及实现此接口的类的任意方法
    // @Pointcut(value = "target(com.roily.advice.demo01.service.ServiceDemo)")

    // 参数列表对应的方法，第一个参数为Comparable的子类，第二个参数为Integer
    // @Pointcut(value = "args(Comparable+,Integer)")

    //目标对象被LogAnnotation注解标注
    // @Pointcut(value = "@target(com.roily.advice.demo01.common.LogAnnotation)")
    // @Pointcut(value = "@within(com.roily.advice.demo01.common.LogAnnotation)")

    //任意被LogAnnotation注解标注的方法
    // @Pointcut(value = "@annotation(com.roily.advice.demo01.common.LogAnnotation)")

    //只接受一个参数，且参数类型对应类被LogAnnotation注解标注的方法
    // @Pointcut(value = "@args(com.roily.advice.demo01.common.LogAnnotation)")

    //匹配id后缀为Service的bean
    @Pointcut(value = "bean(*Service)")
    private void pointCut() {
    }

    /**
     * 环绕通知
     *
     * @param pjp 切入点信息
     * @return
     * @throws Throwable
     */
    @Around("pointCut() && @annotation(logAnnotation)")
    public Object around(ProceedingJoinPoint pjp, LogAnnotation logAnnotation) throws Throwable {

        System.out.println("环绕通知 --- 开始");
        //方法签名
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        System.out.println("环绕通知 -- 方法名称:" + signature.getName());
        final Object o = pjp.proceed();
        System.out.println("环绕通知 -- 目标对象方法退出，返回结果：" + o);
        return o;
    }

    /**
     * 前置通知
     *
     * @return
     */
    @Before("pointCut() && this(iLog)")
    public void before(ILog iLog) {
        System.out.println(iLog);
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
