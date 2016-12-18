package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppFoodPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hjy on 16/12/4.
 */
@Controller
@RequestMapping("/m")
public class TestController {
    @Autowired
    private FoodController foodController;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Object getAppFoodPage() {
        return foodController.getAppFoodPage();
    }
}
