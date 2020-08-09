package com.mapper;

import com.bean.Airpressure;
import com.bean.Altitude;
import com.bean.Windspeed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AltitudeMapper {
    //添加
    @Insert("insert into hw_altitude(`KEYID`,`SN`,`ALTITUDE`,`AL_DATE`)values(#{KEYID},#{SN},#{ALTITUDE},#{AL_DATE})")
    public void insertAltitude(Altitude alt);

    @Select("SELECT * FROM hw_altitude")
    public List<Altitude> selectAltitude();

    //id自增列
    @Select("select (count(*)+1)from hw_altitude")
    public Integer idPlusAltitude();
}
