package com.ridham.userProfile.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerClass {

    @Around("execution(* com.ridham.userProfile..*(..))")
    public Object loggingmethod(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodname = methodSignature.getName();

        System.out.println("Inside "+className+ ", executing method: "+methodname);

        Object obj = joinPoint.proceed();
        System.out.println("Inside "+className+ ", exiting method: "+methodname);
        System.out.println(joinPoint.toString());
        return obj;
    }
}
