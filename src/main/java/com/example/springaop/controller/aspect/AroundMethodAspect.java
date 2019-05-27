package com.example.springaop.controller.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;


@Aspect
@Component
public class AroundMethodAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.example.springaop.controller.GreetingController.greeting(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        ZonedDateTime timeBeforeInvoke = ZonedDateTime.now();
        Object result = joinPoint.proceed();
        long millis = Duration.between(timeBeforeInvoke,  ZonedDateTime.now()).toMillis();

        logger.info("Invoking \"{}\" in {} ms", joinPoint.getSignature().getName(), millis);
        return result;
    }

}