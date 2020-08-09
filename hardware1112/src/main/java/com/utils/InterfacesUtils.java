package com.utils;

import com.bean.Qxpre;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mapper.QxpreMapper;
import net.sf.json.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterfacesUtils {
    public static ArrayList<String> dop(QxpreMapper qxpreMapper) {
        ArrayList<String> a = new ArrayList<>();
        List<Qxpre> qxpres = qxpreMapper.selectQxpreTokAll();
        for (int i = 0; i < qxpres.size(); i++) {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\"apiCode\":\"GetDeviceList\"\n}");
            Request request = new Request.Builder()
                    .url("http://api.xy-aiot.com/rest/api/v1")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-Access-Token", qxpres.get(i).getTOKEN())
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                String json = response.body().string();
                //接受json 数据
                JSONObject jb = JSONObject.fromObject(json);
                //判断是否存在主体信息
                if (jb.containsKey("data")) {
                    //data对象
                    JsonObject ob = new JsonParser().parse(json).getAsJsonObject().get("data").getAsJsonObject();
                    //deviceList数组
                    JsonArray arr = ob.get("deviceList").getAsJsonArray();
                    for (int j = 0; j < arr.size(); j++) {
                        //将SN循环添加到集合中
                        String sn = arr.get(j).getAsJsonObject().get("SN").getAsString();
                        a.add(sn);
                        return a;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
