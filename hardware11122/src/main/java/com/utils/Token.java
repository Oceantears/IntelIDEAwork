package com.utils;

import com.bean.Accesstoken;
import com.mapper.AccesstokenMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


public class Token {
    private static final Logger log = LoggerFactory.getLogger(Token.class);

    public static String tok(AccesstokenMapper accesstokenMapper, Integer id) {

        OkHttpClient client = new OkHttpClient();
        Accesstoken accesstoken = accesstokenMapper.selectByID(id);
        String appKey = accesstoken.getAppKey();
        String secret = accesstoken.getSecret();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "appKey=" + appKey + "&appSecret=" + secret + "&undefined=");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/token/get?Content-Type=application/x-www-form-urlencoded")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "fed6e99c-befb-4252-a3e8-7bd663b8475f")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            log.info("获取视频token");
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
