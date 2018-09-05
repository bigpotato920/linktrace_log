package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.service.inner.SameNameInterface;
import com.bigpotato.vo.AppFoodPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * App商品列表页接口
 */
@Controller
@RequestMapping("/food")
public class FoodController {
	@Resource
	private SameNameInterface sameNameInterface;

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