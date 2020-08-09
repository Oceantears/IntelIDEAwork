package com.bean;

public class Changjia {

    private Integer KEYID;//登录的账户
    private String TITLE;//厂家
    private String VALUE;//厂家参数

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    @Override
    public String toString() {
        return "Changjia{" +
                "KEYID=" + KEYID +
                ", TITLE='" + TITLE + '\'' +
                ", VALUE='" + VALUE + '\'' +
                '}';
    }
}
