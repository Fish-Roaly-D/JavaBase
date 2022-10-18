package com.roily.configway.byannotation.common;

import com.roily.configway.byannotation.service.ILog;
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

    @DeclareParents(value = "com.roily.configway.byannotation.service.impl.*", defaultImpl = com.roily.configway.byannotation.service.impl.DefaultLogImpl.class)
    private ILog iLog;


    @Pointcut(value = "execution(* com.roily.configway.byannotation.service.impl.*.*(..))")
    private void pointCut() {
    }

    /**
     * 环绕通知
     *
     * @param pjp 切入点信息
     * @return
     * @throws Throwable
     */
    @Around("pointCut()  && this(iLog)")
    public Object around(ProceedingJoinPoint pjp, ILog iLog) throws Throwable {
        iLog.log();
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
        iLog.log();
        System.out.println("前置通知");
    }


    /**
     * 最终通知
     *
     * @return
     */
    @After("pointCut() && this(iLog)")
    public void after(ILog iLog) {
        System.out.println("最终通知");
    }

    /**
     * 后置通知
     *
     * @return
     */
    @AfterReturning(value = "pointCut() && this(iLog)", returning = "result")
    public void afterReturning(String result, ILog iLog) {
        System.out.println("后置通知,返回值：" + result);
    }

    /**
     * 异常通知
     *
     * @return
     */
    @AfterThrowing(value = "pointCut() && this(iLog)", throwing = "e")
    public void afterThrowing(Exception e, ILog iLog) {
        System.out.println("异常通知，异常" + e.getMessage());
    }

}
