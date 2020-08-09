package com.controller;

import com.bean.Winddirection;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.WinddirectionInterface;
import com.mapper.QxpreMapper;
import com.mapper.WinddirectionMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WinddirectionController {
    private static final Logger log = LoggerFactory.getLogger(WinddirectionController.class);

    public static void dop(ArrayList<String> array, Winddirection win, WinddirectionMapper WinddirectionMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            System.out.println(s);
            //调用风速工具类
            List<String> aa = WinddirectionInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        win.setKEYID(WinddirectionMapper .idPlusWinddirection());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        win.setWI_DATE(date);
                        win.setWINDDIRECTION(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        win.setSN(s);
                        //执行数据存入操作
                        WinddirectionMapper.insertWinddirection(win);
                        log.info("风向数据入库成功===-----");
                    }
                }else{
                    /*win.setKEYID(WinddirectionMapper .idPlusWinddirection());
                    win.setWI_DATE(null);
                    win.setSN(s);
                    win.setWINDDIRECTION(0);
                    WinddirectionMapper.insertWinddirection(win);*/

                    continue;
                }

            }

        }
    }
}