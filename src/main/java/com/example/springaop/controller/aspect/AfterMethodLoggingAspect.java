package com.example.springaop.controller.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AfterMethodLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(pointcut = "execution(* com.example.springaop.controller.GreetingController.greeting(..))",
            returning= "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
            logger.info("Result \"{}\"", result);
    }

}