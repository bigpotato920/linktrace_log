package com.bigpotato.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class LogCommonAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogCommonAspect.class);

    @Pointcut("execution(* com.bigpotato.controller.*.*(..))")
    public void commonController() {
    }

    @Around("commonController()")
    public void recordLog(ProceedingJoinPoint joinPoint) {
        Object returnVal = null;
        try {
            returnVal = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("#LogCommonAspect recordLog#", throwable);
        } finally {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            logger.warn("#LogCommonAspect recordLog#{} {}:request = {}, response = {}",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    req == null ? "" : req.getParameterMap(), returnVal);
        }


    }

}
