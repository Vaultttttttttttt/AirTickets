package com.air.mapper;

import org.apache.ibatis.annotations.Param;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 13:13
* @version 1.0
*/

public interface testConnectionMapper {
    void insertCard(@Param("username") String username,@Param("password") String password);
}
