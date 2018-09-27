package com.wuxun.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** 
 * 日志切面 
 */  
@Aspect
@Component
public class LogAspect {  

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.wuxun.demo..*.*(..))")  
    public void webLog(){}  
  
    // @Before("webLog()")  
    // public void deBefore(JoinPoint joinPoint) throws Throwable {  

    //     logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + " Start");
  
    // }  
  
    // @AfterReturning("webLog()")  
    // public void doAfterReturning(JoinPoint joinPoint) throws Throwable {  
    //     logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + " End");
    // }  
  
    // //后置异常通知  
    // @AfterThrowing("webLog()")  
    // public void throwss(JoinPoint jp){  
    //     System.out.println("方法异常时执行.....");  
    // }  
  
    // //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
    // @After("webLog()")  
    // public void after(JoinPoint jp){  
    //     System.out.println("方法最后执行.....");  
    // }  
  
    //环绕通知,环绕增强，相当于MethodInterceptor  
    @Around("webLog()")  
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {  
        logger.info(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName() + " Start");
        try {  
            Object o =  pjp.proceed();  
            logger.info( pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName() + " End");
            return o;  
        } catch (Throwable e) {  
            logger.error("Exception in logAspect!");
            throw e;
        }  
    }  
}  