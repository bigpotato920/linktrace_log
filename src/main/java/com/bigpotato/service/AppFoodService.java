package com.bigpotato.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by hjy on 4/28/16.
 */
@Service
public class AppFoodService {
    private final static Logger logger = LoggerFactory.getLogger(AppFoodService.class);
    public AppFoodService() {
        logger.warn("#AppFoodService ...#");
    }

    public void test() {

    }
}
