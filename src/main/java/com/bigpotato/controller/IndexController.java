package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.vo.AppPoiPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * App首页接口
 */
@Controller
@RequestMapping("/")
public class IndexController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getAppPoiPage() {

		AppPoiPageVo appPoiPageVo = new AppPoiPageVo();
		logger.warn("#IndexController getAppPoiPage#appPoiPageVo = {}", appPoiPageVo.toString());
		return AppCommonUtil.constructResponse(0, "success", appPoiPageVo);
	}
}