package com.bean;

import java.util.Date;

public class Latitude {

    private Integer KEYID;
    private String SN;
    private double LATITUDE;
    private Date LA_DATE;

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

    public double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public Date getLA_DATE() {
        return LA_DATE;
    }

    public void setLA_DATE(Date LA_DATE) {
        this.LA_DATE = LA_DATE;
    }

    @Override
    public String toString() {
        return "Latitude{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", LATITUDE=" + LATITUDE +
                ", LA_DATE=" + LA_DATE +
                '}';
    }
}
