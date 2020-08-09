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


    //SN查找数据
    @Select("SELECT * FROM hw_lightintensity where SN=#{SN}")
    public List<Lightintensity> selectLightintensitySN(String SN);


    //查日期
    @Select("SELECT hw_lightintensity.LIGHTLNTENSITY FROM `hw_lightintensity` WHERE `LI_DATE` >=#{data1} AND `LI_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectguangzhao(String data1, String data2, String EQ_SN);
}
