package com.example.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Log {
    int count = 0;

    @Pointcut("within(com.example.controller.*)")
    public void allMethod(){
    }
    @Before("allMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("Start Method name" +
                joinPoint.getSignature().getName()+
                " Time: "+ LocalDateTime.now());
    }
    @After("allMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        count++;
        System.out.println("End Method name" +
                joinPoint.getSignature().getName()+
                " Time: "+ LocalDateTime.now());
        System.out.println("Number of visits : " + count);
    }
    @AfterThrowing("allMethod()")
    public void afterException(JoinPoint joinPoint){
        System.out.println("Exception in : " +
                joinPoint.getSignature().getName() +
                "Time : " + LocalDateTime.now());
    }
}
