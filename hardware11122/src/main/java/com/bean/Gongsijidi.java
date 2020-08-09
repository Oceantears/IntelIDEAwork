package com.bean;

public class Gongsijidi {

    private String company_name;
    private String place_title;
    private String EQ_NAME;
    private String EQ_SN;
    private Integer KEYID;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPlace_title() {
        return place_title;
    }

    public void setPlace_title(String place_title) {
        this.place_title = place_title;
    }

    public String getEQ_NAME() {
        return EQ_NAME;
    }

    public void setEQ_NAME(String EQ_NAME) {
        this.EQ_NAME = EQ_NAME;
    }

    public String getEQ_SN() {
        return EQ_SN;
    }

    public void setEQ_SN(String EQ_SN) {
        this.EQ_SN = EQ_SN;
    }

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    @Override
    public String toString() {
        return "Gongsijidi{" +
                "company_name='" + company_name + '\'' +
                ", place_title='" + place_title + '\'' +
                ", EQ_NAME='" + EQ_NAME + '\'' +
                ", EQ_SN='" + EQ_SN + '\'' +
                ", KEYID=" + KEYID +
                '}';
    }
}
