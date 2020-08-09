package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AtmosphericHumidity implements Serializable {
    private Integer KEYID;//主键
    private String SN;//sn
    private double ATMOSPHERICHUMIDTY;//大气湿度
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date AT_DATE;//时间

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

    public double getATMOSPHERICHUMIDTY() {
        return ATMOSPHERICHUMIDTY;
    }

    public void setATMOSPHERICHUMIDTY(double ATMOSPHERICHUMIDTY) {
        this.ATMOSPHERICHUMIDTY = ATMOSPHERICHUMIDTY;
    }

    public Date getAT_DATE() {
        return AT_DATE;
    }

    public void setAT_DATE(Date AT_DATE) {
        this.AT_DATE = AT_DATE;
    }

    @Override
    public String toString() {
        return "AtmosphericHumidity{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", ATMOSPHERICHUMIDTY=" + ATMOSPHERICHUMIDTY +
                ", AT_DATE=" + AT_DATE +
                '}';
    }
}
