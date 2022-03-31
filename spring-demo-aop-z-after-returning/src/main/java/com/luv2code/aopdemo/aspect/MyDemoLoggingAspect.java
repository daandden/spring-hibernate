package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "results"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> results) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n============>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n====>> Result is: " + results);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(results);
        System.out.println("\n====>> UpperCase Result is: " + results);
    }


    private void convertAccountNamesToUpperCase(List<Account> results) {
        for (Account result : results) {
            result.setName(result.getName().toUpperCase());
        }
    }



    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {

                // downcast and print Account specific stuff
                Account account = (Account) arg;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

    }
}
