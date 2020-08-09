package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Qxpre {

    private Integer KEYID;//主键
    private String NAME;//气象名称
    private String TOKEN;//TOKEN
    private String GETSNs;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date GETTIEM;

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    public String getGETSNs() {
        return GETSNs;
    }

    public void setGETSNs(String GETSNs) {
        this.GETSNs = GETSNs;
    }

    public Date getGETTIEM() {
        return GETTIEM;
    }

    public void setGETTIEM(Date GETTIEM) {
        this.GETTIEM = GETTIEM;
    }

    @Override
    public String toString() {
        return "Qxpre{" +
                "KEYID=" + KEYID +
                ", NAME='" + NAME + '\'' +
                ", TOKEN='" + TOKEN + '\'' +
                ", GETSNs='" + GETSNs + '\'' +
                ", GETTIEM=" + GETTIEM +
                '}';
    }
}
