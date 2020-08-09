package com.controllers;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;
import okhttp3.*;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test6 extends Thread {

    public static void dop()throws IOException{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "appKey=21dc9e0881ab4836ba7e6a09dea32409&appSecret=4bd570082135b2327f9095d5de05b005&undefined=");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/live/video/list")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "3fbbb8cc-d2f1-43af-b33d-f9301c12ce04")
                .build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();
        System.out.println(json);
    }

    public static void main(String[] args) throws IOException{
        //Test6.dop();

       /* long now=System.currentTimeMillis();
        Date date = new Date();
        date.setTime(now);
        System.out.println(new SimpleDateFormat().format(date));*/


       for(int i=0;i<2;i++){

           for(int j=0;j<3;j++){

               System.out.println(j);


           }
       }

    }



}