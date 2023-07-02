package com.air.service;

import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 15:51
* @version 1.0
*/

public interface UserService {

    public SqlSession getSqlSession();

    //注册用户
    public void register(User user);

    //登录用户，返回用户
    public User login(User user);

    //保存用户基本身份信息
    public void saveIdentity(Customer customer);

    //检查是否存在账号，存在返回1，不存在返回0
    public int existUsername(String username);

    //检查是否存在用户的姓名，存在返回1，不存在0
    public int existName(String name);
}
