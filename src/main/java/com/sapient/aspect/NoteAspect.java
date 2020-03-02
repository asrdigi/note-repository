package com.sapient.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@Aspect
//@EnableAspectJAutoProxy
@Configuration
@Slf4j
public class NoteAspect {
   // private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @AfterReturning(value = "execution(* com.sapient.dao.*.*(..))",
        returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }
    
    @Before(value = "execution(* com.sapient.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("before execution of {}", joinPoint);
    }
        
    @AfterThrowing(value="execution(* com.sapient.dao.NoteRepository.find*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
    	log.info("Invalid Customer Id. Exception thrown by {}",
    			joinPoint.getSignature().getName());
    }
}