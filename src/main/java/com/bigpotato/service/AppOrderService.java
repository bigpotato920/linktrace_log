package com.bigpotato.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hjy on 4/28/16.
 */
@Service
public class AppOrderService {
    private final static Logger logger = LoggerFactory.getLogger(AppOrderService.class);

    @Autowired
    private AppFoodService appFoodService;

    public AppOrderService() {
        logger.warn("AppOrderService...");
    }

    public void test() {

    }
}
