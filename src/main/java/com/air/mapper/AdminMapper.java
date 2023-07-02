package com.air.mapper;

import com.air.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-05-28 20:37
 */

public interface AdminMapper {
    /**
     * @description: 根据管理员账号查询
     * @param: username
     * @return: int
     * @author wxj27
     * @date: 2023-05-28 20:38
     */
    int queryByUsername(@Param("username") String username);

    /**
     * @description: 根据管理员账号和管理员密码查询
     * @param: username
     * @param: password
     * @return: int
     * @author wxj27
     * @date: 2023-05-28 20:39
     */
    int queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
