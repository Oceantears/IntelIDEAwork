package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class Accesstoken {
    private Integer KEYID;//登录的账户
    private String AppKey;//平台获取
    private String NAME;//平台获取
    private String Secret;//平台获取
    private String AccessToken;//通过接口获得
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date LoseTime;//当前获取的时间+7天
    private Integer UseNum;//默认0，调用一次+1
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date GetTime;//当前获取的时间

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getAppKey() {
        return AppKey;
    }

    public void setAppKey(String appKey) {
        AppKey = appKey;
    }

    public String getSecret() {
        return Secret;
    }

    public void setSecret(String secret) {
        Secret = secret;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public Date getLoseTime() {
        return LoseTime;
    }

    public void setLoseTime(Date loseTime) {
        LoseTime = loseTime;
    }

    public Integer getUseNum() {
        return UseNum;
    }

    public void setUseNum(Integer useNum) {
        UseNum = useNum;
    }

    public Date getGetTime() {
        return GetTime;
    }

    public void setGetTime(Date getTime) {
        GetTime = getTime;
    }

    @Override
    public String toString() {
        return "Accesstoken{" +
                "KEYID=" + KEYID +
                ", AppKey='" + AppKey + '\'' +
                ", NAME='" + NAME + '\'' +
                ", Secret='" + Secret + '\'' +
                ", AccessToken='" + AccessToken + '\'' +
                ", LoseTime=" + LoseTime +
                ", UseNum=" + UseNum +
                ", GetTime=" + GetTime +
                '}';
    }
}
