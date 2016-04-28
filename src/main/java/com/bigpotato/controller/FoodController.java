package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppFoodPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * App商品列表页接口
 */
@Controller
@RequestMapping("/food")
public class FoodController {

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public Object getAppFoodPage() {
		AppFoodPageVo appFoodPageVo = new AppFoodPageVo();
		return AppCommonUtil.constructResponse(0, "success", appFoodPageVo);
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object foodDetail() {
		AppFoodPageVo appFoodPageVo = new AppFoodPageVo();
		return AppCommonUtil.constructResponse(0, "success", appFoodPageVo);
	}
}