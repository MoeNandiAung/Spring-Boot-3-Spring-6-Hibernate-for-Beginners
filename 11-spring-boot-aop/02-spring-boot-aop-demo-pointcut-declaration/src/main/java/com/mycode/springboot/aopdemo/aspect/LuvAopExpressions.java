package com.mycode.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.mycode.springboot.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.mycode.springboot.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create a pointcut for setter mehtods
    @Pointcut("execution(* com.mycode.springboot.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create a pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void  forDaoPackageNoGetterSetter() {}



}
