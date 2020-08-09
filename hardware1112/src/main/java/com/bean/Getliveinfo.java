package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Getliveinfo {
    private Integer KEYID;//主键
    private String SN;//sn
    private String GETLIVEINFO;//视频地址
    private String GEJPG; //视频封面
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date GE_DATE;//时间

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getGETLIVEINFO() {
        return GETLIVEINFO;
    }

    public void setGETLIVEINFO(String GETLIVEINFO) {
        this.GETLIVEINFO = GETLIVEINFO;
    }

    public String getGEJPG() {
        return GEJPG;
    }

    public void setGEJPG(String GEJPG) {
        this.GEJPG = GEJPG;
    }

    public Date getGE_DATE() {
        return GE_DATE;
    }

    public void setGE_DATE(Date GE_DATE) {
        this.GE_DATE = GE_DATE;
    }

    @Override
    public String toString() {
        return "Getliveinfo{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", GETLIVEINFO='" + GETLIVEINFO + '\'' +
                ", GEJPG='" + GEJPG + '\'' +
                ", GE_DATE=" + GE_DATE +
                '}';
    }
}
