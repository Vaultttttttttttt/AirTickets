package com.air.service.impl;

import com.air.mapper.IdentityManagementMapper;
import com.air.pojo.Customer;
import com.air.service.IdentityManagementService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 10:57
* @version 1.0
*/

public class IdentityManagementServiceImpl implements IdentityManagementService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    IdentityManagementMapper identityManagementMapper = sqlSession.getMapper(IdentityManagementMapper.class);

    @Override
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Override
    public void updateVipInCustomer(String name, String card) {
        identityManagementMapper.updateVipInCustomerByName(name,card);
    }

    @Override
    public String getCardByName(String name) {
        return identityManagementMapper.queryCardByName(name);
    }

    @Override
    public Customer getCustomerByName(String name) {
        return identityManagementMapper.queryCustomerByName(name);
    }

    @Override
    public void updateCustomerInCustomer(Customer customer) {
        identityManagementMapper.updateCustomerInCustomerByName(customer);
    }

    @Override
    public int getAccountByCard(String card) {
        return identityManagementMapper.queryAccountByCard(card);
    }

}
