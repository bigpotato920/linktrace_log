package com.bigpotato.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by hjy on 4/27/16.
 */
@Component
public class LogCustomPointcut {
    private final static Logger logger = LoggerFactory.getLogger(LogCustomPointcut.class);

    public void insert() {
        logger.warn("#LogCustomPointcut insert#");
    }
}
