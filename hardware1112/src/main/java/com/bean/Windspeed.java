package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Windspeed {
    private Integer KEYID;//主键
    private String SN;//sn
    private double WINDSPEED;//风速
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date WI_DATE;//时间

    @Override
    public String toString() {
        return "Windspeed{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", WINDSPEED=" + WINDSPEED +
                ", WI_DATE=" + WI_DATE +
                '}';
    }

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

    public double getWINDSPEED() {
        return WINDSPEED;
    }

    public void setWINDSPEED(double WINDSPEED) {
        this.WINDSPEED = WINDSPEED;
    }

    public Date getWI_DATE() {
        return WI_DATE;
    }

    public void setWI_DATE(Date WI_DATE) {
        this.WI_DATE = WI_DATE;
    }
}
