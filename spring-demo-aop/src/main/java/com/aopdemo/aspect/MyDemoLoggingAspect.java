package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){};


    //@Before("execution(* addAccount(com.aopdemo.Account))")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }

    /*
    * for param-pattern
    * () matches a method with no args
    * (*) matches a method with one arg of any type
    * (..) matches a method with 0 or more args of any type
    * */


    /*example**
    * using *(asterisk) for wildcard
    * wildard uses @Before("execution(public * add*())")
    * //above pointcut will be applied methods starts with add and without checking return type)
    * */
}
