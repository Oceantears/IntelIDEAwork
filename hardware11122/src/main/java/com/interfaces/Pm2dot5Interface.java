package com.interfaces;

import com.bean.Qxpre;
import com.mapper.QxpreMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pm2dot5Interface {
    public static List<String> dop(String z, QxpreMapper qxpreMapper) {
        List<String> list = new ArrayList<String>();
        List<Qxpre> qxpres = qxpreMapper.selectQxpreTokAll();
        for (int i = 0; i < qxpres.size(); i++) {
            try {
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\r\n\"apiCode\": \"GetLastSingleData\", \"timestamp\": null, \"queries\": [{ \"metric\": \"pm2dot5\", \"tags\": { \"SN\": \"" + z + "\"\r\n}\r\n}]\r\n}");
                Request request = new Request.Builder()
                        .url("http://api.xy-aiot.com/rest/api/v1")
                        .post(body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("X-Access-Token", qxpres.get(i).getTOKEN())
                        .addHeader("cache-control", "no-cache")
                        .addHeader("Postman-Token", "140fd92a-53cf-4b0b-844b-06aa2e3a66e4")
                        .build();
                Response response = null;
                response = client.newCall(request).execute();
                String aa = response.body().string();
                list.add(aa);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
