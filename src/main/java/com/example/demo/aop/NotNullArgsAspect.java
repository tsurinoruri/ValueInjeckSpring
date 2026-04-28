package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotNullArgsAspect {

    @Around("@annotation(NotNull)")
    public Object checkNotNullArgs(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getMethod().getName();

        System.out.println("=== Аспект сработал для метода: " + methodName + " ===");

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
            if (args[i] == null) {
                String error = String.format("%s arg[%d] is null", methodName, i);
                System.out.println("!!! Найден null аргумент: " + error);
                throw new IllegalArgumentException(error);
            }
        }

        System.out.println("Все аргументы валидны, выполняем метод");
        return pjp.proceed();
    }
}