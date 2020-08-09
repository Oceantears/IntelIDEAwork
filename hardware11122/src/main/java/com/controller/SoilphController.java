package com.controller;

import com.bean.Soilph;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.SoilphInterface;
import com.mapper.QxpreMapper;
import com.mapper.SoilphMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoilphController {
    private static final Logger log = LoggerFactory.getLogger(SoilphController.class);

    public static void dop(ArrayList<String> array, Soilph soilph, SoilphMapper SoilphMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            //调用土壤ph工具类
            List<String> aa = null;
            try {
                aa = SoilphInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("土壤ph请求超时！",e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        soilph.setKEYID(SoilphMapper.idPlusSoilph());
                        Date date = new Date();
                        soilph.setSO_DATE(date);
                        soilph.setSOILPH(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        soilph.setSN(s);
                        //执行数据存入操作
                        SoilphMapper.insertSoilph(soilph);
                    }
                } else {
                    /*soilph.setKEYID(SoilphMapper.idPlusSoilph());
                    soilph.setSO_DATE(null);
                    soilph.setSN(s);
                    soilph.setSOILPH(0);
                    SoilphMapper.insertSoilph(soilph);
*/
                    continue;
                }
            }
        }
    }

}
