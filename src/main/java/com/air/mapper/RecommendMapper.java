package com.air.mapper;

import com.air.pojo.AirLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 9:12
* @version 1.0
*/

public interface RecommendMapper {
    //按照性别查询出最热门航班
    public List<AirLine> queryAirlineByGender(@Param("gender") String gender);

    //按照年龄查询出最热门航班
    public List<AirLine> queryAirlineByAge(@Param("minAge") Integer minAge,@Param("maxAge") Integer maxAge);

    //按照学历查询出最热门航班
    public List<AirLine> queryAirlineByLevel(@Param("level") String level);

    //查询所有职业
    public Set<String> queryAllJobs();

    //按照职业查询出最热门航班
    public List<AirLine> queryAirlineByJob(@Param("job") String job);
}
