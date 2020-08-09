package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MonthuTILS {


    public List<String> m1(String EQ_SN, String name, String datas) {
        ArrayList<String> arry = new ArrayList<String>();
        ArrayList<String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "01")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m2(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "02")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m3(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "03")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m4(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "04")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m5(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "05")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m6(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "06")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m7(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "07")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m8(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "08")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }


    public List<String> m9(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "09")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m10(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "10")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m11(java.lang.String EQ_SN, java.lang.String name, java.lang.String datas) {
        ArrayList<java.lang.String> arry = new ArrayList<java.lang.String>();
        ArrayList<java.lang.String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "11")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

    public List<String> m12(String EQ_SN, String name, String datas) {
        ArrayList<String> arry = new ArrayList<String>();
        ArrayList<String> folders1 = DatePictureUtils.getFolders(name + ":\\download\\" + EQ_SN + "");
        for (int i = 0; i < folders1.size(); i++) {
            if ((folders1.get(i).substring(0, 6)).equals(datas + "12")) {
                arry = PictureUtils.isDirectory(new File(name + ":\\download\\" + EQ_SN + "\\" + folders1.get(i) + ""), arry, EQ_SN, folders1.get(i));
            }
        }
        return arry;
    }

}