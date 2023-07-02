package com.air.service.impl;

import com.air.mapper.UserMapper;
import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.service.UserService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 16:04
* @version 1.0
*/

public class UserServiceImpl implements UserService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public SqlSession getSqlSession(){
        return sqlSession;
    }

    //注册用户
    @Override
    public void register(User user) {
        try{
            userMapper.saveUser(user);

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //登录用户，返回用户
    @Override
    public User login(User user) {
        return userMapper.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    //保存用户基本身份信息
    @Override
    public void saveIdentity(Customer customer) {
        try{
            userMapper.saveCustomer(customer);

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //检查是否存在账号，存在返回1，不存在返回0
    @Override
    public int existUsername(String username) {
        return userMapper.queryByUsername(username);
    }

    //检查是否存在用户的姓名，存在返回1，不存在0
    @Override
    public int existName(String name) {
        return userMapper.queryByName(name);
    }
}
