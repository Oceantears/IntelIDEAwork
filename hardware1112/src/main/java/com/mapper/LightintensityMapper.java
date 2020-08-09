package com.mapper;

import com.bean.Latitude;
import com.bean.Lightintensity;
import com.bean.Temperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LightintensityMapper {

    //查询
    @Select("select * from hw_lightintensity where KEYID=#{KEYID} ")
    Lightintensity find(@Param("KEYID") Integer KEYID);
    //添加
    @Insert("insert into hw_lightintensity(`KEYID`,`SN`,`LIGHTLNTENSITY`,`LI_DATE`)values(#{KEYID},#{SN},#{LIGHTLNTENSITY},#{LI_DATE})")
    public void insertLightintensity(Lightintensity u);

    @Select("SELECT * FROM hw_lightintensity")
    public List<Lightintensity> selectLightintensity();

    //id自增列
    @Select("select (count(*)+1)from hw_lightintensity")
    public Integer idPlusLightintensity();
}
