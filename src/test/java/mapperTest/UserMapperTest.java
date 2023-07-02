package mapperTest;

import com.air.mapper.UserMapper;
import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 15:27
* @version 1.0
*/

public class UserMapperTest {
    @Test
    public void testSaveCustomer(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.saveCustomer(new Customer("汪欣骏","男",20,"本科","学生"));
    }

    @Test
    public void testSaveUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.saveUser(new User("20211446","qwer1234","18358264283","汪欣骏"));
    }

    @Test
    public void testQueryByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.queryByUsername("20211445"));
    }

    @Test
    public void testQueryByUsernameAndPassword(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.queryByUsernameAndPassword("20211445","qwer1234"));
    }

    @Test
    public void testQueryByName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.queryByName("汪欣骏"));
        System.out.println(userMapper.queryByName("哦空空"));
    }
}
