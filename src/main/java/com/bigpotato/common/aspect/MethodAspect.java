package com.bigpotato.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用日志拦截
 * Created by hjy on 4/28/16.
 */
@Aspect
@Component
public class MethodAspect {
    private final static Logger logger = LoggerFactory.getLogger(MethodAspect.class);


    @Around("execution(* com.bigpotato.common.util.AppCommonUtil.*(..))")
    public void recordLog(ProceedingJoinPoint joinPoint) {
        Object returnVal = null;
        try {
            returnVal = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("#MethodAspect recordLog#", throwable);
        } finally {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            logger.warn("#MethodAspect recordLog#{} {}:request = {}, response = {}",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    req.getParameterMap(), returnVal);
        }
    }

}
