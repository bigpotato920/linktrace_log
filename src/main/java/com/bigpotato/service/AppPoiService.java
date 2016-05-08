package com.bigpotato.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by hjy on 4/28/16.
 */
@Service
public class AppPoiService {
    private final static Logger logger = LoggerFactory.getLogger(AppPoiService.class);

    @Autowired
    private AppOrderService appOrderService;

    public AppPoiService() {
        logger.warn("#AppPoiService...#");
    }

    public void test() {

    }

    @PostConstruct
    public void postConstruct() {
        logger.warn("AppPoiService postConstruct");
    }
}
