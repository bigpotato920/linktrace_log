package com.bigpotato.controller;

import com.bigpotato.common.log.LogCustomPointcut;
import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppFoodPageVo;
import com.bigpotato.vo.AppPoiPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * App商品列表页接口
 */
@Controller
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private LogCustomPointcut logCustomPointcut;
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getAppFoodPage() {
		AppFoodPageVo appFoodPageVo = new AppFoodPageVo();
		logCustomPointcut.insert();
		return AppCommonUtil.constructResponse(0, "success", appFoodPageVo);
	}
}