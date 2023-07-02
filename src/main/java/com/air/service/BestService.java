package com.air.service;

import com.air.pojo.DetailedAirline;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 15:17
* @version 1.0
*/

public interface BestService {
    //获得所有航空公司名称
    public List<String> getAllCompany();

    //按照航空公司名称获得航班（已经按照降序排序）
    public List<DetailedAirline> getBest(String cname);

    //查询最热门的航空公司
    public List<DetailedAirline> Best();
}
