package com.air.service.impl;

import com.air.mapper.SummaryMapper;
import com.air.pojo.DetailedAirline;
import com.air.service.SummaryService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 18:16
* @version 1.0
*/

public class SummaryServiceImpl implements SummaryService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    SummaryMapper summaryMapper = sqlSession.getMapper(SummaryMapper.class);

    @Override
    public List<DetailedAirline> getSummaryByCname() {
        return summaryMapper.querySummaryByCname();
    }

    @Override
    public List<DetailedAirline> getSummaryByModel() {
        return summaryMapper.querySummaryByModel();
    }

    @Override
    public List<DetailedAirline> getSummaryByPlace() {
        return summaryMapper.querySummaryByPlace();
    }
}
