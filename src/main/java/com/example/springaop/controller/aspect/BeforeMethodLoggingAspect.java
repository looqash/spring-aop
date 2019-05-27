package com.example.springaop.controller.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Aspect
@Component
public class BeforeMethodLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    List<String> superUsers = Arrays.asList("admin");

    @Before("execution(* com.example.springaop.controller.GreetingController.greeting(..))")
    public void before(JoinPoint joinPoint) {

        Object name = joinPoint.getArgs()[0];
        if(isAdmin(name)){
            logger.info("Greetings to admin \"{}\"", name);
        }
        else{
            logger.info("Greetings to user \"{}\"", name);
        }

    }

    private boolean isAdmin(Object name) {
        return superUsers.contains(name);
    }

}