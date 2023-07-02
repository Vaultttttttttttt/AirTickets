package com.air.service;

import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 16:07
* @version 1.0
*/

public interface BookingManageService {
    public SqlSession getSqlSession();

    //获取所有订单
    public List<Order> getAllOrders(String username);

    //获取相关状态的订单
    public List<Order> getOrdersByStatus(String username,String status);

    //按照时间区间获取订单
    public List<Order> getOrdersByTime(String username, Timestamp startTime,Timestamp endTime);

    //获取订单详情
    public List<OrderItem> getOrderItem(String OrderNum);

    //修改订单状态为已出行
    public void updateOrderItemOfStatus(String OrderNum);

    //删除订单
    public void deleteOrderByOrderNum(String orderNum);
}
