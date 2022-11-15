package com.roily.root.demo.aboutaop.common.aspect.aspect;

import com.roily.root.demo.aboutaop.common.aspect.annotation.MethodLogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @classname：MethodLogAspect
 * @author: rolyfish
 * @description: 方法日志切面
 * @date: 2022/9/5 23:18
 */
@Aspect
@Component
@Slf4j
public class MethodLogAspect {


    @Around("@annotation(com.roily.root.demo.aboutaop.common.aspect.annotation.MethodLogAnnotation)")
    public void log(ProceedingJoinPoint pjp){

        final Method signature = ((MethodSignature)pjp.getSignature()).getMethod();
        final MethodLogAnnotation annotation = signature.getAnnotation(MethodLogAnnotation.class);
        log.info("业务类型:{}",annotation.businessType());
        log.info("描述信息:{}",annotation.desc());

    }

}
