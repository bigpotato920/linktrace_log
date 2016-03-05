package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppOrderPageVo;
import com.bigpotato.vo.AppPoiPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getAppOrderPage() {
		AppOrderPageVo appOrderPageVo = new AppOrderPageVo();
		return AppCommonUtil.constructResponse(0, "success", appOrderPageVo);
	}
}