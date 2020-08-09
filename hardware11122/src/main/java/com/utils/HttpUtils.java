package com.utils;

import com.controller.TemperatureController;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static void Http() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(500, TimeUnit.MILLISECONDS)//设置连接超时时间
                .readTimeout(500, TimeUnit.MILLISECONDS)//设置读取超时时间
                .build();
        Request.Builder builder = new Request.Builder().url("http://localhost:8080/addrun");

        Call call = client.newCall(builder.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (e instanceof SocketTimeoutException) {//判断超时异常
                    log.error("环境数据请求超时！",e);
                }
                if (e instanceof ConnectException) {//判断连接异常，我这里是报Failed to connect to 10.7.5.144
                    log.error("环境数据请求连接异常！",e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }
}
