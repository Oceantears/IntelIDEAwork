package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Demos {
    private Integer KEYID;//主键
    private Date GETTIEM;//时间
    private String SN;//时间
    private String SHIPIN;//视频
    private String TUPIAN;//图片
    private double FENGSU;//风速
    private double FENGXIANG;//风向
    private double WENDU;//大气温度
    private double SHIDU;//大气湿度
    private double GUANGZHAO;//光照
    private double YULIANG;//雨量
    private double QIYA;//气压
    private double PM2DOT5;//空气pm
    private double TURANGPH;//土壤ph
    private double HAIBA;//海拔

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public Date getGETTIEM() {
        return GETTIEM;
    }

    public void setGETTIEM(Date GETTIEM) {
        this.GETTIEM = GETTIEM;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getSHIPIN() {
        return SHIPIN;
    }

    public void setSHIPIN(String SHIPIN) {
        this.SHIPIN = SHIPIN;
    }

    public String getTUPIAN() {
        return TUPIAN;
    }

    public void setTUPIAN(String TUPIAN) {
        this.TUPIAN = TUPIAN;
    }

    public double getFENGSU() {
        return FENGSU;
    }

    public void setFENGSU(double FENGSU) {
        this.FENGSU = FENGSU;
    }

    public double getFENGXIANG() {
        return FENGXIANG;
    }

    public void setFENGXIANG(double FENGXIANG) {
        this.FENGXIANG = FENGXIANG;
    }

    public double getWENDU() {
        return WENDU;
    }

    public void setWENDU(double WENDU) {
        this.WENDU = WENDU;
    }

    public double getSHIDU() {
        return SHIDU;
    }

    public void setSHIDU(double SHIDU) {
        this.SHIDU = SHIDU;
    }

    public double getGUANGZHAO() {
        return GUANGZHAO;
    }

    public void setGUANGZHAO(double GUANGZHAO) {
        this.GUANGZHAO = GUANGZHAO;
    }

    public double getYULIANG() {
        return YULIANG;
    }

    public void setYULIANG(double YULIANG) {
        this.YULIANG = YULIANG;
    }

    public double getQIYA() {
        return QIYA;
    }

    public void setQIYA(double QIYA) {
        this.QIYA = QIYA;
    }

    public double getPM2DOT5() {
        return PM2DOT5;
    }

    public void setPM2DOT5(double PM2DOT5) {
        this.PM2DOT5 = PM2DOT5;
    }

    public double getTURANGPH() {
        return TURANGPH;
    }

    public void setTURANGPH(double TURANGPH) {
        this.TURANGPH = TURANGPH;
    }

    public double getHAIBA() {
        return HAIBA;
    }

    public void setHAIBA(double HAIBA) {
        this.HAIBA = HAIBA;
    }

    @Override
    public String toString() {
        return "Demos{" +
                "KEYID=" + KEYID +
                ", GETTIEM=" + GETTIEM +
                ", SN='" + SN + '\'' +
                ", SHIPIN='" + SHIPIN + '\'' +
                ", TUPIAN='" + TUPIAN + '\'' +
                ", FENGSU=" + FENGSU +
                ", FENGXIANG=" + FENGXIANG +
                ", WENDU=" + WENDU +
                ", SHIDU=" + SHIDU +
                ", GUANGZHAO=" + GUANGZHAO +
                ", YULIANG=" + YULIANG +
                ", QIYA=" + QIYA +
                ", PM2DOT5=" + PM2DOT5 +
                ", TURANGPH=" + TURANGPH +
                ", HAIBA=" + HAIBA +
                '}';
    }
}
