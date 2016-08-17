package com.bigpotato.vo;

/**
 * POI VO类
 * Created by hjy on 16/8/13.
 */
public class AppPoiVo {
    private long poiId = 0L;
    private String poiName = "";

    public long getPoiId() {
        return poiId;
    }

    public void setPoiId(long poiId) {
        this.poiId = poiId;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    @Override
    public String toString() {
        return "AppPoiVo{" +
                "poiId=" + poiId +
                ", poiName='" + poiName + '\'' +
                '}';
    }
}
