package com.sample.aon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * This class implements logging using Aspect Spring placing logs
 * outside of business class that makes code clean and readable.
 * Advice annotation suggests moment to execute code to log activity, time and duration.
 */
@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Runs just before execution
    @Before(value = "execution (* com.sample..*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        long time = System.currentTimeMillis();
        logger.info("Thread: {} method: {} time: {} starting...", Thread.currentThread().getName(), joinPoint.getSignature(), time);
    }

    // Runs just after execution
    @After(value = "execution (* com.sample..*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        long time = System.currentTimeMillis();
        logger.info("Thread: {} method: {} time: {} exit", Thread.currentThread().getName(), joinPoint.getSignature(), time);
    }

    // Executes before and after joint point, log method call duration
    @Around(value = "execution (* com.sample..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("Thread: {} method: {} duration: {} milliseconds", Thread.currentThread().getName(), joinPoint.getSignature(), duration);
    }
}
