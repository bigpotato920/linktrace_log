package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppFoodPageVo;
import com.bigpotato.vo.AppPoiPageVo;
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
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getAppFoodPage() {
		AppFoodPageVo appFoodPageVo = new AppFoodPageVo();
		return AppCommonUtil.constructResponse(0, "success", appFoodPageVo);
	}
}