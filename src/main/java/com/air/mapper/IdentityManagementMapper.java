package com.air.mapper;

import com.air.pojo.Customer;
import org.apache.ibatis.annotations.Param;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 10:08
* @version 1.0
*/

public interface IdentityManagementMapper {
    //修改vip信息
    public void updateVipInCustomerByName(@Param("name") String name,@Param("card") String card);

    //查询当前绑定人的vip等级
    public String queryCardByName(@Param("name") String name);

    //查询身份的详细信息
    public Customer queryCustomerByName(@Param("name") String name);

    //修改Customer表的身份信息
    public void updateCustomerInCustomerByName(Customer customer);

    //查询vip优惠制度
    public int queryAccountByCard(@Param("card") String card);
}
