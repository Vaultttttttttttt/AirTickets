package com.air.mapper;

import com.air.pojo.DetailedAirline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 14:56
* @version 1.0
*/

public interface BestMapper {
    //查询所有航空公司名称
    public List<String> queryAllCompany();

    //根据公司名查找最热门的航班
    public List<DetailedAirline> queryBestByCname(@Param("cname") String cname);

    //查询最热门的航空公司
    public List<DetailedAirline> queryBest();
}
