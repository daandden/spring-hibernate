package com.luv2code.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    // do the same for service and dao
    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display the method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=========> in @Before: calling method: " + method);

        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru and display args
        myLogger.info(Arrays.toString(args));
    }


    // add @AfterReturning advice
    @AfterReturning (
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=========> in @AfterReturning: from method: " + method);

        myLogger.info("=======> result: " + result);
    }
}
