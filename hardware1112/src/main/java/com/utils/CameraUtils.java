package com.utils;

import okhttp3.*;

import java.io.IOException;

public class CameraUtils {
    public static String came(String str) {

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "accessToken=" + str + "&pageStart=0&pageSize=3&undefined=");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/live/video/list")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "560b912a-622a-466e-9c00-baf6529c1f93")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
