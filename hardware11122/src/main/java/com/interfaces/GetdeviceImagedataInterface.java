package com.interfaces;

import com.bean.Qxpre;
import com.mapper.QxpreMapper;
import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetdeviceImagedataInterface {
    public static List<String> dop(String z, QxpreMapper qxpreMapper) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String tt = dateFormat.format(date);
        List<String> list = new ArrayList<String>();
        List<Qxpre> qxpres = qxpreMapper.selectQxpreTokAll();
        for (int i = 0; i < qxpres.size(); i++) {
            try {
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\r\n\"apiCode\": \"GetDeviceImageData\", \"SN\": \"" + z + "\", \"pictureUploadDate\": \"" + tt + "\"\r\n}");
                Request request = new Request.Builder()
                        .url("http://api.xy-aiot.com/rest/api/v1")
                        .post(body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("X-Access-Token", qxpres.get(i).getTOKEN())
                        .addHeader("cache-control", "no-cache")
                        .addHeader("Postman-Token", "72cc3e07-6217-46f4-aa7b-679d9d2f60ba")
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
