package com.bigpotato.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hjy on 4/27/16.
 */
public class MvcBasicServletBean {
    private final static Logger logger = LoggerFactory.getLogger(MvcBasicServletBean.class);
    public MvcBasicServletBean() {
        logger.debug("#MvcBasicServletBean constructor execute...#");
    }
}
