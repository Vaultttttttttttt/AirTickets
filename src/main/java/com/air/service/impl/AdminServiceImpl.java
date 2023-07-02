package com.air.service.impl;

import com.air.mapper.AdminMapper;
import com.air.service.AdminService;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-28 20:51
* @version 1.0
*/

public class AdminServiceImpl implements AdminService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);

    @Override
    public int existUsername(String username) {
        return adminMapper.queryByUsername(username);
    }

    @Override
    public int login(String username, String password) {
        return adminMapper.queryByUsernameAndPassword(username,password);
    }
}
