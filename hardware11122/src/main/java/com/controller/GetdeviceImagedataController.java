package com.controller;


import com.bean.GetdeviceImagedata;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.interfaces.PictureInterfaces;
import com.mapper.AccesstokenMapper;
import com.mapper.CameraMapper;
import com.mapper.GetdeviceImagedataMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GetdeviceImagedataController {
    private static final Logger log = LoggerFactory.getLogger(GetdeviceImagedataController.class);

    public static void dop(GetdeviceImagedata get, GetdeviceImagedataMapper getdeviceImagedataMapper, CameraMapper cameraMapper, AccesstokenMapper accesstokenMapper) throws IOException {
        //获取所有序列号
        List<String> arry = cameraMapper.selectdeviceSerial();
        //进行设备SN迭代
        for (String s : arry) {
            List<String> aa = null;
            try {
                aa = PictureInterfaces.dop(s, accesstokenMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("气象图片请求超时！", e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonObject userOb = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonObject();
                    String url = userOb.get("picUrl").getAsString();
                    //储存图片到本地
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
                    String for1 = format.format(date);
                    String for2 = format2.format(date);
                    String path = "/file/" + s + "/" + for1 + "/" + for2 + ".jpg";
                    String path2 = "D:\\download\\" + s + "\\" + for1 + "\\";
                    download(url, path2, for2);
                    //截取盘符
                    String path1 = path.substring(1);
                    //图片入库（本地地址）
                    get.setKEYID(getdeviceImagedataMapper.idPlusGetdeviceImagedata());
                    //把毫秒值转换成时间格式
                    Date dates = new Date();
                    get.setGE_DATE(dates);
                    get.setGETDEVICEIMAGEDATA(path1);
                    get.setDeviceSerial(s);
                    get.setGETDEVICEIMAGEDATATow(null);
                    get.setSN(null);
                    getdeviceImagedataMapper.insertgetdeviceImagedata(get);
                } else {
                    /*get.setKEYID(getdeviceImagedataMapper.idPlusGetdeviceImagedata());
                    get.setGE_DATE(null);
                    get.setDeviceSerial(s);
                    get.setGETDEVICEIMAGEDATA(null);
                    get.setGETDEVICEIMAGEDATATow(null);
                    get.setSN(null);
                    getdeviceImagedataMapper.insertgetdeviceImagedata(get);*/
                    continue;
                }
            }
        }
    }

    public static String download(String _url, String path, String ss) {
        String picpath = "";
        try {
            // 构造URL
            URL url = new URL(_url);
            // 打开连接
            URLConnection con = url.openConnection();
            // 设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            InputStream is = con.getInputStream();
            Date date = new Date();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(path);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            picpath = ss + ".jpg";
            OutputStream os = new FileOutputStream(path + picpath);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picpath;
    }

}