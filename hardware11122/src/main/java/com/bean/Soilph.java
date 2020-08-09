package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Soilph {
    private Integer KEYID;//主键
    private String SN;//sn
    private double SOILPH;//土壤ph
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date SO_DATE;//时间

    @Override
    public String toString() {
        return "Soilph{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", SOILPH=" + SOILPH +
                ", SO_DATE=" + SO_DATE +
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

    public double getSOILPH() {
        return SOILPH;
    }

    public void setSOILPH(double SOILPH) {
        this.SOILPH = SOILPH;
    }

    public Date getSO_DATE() {
        return SO_DATE;
    }

    public void setSO_DATE(Date SO_DATE) {
        this.SO_DATE = SO_DATE;
    }
}
