package com.air.service.impl;

import com.air.mapper.MaintainTicketMapper;
import com.air.pojo.AirLine;
import com.air.pojo.Company;
import com.air.service.MaintainTicketService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 19:03
* @version 1.0
*/

public class MaintainTicketServiceImpl implements MaintainTicketService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

    @Override
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    //查询是否存在某日期有没有某航班，即会不会重复
    @Override
    public int existDateAndLine(String line, Timestamp date) {
        return maintainTicketMapper.queryByLineAndDate(line,date);
    }

    @Override
    public AirLine getLine(String line, Timestamp date) {
        return maintainTicketMapper.queryAndGetByLineAndDate(line,date);
    }

    //添加机票
    @Override
    public void addTicket(AirLine airLine) {
        maintainTicketMapper.insertTicket(airLine);
        maintainTicketMapper.insertTicketOther(airLine);
    }

    //修改机票
    @Override
    public void updateTicket(AirLine airLine) {
        maintainTicketMapper.updateByLineAndDate(airLine);
        maintainTicketMapper.updateByLineAndDateOther(airLine);
    }

    //删除机票
    @Override
    public void deleteTicket(String line,Timestamp date) {
        maintainTicketMapper.deleteByLineAndDate(line,date);
        maintainTicketMapper.deleteByLineAndDateOther(line,date);
    }

    //修改每日票价浮动因素
    @Override
    public void updatePriceUpDay(int n) {
        maintainTicketMapper.updateByPriceUpDay(n);
    }

    //修改售票情况票价浮动因素
    @Override
    public void updatePriceUpNum(int n) {
        maintainTicketMapper.updateByPriceUpNum(n);
    }

    //修改会员折扣
    @Override
    public void updateVip(String card, int account) {
        maintainTicketMapper.updateByCard(card,account);
    }

    //查询航班号是否存在
    @Override
    public int existLine(String line) {
        return maintainTicketMapper.queryCountByLine(line);
    }

    @Override
    public List<Company> getAllCompany() {
        return maintainTicketMapper.queryCompany();
    }

    @Override
    public void addCompany(Company company) {
        maintainTicketMapper.addCompany(company);
    }

    @Override
    public int existCname(String cname) {
        return maintainTicketMapper.queryCountByCname(cname);
    }

    @Override
    public int existSign(String sign) {
        return maintainTicketMapper.queryCountBySign(sign);
    }
}
