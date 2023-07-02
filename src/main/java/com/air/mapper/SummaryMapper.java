package com.air.mapper;

import com.air.pojo.DetailedAirline;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 17:36
* @version 1.0
*/

public interface SummaryMapper {
    //按照航空公司查询报表
    public List<DetailedAirline> querySummaryByCname();

    //按照机型查询报表
    public List<DetailedAirline> querySummaryByModel();

    //按照航线查询报表
    public List<DetailedAirline> querySummaryByPlace();
}
