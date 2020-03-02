package com.sapient.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Around("@annotation(com.sapient.aspect.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        //long startTime = System.currentTimeMillis();
    	final StopWatch stopWatch = new StopWatch();
    	stopWatch.start();
        joinPoint.proceed();
        stopWatch.stop();
        //long timeTaken = System.currentTimeMillis() - startTime;
        long timeTaken= stopWatch.getTotalTimeMillis();
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }
}