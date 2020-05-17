package com.keeper.app.KeeperApp.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //Logs for Get method
    @Before("execution(public * getAll())")
    public void beforeLog(){
        LOGGER.info("Get method was called");
    }
    @AfterReturning("execution(public * getAll())")
    public void returnLog(){
        LOGGER.info("Get method was executed successfully");
    }
    @AfterThrowing("execution(public * getAll())")
    public void afterLog(){
        LOGGER.info("Get method throws an exception");
    }

    //Logs for Delete Method
    @Before("execution(public * delete(..))")
    public void logDelete(){
        LOGGER.info("Delete method was called");
    }
    @AfterReturning("execution(public * delete(..))")
    public void logDeleteAfter(){
        LOGGER.info("Delete method was executed successfully");
    }

    //Logs for Add Method
    @Before("execution(public * add(..))")
    public void logAdd(){
        LOGGER.info("Add method was called");
    }
    @AfterReturning("execution(public * delete(..))")
    public void logAddAfter(){
        LOGGER.info("Add method was executed successfully");
    }


}
