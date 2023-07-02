package com.air.service;

import com.air.pojo.AirLine;

import java.util.List;
import java.util.Set;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 10:09
* @version 1.0
*/

public interface RecommendService {
    //按照性别选出最热门航班
    public List<AirLine> getAirlineByGender(String gender);

    //按照年龄选出最热门航班
    public List<AirLine> getAirlineByAge(Integer minAge,Integer maxAge);

    //按照学历选出最热门航班
    public List<AirLine> getAirlineByLevel(String level);

    //按照职业选出最热门航班
    public List<AirLine> getAirlineByJob(String job);

    //获得所有职业
    public Set<String> getAllJobs();
}
