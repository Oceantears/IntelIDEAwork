package com.mapper;

import com.bean.Altitude;
import com.bean.AtmosphericHumidity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AtmosphericHumidityMapper {
    //添加
    @Insert("insert into hw_atmosphericHumidity(`KEYID`,`SN`,`ATMOSPHERICHUMIDTY`,`AT_DATE`)values(#{KEYID},#{SN},#{ATMOSPHERICHUMIDTY},#{AT_DATE})")
    public void insertAtmosphericHumidity(AtmosphericHumidity a);

    @Select("SELECT * FROM hw_atmosphericHumidity")
    public List<AtmosphericHumidity> selectAtmosphericHumidity();

    //id自增列
    @Select("select (count(*)+1)from hw_atmosphericHumidity")
    public Integer idPlusAtmosphericHumidity();

    //SN查数据
    @Select("SELECT * FROM hw_atmosphericHumidity where SN=#{SN}")
    public List<AtmosphericHumidity> selectAtmosphericHumiditySN(String SN);



    //查日期
    @Select("SELECT hw_atmosphericHumidity.ATMOSPHERICHUMIDTY FROM `hw_atmosphericHumidity` WHERE `AT_DATE` >=#{data1} AND `AT_DATE` <=#{data2} AND SN=#{EQ_SN}")
    List<Integer> selectshidu(String data1, String data2, String EQ_SN);
}
