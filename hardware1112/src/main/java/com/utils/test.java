package com.utils;

import okhttp3.*;

import java.io.IOException;

public class test {

    public static void dop() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "AppKey=21dc9e0881ab4836ba7e6a09dea32409&Secret=4bd570082135b2327f9095d5de05b005");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/token/get")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "7cdff9ab-3caa-4fd0-9de0-2724324e042c")
                .build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();
        System.out.println(json);
    }

    public static void main(String[] args) throws IOException {
        test.dop();
    }

}