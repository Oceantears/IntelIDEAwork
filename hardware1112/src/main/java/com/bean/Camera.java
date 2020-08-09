package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Camera {
    private Integer KEYID;
    private Integer ATKEYID;
    private Integer QYID;
    private Integer JDID;
    private String SBNO;
    private String SBYZM;
    private String deviceSerial;
    private String channelNo;
    private String deviceName;
    private String liveAddress;
    private String hdAddress;
    private String rtmp;
    private String rtmpHd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private String  status;
    private String exception;
    private String flvAddress;
    private String hdFlvAddress;

    @Override
    public String toString() {
        return "Camera{" +
                "KEYID=" + KEYID +
                ", ATKEYID=" + ATKEYID +
                ", QYID=" + QYID +
                ", JDID=" + JDID +
                ", SBNO='" + SBNO + '\'' +
                ", SBYZM='" + SBYZM + '\'' +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", channelNo='" + channelNo + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", hdAddress='" + hdAddress + '\'' +
                ", rtmp='" + rtmp + '\'' +
                ", rtmpHd='" + rtmpHd + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", exception='" + exception + '\'' +
                ", flvAddress='" + flvAddress + '\'' +
                ", hdFlvAddress='" + hdFlvAddress + '\'' +
                '}';
    }

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public Integer getATKEYID() {
        return ATKEYID;
    }

    public void setATKEYID(Integer ATKEYID) {
        this.ATKEYID = ATKEYID;
    }

    public Integer getQYID() {
        return QYID;
    }

    public void setQYID(Integer QYID) {
        this.QYID = QYID;
    }

    public Integer getJDID() {
        return JDID;
    }

    public void setJDID(Integer JDID) {
        this.JDID = JDID;
    }

    public String getSBNO() {
        return SBNO;
    }

    public void setSBNO(String SBNO) {
        this.SBNO = SBNO;
    }

    public String getSBYZM() {
        return SBYZM;
    }

    public void setSBYZM(String SBYZM) {
        this.SBYZM = SBYZM;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getHdAddress() {
        return hdAddress;
    }

    public void setHdAddress(String hdAddress) {
        this.hdAddress = hdAddress;
    }

    public String getRtmp() {
        return rtmp;
    }

    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    public String getRtmpHd() {
        return rtmpHd;
    }

    public void setRtmpHd(String rtmpHd) {
        this.rtmpHd = rtmpHd;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getFlvAddress() {
        return flvAddress;
    }

    public void setFlvAddress(String flvAddress) {
        this.flvAddress = flvAddress;
    }

    public String getHdFlvAddress() {
        return hdFlvAddress;
    }

    public void setHdFlvAddress(String hdFlvAddress) {
        this.hdFlvAddress = hdFlvAddress;
    }
}
