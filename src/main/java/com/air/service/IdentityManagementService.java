package com.air.service;

import com.air.pojo.Customer;
import org.apache.ibatis.session.SqlSession;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 10:50
* @version 1.0
*/

public interface IdentityManagementService {

    public SqlSession getSqlSession();

    //修改vip信息
    public void updateVipInCustomer(String name,String card);

    //获取当前绑定人的vip等级
    public String getCardByName(String name);

    //获取身份详细信息
    public Customer getCustomerByName(String name);

    //修改Customer表身份信息
    public void updateCustomerInCustomer(Customer customer);

    //获取vip优惠制度
    public int getAccountByCard(String card);


}
