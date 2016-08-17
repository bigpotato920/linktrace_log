package com.bigpotato.service;

import com.bigpotato.vo.AppPoiPageVo;
import com.bigpotato.vo.AppPoiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 首页服务类
 * Created by hjy on 16/8/13.
 */
@Service
public class AppPoiService {
    @Autowired
    private BaseAppPoiService appPoiService;

    public AppPoiVo getPoiById(long poiId) {
        AppPoiVo appPoiVo = new AppPoiVo();
        appPoiVo.setPoiId(poiId);
        appPoiVo.setPoiName("测试店");

        appPoiService.test();
        return appPoiVo;
    }
}
