package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Winddirection {
    private Integer KEYID;//主键
    private String SN;//sn
    private double WINDDIRECTION;//风向
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date WI_DATE;//时间

    @Override
    public String toString() {
        return "Winddirection{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", WINDDIRECTION=" + WINDDIRECTION +
                ", WI_DATE=" + WI_DATE +
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

    public double getWINDDIRECTION() {
        return WINDDIRECTION;
    }

    public void setWINDDIRECTION(double WINDDIRECTION) {
        this.WINDDIRECTION = WINDDIRECTION;
    }

    public Date getWI_DATE() {
        return WI_DATE;
    }

    public void setWI_DATE(Date WI_DATE) {
        this.WI_DATE = WI_DATE;
    }
}
