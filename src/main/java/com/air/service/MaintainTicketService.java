package com.air.service;

import com.air.pojo.AirLine;
import com.air.pojo.Company;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 18:04
* @version 1.0
*/

public interface MaintainTicketService {
    public SqlSession getSqlSession();

    //查询是否存在某日期有没有某航班，即会不会重复
    public int existDateAndLine(String line, Timestamp date);

    //获取某航班，即会不会重复
    public AirLine getLine(String line, Timestamp date);

    //添加机票
    public void addTicket(AirLine airLine);

    //修改机票
    public void updateTicket(AirLine airLine);

    //删除机票
    public void deleteTicket(String line, Timestamp date);

    //修改每日票价浮动因素
    public void updatePriceUpDay(int n);

    //修改售票情况票价浮动因素
    public void updatePriceUpNum(int n);

    //修改会员折扣
    public void updateVip(String card,int account);

    //查询航班号是否存在
    public int existLine(String line);

    //查询全部的公司
    public List<Company> getAllCompany();

    //添加公司
    public void addCompany(Company company);

    //按照公司名查找公司数量
    public int existCname(String cname);

    //按照航班编号查找公司数量
    public int existSign(String sign);
}
