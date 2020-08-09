package com.mapper;

import com.bean.Airpressure;
import com.bean.Altitude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
@Component
public interface AirpressureMapper {
    //添加
    @Insert("insert into hw_airpressure(`KEYID`,`SN`,`AIRPRESSURE`,`AI_DATE`)values(#{KEYID},#{SN},#{AIRPRESSURE},#{AI_DATE})")
    public void insertAirpressure(Airpressure air);

    @Select("SELECT * FROM hw_airpressure")
    public List<Airpressure>selectAirpressure();

    //id自增列
    @Select("select (count(*)+1)from hw_airpressure")
    public Integer idPlusAirpressure();


    @Select("SELECT * FROM hw_airpressure where  SN=#{SN}")
    public List<Airpressure> selectAirpressureSN(String SN);

}
