package com.bigpotato.mockito;

import com.bigpotato.service.AppFoodPageService;
import com.bigpotato.service.AppPoiService;
import com.bigpotato.service.AppProductService;
import com.bigpotato.vo.AppFoodPageVo;
import com.bigpotato.vo.AppPoiPageVo;
import com.bigpotato.vo.AppPoiVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Mockito demo
 * Created by hjy on 16/8/13.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:applicationContext.xml", "classpath:mvc-basic-servlet.xml",
//"classpath:mvc-extended-servlet.xml"})

@RunWith(MockitoJUnitRunner.class)
public class MockitoPractice {
    @InjectMocks()
    private AppFoodPageService appFoodPageService;

    @Mock
    private AppPoiService appPoiService;

    @Mock
    private AppProductService appProductService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInjectMockIndex() {
        AppPoiVo mockedAppPoiVo = new AppPoiVo();
        mockedAppPoiVo.setPoiName("1号测试店");
        mockedAppPoiVo.setPoiId(1);

//        when(appPoiService.getPoiById(anyLong())).thenReturn(mockedAppPoiVo);
        doReturn(mockedAppPoiVo).when(appPoiService).getPoiById(anyLong());
        assertNotNull(appPoiService.getPoiById(1L));
        AppFoodPageVo appFoodPageVo = appFoodPageService.buildFoodPage(1);
        assertNotEquals(null, appFoodPageVo);
        assertNotEquals(null, appFoodPageVo.getAppPoiVo());
        assertEquals("1号测试店", appFoodPageVo.getAppPoiVo().getPoiName());
    }
}
