package com.bigpotato.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hjy on 18/9/5
 */
@Component
@Aspect
public class ControllerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object httpLog(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            LOGGER.warn("reqURL = {}", request.getRequestURL());
        }

        return result;

    }
}
