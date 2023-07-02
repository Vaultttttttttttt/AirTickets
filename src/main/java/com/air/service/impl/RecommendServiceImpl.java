package com.air.service.impl;

import com.air.mapper.RecommendMapper;
import com.air.pojo.AirLine;
import com.air.service.RecommendService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Set;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 10:13
* @version 1.0
*/

public class RecommendServiceImpl implements RecommendService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    RecommendMapper recommendMapper = sqlSession.getMapper(RecommendMapper.class);

    @Override
    public List<AirLine> getAirlineByGender(String gender) {
        return recommendMapper.queryAirlineByGender(gender);
    }

    @Override
    public List<AirLine> getAirlineByAge(Integer minAge, Integer maxAge) {
        return recommendMapper.queryAirlineByAge(minAge,maxAge);
    }

    @Override
    public List<AirLine> getAirlineByLevel(String level) {
        return recommendMapper.queryAirlineByLevel(level);
    }

    @Override
    public List<AirLine> getAirlineByJob(String job) {
        return recommendMapper.queryAirlineByJob(job);
    }

    @Override
    public Set<String> getAllJobs() {
        return recommendMapper.queryAllJobs();
    }
}
