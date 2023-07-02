package com.air.service.impl;

import com.air.mapper.BestMapper;
import com.air.pojo.DetailedAirline;
import com.air.service.BestService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 15:23
* @version 1.0
*/

public class BestServiceImpl implements BestService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BestMapper bestMapper = sqlSession.getMapper(BestMapper.class);

    @Override
    public List<String> getAllCompany() {
        return bestMapper.queryAllCompany();
    }

    @Override
    public List<DetailedAirline> getBest(String cname) {
        return bestMapper.queryBestByCname(cname);
    }

    @Override
    public List<DetailedAirline> Best() {
        return bestMapper.queryBest();
    }
}
