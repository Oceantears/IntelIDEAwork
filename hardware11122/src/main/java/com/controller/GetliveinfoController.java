package com.controller;

import com.bean.Getliveinfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.GetliveinfoInterface;
import com.mapper.GetliveinfoMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetliveinfoController {
    private static final Logger log = LoggerFactory.getLogger(GetliveinfoController.class);

    public static void dop(ArrayList<String> array, Getliveinfo get, GetliveinfoMapper getliveinfoMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            //调用视频工具类
            List<String> aa = null;
            try {
                aa = GetliveinfoInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("智慧树视频请求超时！", e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonObject userOb = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonObject();
                    //视频路径
                    JsonElement livePlayUrl = userOb.get("hlsLivePlayUrl");
                    String s1 = livePlayUrl.toString();
                    String c = s1.substring(1, s1.length() - 1);
                    //封面路径
                    JsonElement jpgUrl = userOb.get("liveCoverUrl");
                    String s2 = jpgUrl.toString();
                    String b = s2.substring(1, s2.length() - 1);
                    Date dates = new Date();
                    get.setKEYID(getliveinfoMapper.idPlusGetliveinfo());
                    get.setGE_DATE(dates);
                    get.setGETLIVEINFO(c);
                    get.setGEJPG(b);
                    get.setSN(s);
                    getliveinfoMapper.insertgetliveinfo(get);
                } else {
                    /*get.setKEYID(getliveinfoMapper.idPlusGetliveinfo());
                    get.setGE_DATE(null);
                    get.setSN(s);
                    get.setGETLIVEINFO(null);
                    getliveinfoMapper.insertgetliveinfo(get);*/
                    continue;
                }
            }
        }
    }
}
