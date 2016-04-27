package com.bigpotato.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by hjy on 4/27/16.
 */
public class LogCommonTraceInterceptor implements AfterReturningAdvice {
    private final static Logger logger = LoggerFactory.getLogger(LogCommonTraceInterceptor.class);

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        logger.warn("#LogCommonTraceInterceptor afterReturning#targetClass = {}, methodName = {}", target.getClass().getSimpleName(),
                method.getName());
    }
}
