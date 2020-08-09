package com.utils;

import java.io.File;
import java.util.ArrayList;

public class PictureUtils {

    public static ArrayList<String> isDirectory(File file, ArrayList<String> arry, String deviceSerial, String data) {
        if (file.exists()) {
            if (file.isFile()) {
                arry.add("/file/" + deviceSerial + "/" + data + "/" + file.getName());
            } else {

                File[] list = file.listFiles();//list获取的结果：[D:\qrcodeFile\20190116, D:\qrcodeFile\20190117]
                if (list.length == 0) {
                    System.out.println(file.getAbsolutePath() + " is null");
                } else {
                    for (int i = 0; i < list.length; i++) {
                        isDirectory(list[i], arry, deviceSerial, data);
                    }
                }
            }

        } else {
            System.out.println("文件不存在！");
        }
        return arry;
    }
}
