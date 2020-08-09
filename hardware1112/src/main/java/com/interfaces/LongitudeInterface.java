package com.interfaces;

import com.bean.Qxpre;
import com.mapper.QxpreMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LongitudeInterface {

    public static List<String> dop(String z, QxpreMapper qxpreMapper) throws IOException {
        long ss = Calendar.getInstance().getTimeInMillis() / 1000;


        List<String>list=new ArrayList<String>();
        List<Qxpre> qxpres =qxpreMapper.selectQxpreTokAll();

        for ( int i = 0; i < qxpres.size(); i++ ) {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        //{ "apiCode": "GetLastSingleData", "timestamp": null, "queries": [{ "metric": "longitude", "tags": { "SN": "0018DE743E31" } }] }
        RequestBody body = RequestBody.create(mediaType, "{ \"apiCode\": \"GetLastSingleData\", \"timestamp\":null, \"queries\": [{ \"metric\": \"longitude\", \"tags\": { \"SN\": \""+z+"\" } }] }");
        // RequestBody body = RequestBody.create(mediaType, "{\n\"apiCode\":\"GetDeviceList\"\n}");
        Request request = new Request.Builder()
                .url("http://api.xy-aiot.com/rest/api/v1")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Access-Token", qxpres.get(i).getTOKEN())
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "37dd7c87-8f16-4158-8bc3-3cdf8a2e16d5")
                .build();
        Response response = client.newCall(request).execute();
        String aa=response.body().string();


            list.add(aa);
        }

        return list;
    }
}
