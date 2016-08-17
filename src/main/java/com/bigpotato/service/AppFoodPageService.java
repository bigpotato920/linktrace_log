package com.bigpotato.service;

import com.bigpotato.vo.AppFoodPageVo;
import com.bigpotato.vo.AppPoiPageVo;
import com.bigpotato.vo.AppPoiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 点菜页服务类
 * Created by hjy on 16/8/13.
 */
@Service
public class AppFoodPageService {
    @Autowired
    private AppPoiService appPoiService;
    @Autowired
    private AppProductService appProductService;

    public AppFoodPageVo buildFoodPage(long poiId) {
        AppFoodPageVo appFoodPageVo = new AppFoodPageVo();

        AppPoiVo appPoiVo = appPoiService.getPoiById(poiId);

        appFoodPageVo.setPageIndex(0);
        appFoodPageVo.setPageCount(100);
        appFoodPageVo.setAppPoiVo(appPoiVo);
        appProductService.getAllProducts();
        return appFoodPageVo;
    }
}
