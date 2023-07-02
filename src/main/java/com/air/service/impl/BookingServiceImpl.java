package com.air.service.impl;

import com.air.mapper.BookingMapper;
import com.air.pojo.*;
import com.air.service.BookingService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 18:58
* @version 1.0
*/

public class BookingServiceImpl implements BookingService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BookingMapper bookingMapper = sqlSession.getMapper(BookingMapper.class);

    @Override
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Override
    public List<AirLine> getTickets(ChooseItem chooseItem) {
        return bookingMapper.getAirline(chooseItem);
    }

    @Override
    public Customer getCustomerByName(String name) {
        return bookingMapper.queryCustomerByName(name);
    }

    @Override
    public int getAccountByCard(String card) {
        return bookingMapper.queryAccountByCard(card);
    }

    @Override
    public void addOrder(Order order) {
        bookingMapper.insertOrder(order);
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        bookingMapper.insertOrderItem(orderItem);
    }

    @Override
    public int queryByNameAndLineAndDate(String name, String line, Timestamp date) {
        return bookingMapper.queryByNameAndLineAndDate(name,line,date);
    }
}
