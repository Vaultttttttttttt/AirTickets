package com.air.service.impl;

import com.air.mapper.GetTicketsMapper;
import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.pojo.PriceUpdate;
import com.air.service.GetTicketsService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-12 9:08
* @version 1.0
*/

public class GetTicketsServiceImpl implements GetTicketsService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    GetTicketsMapper getTicketsMapper = sqlSession.getMapper(GetTicketsMapper.class);

    @Override
    public List<AirLine> getTickets(ChooseItem chooseItem) {
        return getTicketsMapper.getTickets(chooseItem);
    }

    @Override
    public int getCard(String card) {
        return getTicketsMapper.queryAccountByCard(card);
    }

    @Override
    public PriceUpdate getPriceUpdate() {
        return getTicketsMapper.queryPriceUpdate();
    }
}
