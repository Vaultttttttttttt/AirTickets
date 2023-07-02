package com.air.mapper;

import com.air.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 16:19
* @version 1.0
*/

public interface BookingMapper {
    //根据某些信息查询航班
    public List<AirLine> getAirline(ChooseItem chooseItem);

    //根据乘客姓名获取该乘客的信息
    public Customer queryCustomerByName(@Param("name") String name);

    //根据Vip等级查询打折优惠折扣
    public int queryAccountByCard(@Param("card")String card);

    //添加买的机票
    public void insertOrder(Order order);

    //添加机票的详细信息
    public void insertOrderItem(OrderItem orderItem);

    //根据姓名，航班号，日期查询订单号
    public int queryByNameAndLineAndDate(@Param("name") String name, @Param("line") String line, @Param("date") Timestamp date);
}
