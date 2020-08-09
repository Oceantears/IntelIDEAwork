package com.mapper;
import com.bean.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CameraMapper {
    //添加
    @Insert("insert into camera(`KEYID`,`ATKEYID`,`QYID`,`JDID`,`SBNO`,`SBYZM`,`deviceSerial`,`channelNo`,`deviceName`,`liveAddress`,`hdAddress`,`rtmp`,`rtmpHd`,`beginTime`,`endTime`,`status`,`exception`,`flvAddress`,`hdFlvAddress`)" +
            "values(#{KEYID},#{ATKEYID},#{QYID},#{JDID},#{SBNO},#{SBYZM},#{deviceSerial},#{channelNo},#{deviceName},#{liveAddress},#{hdAddress},#{rtmp},#{rtmpHd},#{beginTime},#{endTime},#{status},#{exception},#{flvAddress},#{hdFlvAddress})")
    public void insertcamera(Camera cam);

    //id自增列
    @Select("select (count(*)+1)from camera")
    public Integer idPluscamera();

    @Select("SELECT  * FROM camera where deviceSerial=#{deviceSerial} ")
    List<Camera> select(@Param("deviceSerial")String deviceSerial);

    @Select("select * from camera where ATKEYID=#{ATKEYID}")
    List<Camera> selectid(@Param("ATKEYID")Integer ATKEYID);

    @Select("select * from camera where KEYID=#{KEYID}")
    Camera findid(@Param("KEYID")Integer KEYID);
    //查询所有信息
    @Select("select * from camera ")
    List<Camera> selectAll();

    //cameraMapper.selectAll(EQ_SN);
    //查询所有信息
    @Select("select * from camera where deviceSerial=#{deviceSerial}")
    List<Camera> selectAllsn(String EQ_SN);
//查询所有序列号
    @Select("select deviceSerial from camera ")
    List<String> selectdeviceSerial();

    //删除
    @Delete("delete from camera where ATKEYID=#{ATKEYID}")
    void delete(@Param("ATKEYID") Integer ATKEYID);


    @Select("select * from camera where deviceSerial=#{deviceSerial}")
    Camera deviceSeriallist(@Param("deviceSerial")String deviceSerial);

    //清空表操作

    @Delete("DELETE FROM `camera`")
    void deleteAll();


    @Select("SELECT * FROM camera where deviceSerial=#{SN} ")
    public Camera selectCameraSN(String SN);

}
