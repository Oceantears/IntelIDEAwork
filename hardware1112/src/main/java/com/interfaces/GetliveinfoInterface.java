package com.interfaces;

import com.bean.Qxpre;
import com.mapper.QxpreMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GetliveinfoInterface {
    public static List<String> dop(String z, QxpreMapper qxpreMapper) throws IOException {
        List<String>list=new ArrayList<String>();
        List<Qxpre> qxpres =qxpreMapper.selectQxpreTokAll();

        for ( int i = 0; i < qxpres.size(); i++ ) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\"apiCode\":\"GetLiveInfo\", \"SN\": \"" + z + "\"\r\n}");
        Request request = new Request.Builder()
                .url("http://api.xy-aiot.com/rest/api/v1")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Access-Token", qxpres.get(i).getTOKEN())
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "fa867ed8-e75b-4132-b082-de6e3da73234")
                .build();

        Response response = client.newCall(request).execute();
        String aa = response.body().string();

            list.add(aa);
        }

        return list;
    }
}
