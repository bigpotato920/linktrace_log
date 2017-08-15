package com.bigpotato.common.aspect;

import com.google.common.base.CaseFormat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class FunctionDegradationAspect {
    private final static Logger logger = LoggerFactory.getLogger(FunctionDegradationAspect.class);

    @Pointcut("execution(* com.bigpotato.service.*.*(..)) && @annotation(FunctionDegradation)")
    public void functionDegradation() {
    }

    @Around("functionDegradation()")
    public void judgeWeatherDegradation(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getClass().getSimpleName();
        String switchName = guessSwitchNameFromClassName(className);
        if (!isSwitchOpen(switchName)) {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }


    private boolean isSwitchOpen(String switchName) {
        return false;
    }

    private String guessSwitchNameFromClassName(String className) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, className);
    }

}
