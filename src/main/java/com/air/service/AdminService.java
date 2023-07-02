package com.air.service;

import com.air.pojo.User;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-28 20:48
* @version 1.0
*/

public interface AdminService {
    //检查是否存在账号，存在返回1，不存在返回0
    public int existUsername(String username);

    //登录管理员用户,存在返回1，不存在返回0
    public int login(String username,String password);
}
