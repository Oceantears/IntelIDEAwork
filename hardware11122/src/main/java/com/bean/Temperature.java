package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Temperature {

    private Integer KEYID;
    private String SN;
    private Integer TEMPERATURE;
    private Date TE_DATE;

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

    public Integer getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(Integer TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public Date getTE_DATE() {
        return TE_DATE;
    }

    public void setTE_DATE(Date TE_DATE) {
        this.TE_DATE = TE_DATE;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", TEMPERATURE='" + TEMPERATURE + '\'' +
                ", TE_DATE=" + TE_DATE +
                '}';
    }

    public Temperature() {
        super();
    }
}
