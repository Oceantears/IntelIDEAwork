package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Altitude {
    private Integer KEYID;//主键
    private String SN;//sn
    private double ALTITUDE;//海拔
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date AL_DATE;//时间

    @Override
    public String toString() {
        return "Altitude{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", ALTITUDE=" + ALTITUDE +
                ", AL_DATE=" + AL_DATE +
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

    public double getALTITUDE() {
        return ALTITUDE;
    }

    public void setALTITUDE(double ALTITUDE) {
        this.ALTITUDE = ALTITUDE;
    }

    public Date getAL_DATE() {
        return AL_DATE;
    }

    public void setAL_DATE(Date AL_DATE) {
        this.AL_DATE = AL_DATE;
    }
}
