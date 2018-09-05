package com.bigpotato.controller;

import com.bigpotato.common.util.AppCommonUtil;
import com.bigpotato.service.IndexService;
import com.bigpotato.service.SameNameInterface;
import com.bigpotato.vo.AppPoiPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * App首页接口
 */
@Controller
@RequestMapping("/")
public class IndexController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private IndexService indexService;
	@Resource
	private SameNameInterface sameNameInterface;
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object getAppPoiPage() {

		AppPoiPageVo appPoiPageVo = new AppPoiPageVo();
		indexService.getName();
		logger.warn("#IndexController getAppPoiPage#appPoiPageVo = {}", appPoiPageVo.toString());
		return AppCommonUtil.constructResponse(0, "success", appPoiPageVo);
	}
}