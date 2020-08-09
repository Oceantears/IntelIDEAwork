package com.bean;

import java.util.Date;

public class Longitude {

    private Integer KEYID;
    private String SN;
    private double LONGITUDE;
    private Date LO_DATE;

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

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public Date getLO_DATE() {
        return LO_DATE;
    }

    public void setLO_DATE(Date LO_DATE) {
        this.LO_DATE = LO_DATE;
    }

    @Override
    public String toString() {
        return "Longitude{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", LONGITUDE=" + LONGITUDE +
                ", LO_DATE=" + LO_DATE +
                '}';
    }
}
