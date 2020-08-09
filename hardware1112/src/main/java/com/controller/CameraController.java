package com.controller;

import com.bean.Accesstoken;
import com.bean.Camera;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.CameraUtils;
import com.mapper.AccesstokenMapper;
import com.mapper.CameraMapper;

import com.mapper.QxpreMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CameraController {
    private static final Logger log = LoggerFactory.getLogger(CameraController.class);

    public static void Camera(Camera cam, CameraMapper cameraMapper, AccesstokenMapper accesstokenMapper) {
        //存储海康 摄像头视频信息
        List<Accesstoken> list = accesstokenMapper.selectAll();
        //清空摄像头表
        cameraMapper.deleteAll();
        for (int x = 0; x < list.size(); x++) {
            Date loseTime = list.get(x).getLoseTime();
            long t1 = loseTime.getTime();
            long t2 = System.currentTimeMillis();
            if (list.get(x) != null && t1 >= t2) {
                log.info("开始存储加工摄像头信息");
                String token = list.get(x).getAccessToken();
                String came = CameraUtils.came(token);
                JSONObject jb = JSONObject.fromObject(came);
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray JsonArray = new JsonParser().parse(came).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < JsonArray.size(); i++) {
                        Integer keyid = list.get(x).getKEYID();
                        cam.setKEYID(cameraMapper.idPluscamera());
                        cam.setATKEYID(keyid);
                        String deviceSerial = JsonArray.get(i).getAsJsonObject().get("deviceSerial").getAsString();
                        cam.setDeviceSerial(deviceSerial);
                        cam.setSBNO(deviceSerial);

                        String channelNo = JsonArray.get(i).getAsJsonObject().get("channelNo").getAsString();
                        cam.setChannelNo(channelNo);

                        String deviceName = JsonArray.get(i).getAsJsonObject().get("deviceName").getAsString();
                        cam.setDeviceName(deviceName);

                        String liveAddress = JsonArray.get(i).getAsJsonObject().get("liveAddress").getAsString();
                        cam.setLiveAddress(liveAddress);

                        String hdAddress = JsonArray.get(i).getAsJsonObject().get("hdAddress").getAsString();
                        cam.setHdAddress(hdAddress);

                        String rtmp = JsonArray.get(i).getAsJsonObject().get("rtmp").getAsString();
                        cam.setRtmp(rtmp);


                        String rtmpHd = JsonArray.get(i).getAsJsonObject().get("rtmpHd").getAsString();
                        cam.setRtmpHd(rtmpHd);

                        String flvAddress = JsonArray.get(i).getAsJsonObject().get("flvAddress").getAsString();
                        cam.setFlvAddress(flvAddress);

                        String hdFlvAddress = JsonArray.get(i).getAsJsonObject().get("hdFlvAddress").getAsString();
                        cam.setHdFlvAddress(hdFlvAddress);

                        String status = JsonArray.get(i).getAsJsonObject().get("status").getAsString();
                        cam.setStatus(status);

                        String exception = JsonArray.get(i).getAsJsonObject().get("exception").getAsString();
                        cam.setException(exception);


                        try {
                            String beginTime = JsonArray.get(i).getAsJsonObject().get("beginTime").getAsString();
                            Long l = Long.valueOf(beginTime);
                            Date date = new Date(System.currentTimeMillis()+28800000);
                            date.setTime(l);
                            String format = new SimpleDateFormat().format(date);
                            SimpleDateFormat sdf = new SimpleDateFormat();
                            Date date1 = sdf.parse(format);
                            cam.setBeginTime(date);


                            String endTime = JsonArray.get(i).getAsJsonObject().get("endTime").getAsString();
                            Long l1 = Long.valueOf(endTime);
                            Date date2 = new Date();
                            date2.setTime(l1);
                            String format1 = new SimpleDateFormat().format(date2);
                            SimpleDateFormat sdf1 = new SimpleDateFormat();
                            date2 = sdf1.parse(format1);
                            cam.setBeginTime(date2);
                            cam.setEndTime(date1);

                            cameraMapper.insertcamera(cam);
                            log.info("添加加工视频地址成功！");

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                //token值如果异常或者过期重新获取
                log.info("token过期或异常重新获取token值");
                AccesstokenController.token(accesstokenMapper, list.get(x).getKEYID(), cam, cameraMapper);
            }
        }
    }
}
