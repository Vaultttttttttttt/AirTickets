package com.air.mapper;

import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.pojo.PriceUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 20:27
* @version 1.0
*/

public interface GetTicketsMapper {
    //根据某些条件查询机票
    public List<AirLine> getTickets(ChooseItem chooseItem);

    //查询对应等级优惠制度
    public int queryAccountByCard(@Param("card") String card);

    //查询每日因素
    public PriceUpdate queryPriceUpdate();
}
