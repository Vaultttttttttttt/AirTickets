package com.air.service;

import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.pojo.PriceUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-12 9:07
* @version 1.0
*/

public interface GetTicketsService {
    //根据某些条件查询机票
    public List<AirLine> getTickets(ChooseItem chooseItem);

    //查询对应等级优惠制度
    public int getCard(String card);

    //查询每日因素
    public PriceUpdate getPriceUpdate();
}
