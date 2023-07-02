package com.air.service;

import com.air.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 18:55
* @version 1.0
*/

public interface BookingService {
    public SqlSession getSqlSession();

    //根据某些条件查询机票
    public List<AirLine> getTickets(ChooseItem chooseItem);

    //根据姓名获取乘客信息
    public Customer getCustomerByName(String name);

    //根据vip等级查询打折优惠折扣
    public int getAccountByCard(String card);

    //添加机票
    public void addOrder(Order order);

    //添加机票详细信息
    public void addOrderItem(OrderItem orderItem);

    //根据姓名，航班号，日期查询订单号
    public int queryByNameAndLineAndDate(String name, String line, Timestamp date);

}
