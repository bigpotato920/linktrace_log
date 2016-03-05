package com.bigpotato.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 给客户端返回的订单列表页vo对象
 * Created by hjy on 3/5/16.
 */
public class AppOrderPageVo {
    @JSONField(name = "page_index")
    private int pageIndex = 0;
    @JSONField(name = "page_count")
    private int pageCount = 0;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
