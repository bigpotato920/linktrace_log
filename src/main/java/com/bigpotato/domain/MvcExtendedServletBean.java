package com.bigpotato.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hjy on 4/27/16.
 */
public class MvcExtendedServletBean {
    private final static Logger logger = LoggerFactory.getLogger(MvcExtendedServletBean.class);

    public MvcExtendedServletBean() {
        logger.warn("#MvcExtendedServletBean constructor execute...#");
    }
}
