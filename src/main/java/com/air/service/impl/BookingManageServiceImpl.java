package com.air.service.impl;

import com.air.mapper.BookingManageMapper;
import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.service.BookingManageService;
import com.air.service.BookingService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 16:14
* @version 1.0
*/

public class BookingManageServiceImpl implements BookingManageService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BookingManageMapper bookingManageMapper = sqlSession.getMapper(BookingManageMapper.class);

    @Override
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Override
    public List<Order> getAllOrders(String username) {
        return bookingManageMapper.queryAllOrders(username);
    }

    @Override
    public List<Order> getOrdersByStatus(String username, String status) {
        return bookingManageMapper.queryOrderByStatus(username,status);
    }

    @Override
    public List<Order> getOrdersByTime(String username, Timestamp startTime, Timestamp endTime) {
        List<String> orderNums = bookingManageMapper.queryOrderNumByTime(startTime,endTime);

        return bookingManageMapper.queryOrderByListOfTime(username,orderNums);
    }

    @Override
    public List<OrderItem> getOrderItem(String OrderNum) {
        return bookingManageMapper.queryOrderItemByOrderNum(OrderNum);
    }

    @Override
    public void updateOrderItemOfStatus(String OrderNum) {
        bookingManageMapper.updateStatusToFinish(OrderNum);
    }

    @Override
    public void deleteOrderByOrderNum(String orderNum) {
        bookingManageMapper.deleteOrderByOrderNum(orderNum);
    }
}
