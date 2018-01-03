package com.excel.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutorAspect {


    @Before(value = "within(com.excel.core.ex.impl.*)")
    public void beforeBegin() {

        System.out.println("AOP ---------------------------------");

    }


}