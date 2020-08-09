package com.controller;

import com.bean.Accesstoken;
import com.bean.Camera;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mapper.AccesstokenMapper;
import com.mapper.CameraMapper;
import com.utils.Token;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccesstokenController {

    private static final Logger log = LoggerFactory.getLogger(AccesstokenController.class);

    public static void token(AccesstokenMapper accesstokenMapper, Integer id, Camera cam, CameraMapper cameraMapper) {
        //获取海康token值
        String tok = Token.tok(accesstokenMapper, id);
        JSONObject jb = JSONObject.fromObject(tok);
        if (jb.containsKey("data")) {
            try {
                Accesstoken selectAll = accesstokenMapper.selectByID(id);
                //data数组
                JsonObject userOb = new JsonParser().parse(tok).getAsJsonObject().get("data").getAsJsonObject();
                String accessToken = userOb.get("accessToken").getAsString();
                String expireTime = userOb.get("expireTime").getAsString();
                Long l = Long.valueOf(expireTime);
                Date date = new Date(System.currentTimeMillis() - 28800000);
                date.setTime(l);
                String format = new SimpleDateFormat().format(date);
                SimpleDateFormat sdf = new SimpleDateFormat();
                Date date1 = sdf.parse(format);
                Date date2 = new Date();
                selectAll.setKEYID(selectAll.getKEYID());
                selectAll.setAccessToken(accessToken);
                Integer num = selectAll.getUseNum();
                selectAll.setUseNum(++num);
                selectAll.setLoseTime(date1);
                selectAll.setGetTime(date2);
                Accesstoken accesstoken = accesstokenMapper.selectID(selectAll);
                if (accesstoken != null) {
                    accesstokenMapper.updateAccesstoken(selectAll);
                    log.info("修改token成功！");
                    CameraController.Camera(cam, cameraMapper, accesstokenMapper);
                } else {
                    accesstokenMapper.insertAccesstoken(selectAll);
                    log.info("添加token成功！");
                    CameraController.Camera(cam, cameraMapper, accesstokenMapper);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                log.error("解析异常" + e);
            }
        }
    }
}
