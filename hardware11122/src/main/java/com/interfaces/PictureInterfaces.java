package com.interfaces;

import com.bean.Accesstoken;
import com.bean.Qxpre;
import com.controller.SoilphController;
import com.mapper.AccesstokenMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PictureInterfaces {
    private static final Logger log = LoggerFactory.getLogger(PictureInterfaces.class);

    public static List<String> dop(String str, AccesstokenMapper accesstokenMapper) {
        List<String> list = new ArrayList<String>();
        List<Accesstoken> accesstokens = accesstokenMapper.selectAll();
        for (int i = 0; i < accesstokens.size(); i++) {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "appKey=21dc9e0881ab4836ba7e6a09dea32409&appSecret=4bd570082135b2327f9095d5de05b005&accessToken=" + accesstokens.get(i).getAccessToken() + "&deviceSerial=" + str + "&undefined=");
            Request
                    request = new Request.Builder()
                    .url("https://open.ys7.com/api/lapp/device/capture")
                    .post(body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("Postman-Token", "4ae385a2-9d87-4761-a025-3da748012909")
                    .build();
            Response response = null;
            try {
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
