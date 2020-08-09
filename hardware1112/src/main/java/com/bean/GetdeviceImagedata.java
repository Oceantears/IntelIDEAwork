package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GetdeviceImagedata {
    private Integer KEYID;//主键
    private String deviceSerial;//sn
    private String GETDEVICEIMAGEDATA;//海康图片地址
    private String SN;//设备SN
    private String GETDEVICEIMAGEDATATow;//气象站图片地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date GE_DATE;//时间

    @Override
    public String toString() {
        return "GetdeviceImagedata{" +
                "KEYID=" + KEYID +
                ", SN='" + deviceSerial + '\'' +
                ", GETDEVICEIMAGEDATA='" + GETDEVICEIMAGEDATA + '\'' +
                ", GE_DATE=" + GE_DATE +
                '}';
    }

    public Integer getKEYID() {
        return KEYID;
    }

    public void setKEYID(Integer KEYID) {
        this.KEYID = KEYID;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getGETDEVICEIMAGEDATA() {
        return GETDEVICEIMAGEDATA;
    }

    public void setGETDEVICEIMAGEDATA(String GETDEVICEIMAGEDATA) {
        this.GETDEVICEIMAGEDATA = GETDEVICEIMAGEDATA;
    }

    public Date getGE_DATE() {
        return GE_DATE;
    }

    public void setGE_DATE(Date GE_DATE) {
        this.GE_DATE = GE_DATE;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getGETDEVICEIMAGEDATATow() {
        return GETDEVICEIMAGEDATATow;
    }

    public void setGETDEVICEIMAGEDATATow(String GETDEVICEIMAGEDATATow) {
        this.GETDEVICEIMAGEDATATow = GETDEVICEIMAGEDATATow;
    }
}
