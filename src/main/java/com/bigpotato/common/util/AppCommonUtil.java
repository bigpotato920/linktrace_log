package com.bigpotato.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bigpotato.common.aspect.ColorEnum;

/**
 * Created by hjy on 3/5/16.
 */
public class AppCommonUtil {

    /**
     * 构造给客户端的json字符串
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static JSONObject constructResponse(int code, String msg, Object data) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("data", JSON.toJSON(data));
        jo.put("color", ColorEnum.BLANK.getValue());
        return jo;
    }
}
