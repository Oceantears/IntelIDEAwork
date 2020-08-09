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
}
