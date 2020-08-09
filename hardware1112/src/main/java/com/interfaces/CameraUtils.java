package com.interfaces;

import okhttp3.*;

import java.io.IOException;

public class CameraUtils {
    public static String came(String str) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "appKey=21dc9e0881ab4836ba7e6a09dea32409&appSecret=4bd570082135b2327f9095d5de05b005&accessToken="+str+"");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/live/video/list")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "aa6bf58b-2e76-4c9f-b0c4-6febcccd7a4f")
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
