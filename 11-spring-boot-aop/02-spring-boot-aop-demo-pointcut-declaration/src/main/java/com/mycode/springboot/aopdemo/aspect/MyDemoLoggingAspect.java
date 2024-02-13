package com.mycode.springboot.aopdemo.aspect;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import com.mycode.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // lets start with an @Before advice

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.mycode.springboot.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")

    // add a new advice for @AfterReturning on the findAccounts method
    @Around("execution(* com.mycode.springboot.aopdemo.service.*.getFortune(..))")

    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        // print out method we are advising on
        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @Around on method: "+ method);


        // get begin timestamp
        long begin = System.currentTimeMillis();
        Object result = null;
        try{
            // now, let's execute the method
            result = theProceedingJoinPoint.proceed();

        }
        catch(Exception exc)
        {
            // log the exception
            System.out.println(exc.getMessage());
            // rethrow
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        //  compute duration and display it
        long duration = end - begin;
        System.out.println("\n========> Duration: "+ duration / 1000.0 + " seconds");
        return result;
    }
    @After("execution(* com.mycode.springboot.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint)
    {
        // print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @After on method: "+ method);

    }


    //
    @AfterThrowing(pointcut = "execution(* com.mycode.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExc)
    {
        // print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterThrowing on method: "+ method);

        // log the exception
        System.out.println("\n==========> result is : "+ theExc);



    }
    @AfterReturning(pointcut = "execution(* com.mycode.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> result)
    {
        // print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterReturning on method: "+ method);
        // print out the results of the method call
        System.out.println("\n==========> result is : "+ result);

        // let's post-process the data .... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n==========> Executing @AfterReturning on method: "+ method);
        // print out the results of the method call
        System.out.println("\n==========> result is : "+ result);




    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts

        // get uppercase version of names

        // update the name on the account
        for(Account tempAccount: result)
        {
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }


    @Before("com.mycode.springboot.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        System.out.println("\n=========>>>>>> Exceuting @Before advice on addAccount()");


        // display the method signature
        MethodSignature methodSignature  = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+ methodSignature);


        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop thru args
        for(Object tempArg: args)
        {
            System.out.println(tempArg);
            if(tempArg instanceof Account)
            {
                // downcast and print Accoutn specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("account name: "+ theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }
    }








}
