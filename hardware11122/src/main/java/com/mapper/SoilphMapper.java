package com.mapper;

import com.bean.Precipitation;
import com.bean.Soilph;
import com.bean.Windspeed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SoilphMapper {
    //添加
    @Insert("insert into hw_soilph(`KEYID`,`SN`,`SOILPH`,`SO_DATE`)values(#{KEYID},#{SN},#{SOILPH},#{SO_DATE})")
    public void insertSoilph(Soilph soi);

    @Select("SELECT * FROM hw_soilph")
    public List<Soilph> selectSoilph();

    //id自增列
    @Select("select (count(*)+1)from hw_soilph")
    public Integer idPlusSoilph();

    @Select("SELECT * FROM hw_soilph where SN=#{SN}")
    public List<Soilph> selectSoilphSN(String SN);
}
