package com.controller;

import com.bean.*;
import com.mapper.*;
import com.utils.InterfacesUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController

public class AaController {
    private static final Logger log = LoggerFactory.getLogger(AaController.class);

    public static void demo(AltitudeMapper altitudeMapper, Pm2dot5Mapper pm2dot5Mapper, GetdeviceImagedataMapper getdeviceImagedataMapper, GetliveinfoMapper getliveinfoMapper, WinddirectionMapper winddirectionMapper, WindspeedMapper windspeedMapper, SoilphMapper soilphMapper, TemperatureMapper temperatureMapper, AtmosphericHumidityMapper atmosphericHumidityMapper, LightintensityMapper lightintensityMapper, DemosMapper demosMapper, AirpressureMapper airpressureMapper, PrecipitationMapper precipitationMapper, QxpreMapper qxpreMapper, Demos d) throws IOException, ParseException {
        //气压
        List<Airpressure> airpressuresall = airpressureMapper.selectAirpressure();
        List<Airpressure> airpressuresall2 = new ArrayList<>();
        for (Airpressure airpressure : airpressuresall) {
            if (airpressure.getAI_DATE() != null) {
                airpressuresall2.add(airpressure);
            }
        }
        //降雨量
        List<Precipitation> precipitations = precipitationMapper.selectPrecipitation();
        List<Precipitation> precipitations2 = new ArrayList<>();
        for (Precipitation precipitation : precipitations) {
            if (precipitation.getPR_DATE() != null) {
                precipitations2.add(precipitation);
            }
        }
        //光照
        List<Lightintensity> lightintensities = lightintensityMapper.selectLightintensity();
        List<Lightintensity> lightintensities2 = new ArrayList<>();
        for (Lightintensity lightintensity : lightintensities) {
            if (lightintensity.getLI_DATE() != null) {
                lightintensities2.add(lightintensity);
            }
        }
        //湿度
        List<AtmosphericHumidity> atmosphericHumiditys = atmosphericHumidityMapper.selectAtmosphericHumidity();
        List<AtmosphericHumidity> atmosphericHumiditys2 = new ArrayList<>();
        for (AtmosphericHumidity atmosphericHumidity : atmosphericHumiditys) {
            if (atmosphericHumidity.getAT_DATE() != null) {
                atmosphericHumiditys2.add(atmosphericHumidity);
            }
        }
        //温度
        List<Temperature> temperatures = temperatureMapper.selectTemperature();
        List<Temperature> temperatures2 = new ArrayList<>();
        for (Temperature temperature : temperatures) {
            if (temperature.getTE_DATE() != null) {
                temperatures2.add(temperature);
            }
        }
        //土壤
        List<Soilph> soilphs = soilphMapper.selectSoilph();
        List<Soilph> soilphs2 = new ArrayList<>();
        for (Soilph soilph : soilphs) {
            if (soilph.getSO_DATE() != null) {
                soilphs2.add(soilph);
            }
        }
        //风速
        List<Windspeed> windspeeds = windspeedMapper.selectWindspeed();
        List<Windspeed> windspeeds2 = new ArrayList<>();
        for (Windspeed windspeed : windspeeds) {
            if (windspeed.getWI_DATE() != null) {
                windspeeds2.add(windspeed);
            }
        }
        //风向
        List<Winddirection> winddirections = winddirectionMapper.selectWinddirection();
        List<Winddirection> winddirections2 = new ArrayList<>();
        for (Winddirection winddirection : winddirections) {
            if (winddirection.getWI_DATE() != null) {
                winddirections2.add(winddirection);
            }
        }
        //视频
        List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfo();
        List<Getliveinfo> getliveinfos2 = new ArrayList<>();
        for (Getliveinfo getliveinfo : getliveinfos) {
            if (getliveinfo.getGE_DATE() != null) {
                getliveinfos2.add(getliveinfo);
            }
        }
        //图片
        List<GetdeviceImagedata> getdeviceImagedatas = getdeviceImagedataMapper.selectGetdeviceImagedata();
        List<GetdeviceImagedata> getdeviceImagedatas2 = new ArrayList<>();
        for (GetdeviceImagedata getdeviceImagedata : getdeviceImagedatas) {
            if (getdeviceImagedata.getDeviceSerial() == null) {
                getdeviceImagedatas2.add(getdeviceImagedata);
            }
        }
        //pm2.5
        List<Pm2dot5> pm2dot5s = pm2dot5Mapper.selectPm2dot5();
        List<Pm2dot5> pm2dot5s2 = new ArrayList<>();
        for (Pm2dot5 pm2dot5 : pm2dot5s) {
            if (pm2dot5.getPM_DATE() != null) {
                pm2dot5s2.add(pm2dot5);
            }
        }
        //海拔
        List<Altitude> altituds = altitudeMapper.selectAltitude();
        List<Altitude> altituds2 = new ArrayList<>();
        for (Altitude altitude : altituds) {
            if (altitude.getAL_DATE() != null) {
                altituds2.add(altitude);
            }
        }
        ArrayList<String> arry = InterfacesUtils.dop(qxpreMapper);
        int a = arry.size();
        int i = 0;
        int size1 = airpressuresall2.size() - 1;

        int size2 = airpressuresall2.size() - 1;
        int size3 = precipitations2.size() - 1;
        int size4 = lightintensities2.size() - 1;
        int size5 = atmosphericHumiditys2.size() - 1;
        int size6 = temperatures2.size() - 1;
        int size7 = soilphs2.size() - 1;
        int size8 = windspeeds2.size() - 1;
        int size9 = winddirections2.size() - 1;
        int size10 = getliveinfos2.size() - 1;
        int size11 = getdeviceImagedatas2.size() - 1;
        int size12 = pm2dot5s2.size() - 1;
        int size13 = altituds2.size() - 1;
        Date date = new Date(System.currentTimeMillis());
        while (i < a) {
            //视频
            String s1 = getliveinfos2.get(size10--).getGETLIVEINFO();
            if (s1 == null) {
                continue;
            }
            d.setSHIPIN(s1);
            //存入SN
            //String s=getliveinfos.get(size10--).getSN();
            String s = airpressuresall2.get(size1--).getSN();
            d.setSN(s);
            //图片
            List<GetdeviceImagedata> getdeviceImagedata = getdeviceImagedataMapper.selectGetdeviceImagedataSN(s);
            if (getdeviceImagedata.size() == 0) {
                d.setTUPIAN(null);
            } else {
                int i1 = getdeviceImagedata.size() - 1;

                d.setTUPIAN(getdeviceImagedata.get(i1).getGETDEVICEIMAGEDATATow());
            }
            //存入日期
            d.setKEYID(demosMapper.idPlusDemos());
            d.setGETTIEM(date);
            //存入大气压力
            double dd = airpressuresall2.get(size2--).getAIRPRESSURE();
            d.setQIYA(dd);
            //降雨量
            double dd5 = precipitations2.get(size3--).getPRECIPITATION();
            d.setYULIANG(dd5);
            //光照强度
            double dd2 = lightintensities2.get(size4--).getLIGHTLNTENSITY();
            d.setGUANGZHAO(dd2);
            double dd6 = atmosphericHumiditys2.get(size5--).getATMOSPHERICHUMIDTY();
            d.setSHIDU(dd6);
            d.setWENDU(temperatures2.get(size6--).getTEMPERATURE());
            d.setTURANGPH(soilphs2.get(size7--).getSOILPH());
            double dd3 = windspeeds2.get(size8--).getWINDSPEED();
            d.setFENGSU(dd3);
            double dd4 = winddirections2.get(size9--).getWINDDIRECTION();
            d.setFENGXIANG(dd4);
            double dd7 = pm2dot5s2.get(size12--).getPM2DOT5();
            d.setPM2DOT5(dd7);
            //海拔
            double hai = altituds2.get(size13--).getALTITUDE();
            d.setHAIBA(hai);
            demosMapper.insertDemos(d);
            log.info("数据汇总成功");
            i++;
        }
    }

}
