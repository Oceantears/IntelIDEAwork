package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Airpressure {
    private Integer KEYID;//主键
    private String SN;//sn
    private double AIRPRESSURE;//大气压力
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date AI_DATE;//时间

    @Override
    public String toString() {
        return "Airpressure{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", AIRPRESSURE=" + AIRPRESSURE +
                ", AI_DATE=" + AI_DATE +
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

    public double getAIRPRESSURE() {
        return AIRPRESSURE;
    }

    public void setAIRPRESSURE(double AIRPRESSURE) {
        this.AIRPRESSURE = AIRPRESSURE;
    }

    public Date getAI_DATE() {
        return AI_DATE;
    }

    public void setAI_DATE(Date AI_DATE) {
        this.AI_DATE = AI_DATE;
    }
}
