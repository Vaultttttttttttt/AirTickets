package com.air.service;

import com.air.pojo.DetailedAirline;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 18:12
* @version 1.0
*/

public interface SummaryService {
    //按照航空公司分组得到报表
    public List<DetailedAirline> getSummaryByCname();

    //按照机型分组得到报表
    public List<DetailedAirline> getSummaryByModel();

    //按照航线分组得到报表
    public List<DetailedAirline> getSummaryByPlace();
}
