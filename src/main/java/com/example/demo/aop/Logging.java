package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {
    private Object result;
//    @Before("execution(* com.example.demo.TaskExecutor.work(..))")
//    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Перед вызовом метода: " + joinPoint.getSignature().getName());
//    }
//
//    @AfterReturning(value = "execution(* com.example.demo.TaskExecutor.work(..))", returning = "result")
//    public void afterLog(JoinPoint joinPoint, Object result){
//        System.out.println("после выполнения " + joinPoint.getSignature().getName() + " результат "+ result);
//    }
//
//    @AfterThrowing( value = "execution(* com.example.demo.TaskExecutor.work(..))", throwing = "exc")
//    public void afterThrowing(JoinPoint joinPoint, Exception exc){
//        System.out.println("Было выброшено исключение " + exc.getMessage());
//    }
//
//    //отрабатывает всегда
//    @After("execution(* com.example.demo.TaskExecutor.work(..))")
//    public void finaly(JoinPoint joinPoint){
//        System.out.println("После выполнения метода " + joinPoint.getSignature().getName());
//    }

    @Around("execution(* com.example.demo.TaskExecutor.work(..))") //полностью оборачивает исполнение определенного метода до и помле него
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //До вызова метода
        System.out.println("до метода");
        Object result = proceedingJoinPoint.proceed();
        //после выхзова метода
        System.out.println("после метода");
        return result;
    }
}
