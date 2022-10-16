package com.roily.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022/09/26/16:10
 * @Description:
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 任意返回值
     * com.roily.service包下任意方法  （。。）代表任意参数的方法
     */
    @Pointcut("execution(* com.roily.service.*.*(..))")
    public void pointCut() {

    }


    @Around("pointCut()")
    public Object logAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        final Method method = signature.getMethod();
        System.out.println("===================================");
        System.out.println("方法名=>"+method.getName());
        System.out.println("方法参数=>");
        Arrays.asList(method.getParameters()).forEach(System.out::print);
        System.out.println("执行中。。。。。");
        final Object proceed = proceedingJoinPoint.proceed();
        System.out.println("执行结束。。。。。");
        System.out.println("===================================");
        return proceed;
    }

    public static void main(String[] args) {

        final List<String> list = Arrays.asList(new String[0]);


    }
}
