package com.air.mapper;

import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 15:08
* @version 1.0
*/

public interface BookingManageMapper {
    //查询所有订单
    public List<Order> queryAllOrders(@Param("username") String username);

    //根据状态查询相关订单
    public List<Order> queryOrderByStatus(@Param("username") String username,@Param("status") String status);

    //根据时间区间查询订单号
    public List<String> queryOrderNumByTime(@Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    //按照订单号集合查询相关订单
    public List<Order> queryOrderByListOfTime(@Param("username") String username,@Param("orderList") List<String> orderList);

    //按照订单号查询订单详情
    public List<OrderItem> queryOrderItemByOrderNum(@Param("orderNum") String orderNum);

    //修改订单状态为已出行
    public void updateStatusToFinish(@Param("orderNum") String orderNum);

    //按照订单号删除订单
    public void deleteOrderByOrderNum(@Param("orderNum") String orderNum);
}
