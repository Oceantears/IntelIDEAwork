package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Hw_Equipment {
    private Integer KEYID;
    private String SB_CHANGJIA;
    private String SB_CS_KEYID;
    private String EQ_NAME;
    private String EQ_ADDRESS;
    private String EQ_SN;
    private String SP_YZM;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date EQ_DATE;
    private double EQ_LONGITUDE;
    private double EQ_LATITUDE;
    private Integer EQ_company_id;
    private Integer EQ_place_id;

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getSB_CHANGJIA() {
        return SB_CHANGJIA;
    }
    public void setSB_CHANGJIA(String SB_CHANGJIA) {
        this.SB_CHANGJIA = SB_CHANGJIA;
    }

    public String getSB_CS_KEYID() {
        return SB_CS_KEYID;
    }

    public void setSB_CS_KEYID(String SB_CS_KEYID) {
        this.SB_CS_KEYID = SB_CS_KEYID;
    }

    public String getEQ_NAME() {
        return EQ_NAME;
    }

    public void setEQ_NAME(String EQ_NAME) {
        this.EQ_NAME = EQ_NAME;
    }

    public String getEQ_ADDRESS() {
        return EQ_ADDRESS;
    }

    public void setEQ_ADDRESS(String EQ_ADDRESS) {
        this.EQ_ADDRESS = EQ_ADDRESS;
    }

    public String getEQ_SN() {
        return EQ_SN;
    }

    public void setEQ_SN(String EQ_SN) {
        this.EQ_SN = EQ_SN;
    }

    public String getSP_YZM() {
        return SP_YZM;
    }

    public void setSP_YZM(String SP_YZM) {
        this.SP_YZM = SP_YZM;
    }

    public Date getEQ_DATE() {
        return EQ_DATE;
    }

    public void setEQ_DATE(Date EQ_DATE) {
        this.EQ_DATE = EQ_DATE;
    }

    public double getEQ_LONGITUDE() {
        return EQ_LONGITUDE;
    }

    public void setEQ_LONGITUDE(double EQ_LONGITUDE) {
        this.EQ_LONGITUDE = EQ_LONGITUDE;
    }

    public double getEQ_LATITUDE() {
        return EQ_LATITUDE;
    }

    public void setEQ_LATITUDE(double EQ_LATITUDE) {
        this.EQ_LATITUDE = EQ_LATITUDE;
    }

    public Integer getEQ_company_id() {
        return EQ_company_id;
    }

    public void setEQ_company_id(Integer EQ_company_id) {
        this.EQ_company_id = EQ_company_id;
    }

    public Integer getEQ_place_id() {
        return EQ_place_id;
    }

    public void setEQ_place_id(Integer EQ_place_id) {
        this.EQ_place_id = EQ_place_id;
    }

    @Override
    public String toString() {
        return "Hw_Equipment{" +
                "KEYID=" + KEYID +
                ", SB_CHANGJIA='" + SB_CHANGJIA + '\'' +
                ", SB_CS_KEYID='" + SB_CS_KEYID + '\'' +
                ", EQ_NAME='" + EQ_NAME + '\'' +
                ", EQ_ADDRESS='" + EQ_ADDRESS + '\'' +
                ", EQ_SN='" + EQ_SN + '\'' +
                ", SP_YZM='" + SP_YZM + '\'' +
                ", EQ_DATE=" + EQ_DATE +
                ", EQ_LONGITUDE=" + EQ_LONGITUDE +
                ", EQ_LATITUDE=" + EQ_LATITUDE +
                ", EQ_company_id=" + EQ_company_id +
                ", EQ_place_id=" + EQ_place_id +
                '}';
    }
}
