package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Precipitation {
    private Integer KEYID;//主键
    private String SN;//sn
    private double PRECIPITATION;//降雨量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date PR_DATE;//时间

    @Override
    public String toString() {
        return "Precipitation{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", PRECIPITATION=" + PRECIPITATION +
                ", PR_DATE=" + PR_DATE +
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

    public double getPRECIPITATION() {
        return PRECIPITATION;
    }

    public void setPRECIPITATION(double PRECIPITATION) {
        this.PRECIPITATION = PRECIPITATION;
    }

    public Date getPR_DATE() {
        return PR_DATE;
    }

    public void setPR_DATE(Date PR_DATE) {
        this.PR_DATE = PR_DATE;
    }
}
