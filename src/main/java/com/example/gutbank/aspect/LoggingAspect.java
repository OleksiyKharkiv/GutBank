package com.example.gutbank.aspect;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component@Slf4j
@Aspect
public class LoggingAspect {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("within(com.example.gutbank.controller..*) || within(com.example.gutbank.service..*)")
    public void applicationPackagePointcut() {}

    @Before("applicationPackagePointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Method " + joinPoint.getSignature().getName() + " started with args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "returnValue")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returnValue) {
        logger.info("Method " + joinPoint.getSignature().getName() + " completed with return value: " + returnValue);
    }
}
