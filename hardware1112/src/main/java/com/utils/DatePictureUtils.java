package com.utils;

import java.io.File;
import java.util.ArrayList;


public class DatePictureUtils {

    public static ArrayList<String> getFolders(String path) {
        File[] fileList;
        if (path == null) {
            // 获得硬盘盘符
            fileList = File.listRoots();
        } else {
            File file = new File(path);
            fileList = file.listFiles();
        }
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                list.add(fileList[i].getName());
            }
            if (fileList.length == 0) {
                break;
            }
        }
        return list;
    }

}
