package com.roily.configway.byxml.common;

import com.roily.configway.byxml.service.ILog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @classname：LogAspectJ
 * @author: rolyfish
 * @description: 日志切面
 * @date: 2022/10/14 14:29
 */
public class LogAspectJ {

    /**
     * 环绕通知
     *
     * @param pjp 切入点信息
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp, ILog iLog) throws Throwable {
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
    public void before(ILog iLog) {
        iLog.log();
        System.out.println("前置通知");
    }


    /**
     * 最终通知
     *
     * @return
     */
    public void after(ILog iLog) {
        System.out.println("最终通知");
    }

    /**
     * 后置通知
     *
     * @return
     */
    public void afterReturning(String result, ILog iLog) {
        System.out.println("后置通知,返回值：" + result);

    }

    /**
     * 异常通知
     *
     * @return
     */
    public void afterThrowing(Exception e, ILog iLog) {
        System.out.println("异常通知，异常" + e.getMessage());
    }

}
