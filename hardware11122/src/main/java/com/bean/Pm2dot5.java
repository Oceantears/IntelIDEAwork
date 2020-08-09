package com.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Pm2dot5 {
    private Integer KEYID;//主键
    private String SN;//sn
    private double PM2DOT5;//空气PM2.5
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date PM_DATE;//时间

    @Override
    public String toString() {
        return "Pm2dot5{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", PM2DOT5=" + PM2DOT5 +
                ", PM_DATE=" + PM_DATE +
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

    public double getPM2DOT5() {
        return PM2DOT5;
    }

    public void setPM2DOT5(double PM2DOT5) {
        this.PM2DOT5 = PM2DOT5;
    }

    public Date getPM_DATE() {
        return PM_DATE;
    }

    public void setPM_DATE(Date PM_DATE) {
        this.PM_DATE = PM_DATE;
    }
}
