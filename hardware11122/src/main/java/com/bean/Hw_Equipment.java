package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Hw_Equipment {
    private Integer KEYID;
    private Integer SB_CHANGJIA;//设备厂家
    private Integer SB_CS_KEYID;//厂家ID
    private String EQ_NAME;//设备名称
    private String EQ_ADDRESS;//设备地址
    private String EQ_SN;//设备sn
    private String SP_YZM;//设备验证码
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date EQ_DATE;//日期
    private double EQ_LONGITUDE;//经度
    private double EQ_LATITUDE;//纬度
    private Integer EQ_company_id;//公司ID
    private Integer EQ_place_id;//基地ID
    private Integer EQ_STATE;//设备状态

    @Override
    public String toString() {
        return "Hw_Equipment{" +
                "KEYID=" + KEYID +
                ", SB_CHANGJIA=" + SB_CHANGJIA +
                ", SB_CS_KEYID=" + SB_CS_KEYID +
                ", EQ_NAME='" + EQ_NAME + '\'' +
                ", EQ_ADDRESS='" + EQ_ADDRESS + '\'' +
                ", EQ_SN='" + EQ_SN + '\'' +
                ", SP_YZM='" + SP_YZM + '\'' +
                ", EQ_DATE=" + EQ_DATE +
                ", EQ_LONGITUDE=" + EQ_LONGITUDE +
                ", EQ_LATITUDE=" + EQ_LATITUDE +
                ", EQ_company_id=" + EQ_company_id +
                ", EQ_place_id=" + EQ_place_id +
                ", EQ_STATE=" + EQ_STATE +
                '}';
    }

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public Integer getSB_CHANGJIA() {
        return SB_CHANGJIA;
    }

    public void setSB_CHANGJIA(Integer SB_CHANGJIA) {
        this.SB_CHANGJIA = SB_CHANGJIA;
    }

    public Integer getSB_CS_KEYID() {
        return SB_CS_KEYID;
    }

    public void setSB_CS_KEYID(Integer SB_CS_KEYID) {
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

    public Integer getEQ_STATE() {
        return EQ_STATE;
    }

    public void setEQ_STATE(Integer EQ_STATE) {
        this.EQ_STATE = EQ_STATE;
    }
}
