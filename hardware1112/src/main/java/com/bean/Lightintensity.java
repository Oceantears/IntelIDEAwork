package com.bean;

import java.util.Date;

public class Lightintensity {



    private Integer KEYID;
    private String SN;
    private double LIGHTLNTENSITY;
    private Date LI_DATE;

    public Date getLI_DATE() {
        return LI_DATE;
    }

    public void setLI_DATE(Date LI_DATE) {
        this.LI_DATE = LI_DATE;
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

    public double getLIGHTLNTENSITY() {
        return LIGHTLNTENSITY;
    }

    public void setLIGHTLNTENSITY(double LIGHTLNTENSITY) {
        this.LIGHTLNTENSITY = LIGHTLNTENSITY;
    }



    @Override
    public String toString() {
        return "Lightintensity{" +
                "KEYID=" + KEYID +
                ", SN='" + SN + '\'' +
                ", LIGHTLNTENSITY=" + LIGHTLNTENSITY +
                ", LI_DATE=" + LI_DATE +
                '}';
    }
}
