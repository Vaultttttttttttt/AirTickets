package com.air.mapper;

import com.air.pojo.Customer;
import com.air.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-05-27 14:19
 */

public interface UserMapper {
    /**
     * @description: 将用户的账号密码等最基本的信息存入数据库
     * @param: user
     * @return: void
     * @author wxj27
     * @date: 2023-05-27 14:35
     */
    void saveUser(User user);

    /**
     * @description: 将该用户一对一的身份信息存入数据库
     * @param: customer
     * @return: void
     * @author wxj27
     * @date: 2023-05-27 14:37
     */
    void saveCustomer(Customer customer);

    /**
     * @description: 查询注册时的用户名是否存在，为0不存在，可以注册；为1存在，不可注册
     * @param: username
     * @return: int
     * @author wxj27
     * @date: 2023-05-27 14:51
     */
    int queryByUsername(@Param("username") String username);

    /**
     * @description: 查询注册时的用户的姓名是否存在，为0不存在，可以注册；为1存在，不可注册
     * @param: name
     * @return: int
     * @author wxj27
     * @date: 2023-05-27 15:17
     */
    int queryByName(@Param("name") String name);

    /**
     * @description: 查询登录时的用户名和密码是否存在，返回用户
     * @param: username
     * @param: password
     * @return: int
     * @author wxj27
     * @date: 2023-05-27 15:17
     */
    User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
