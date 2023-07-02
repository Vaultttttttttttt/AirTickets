package mapperTest;

import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.air.mapper.AdminMapper;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-28 20:42
* @version 1.0
*/

public class AdminMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);

    @Test
    public void testQueryByUsername(){
        System.out.println(adminMapper.queryByUsername("admin"));
        System.out.println(adminMapper.queryByUsername("user"));
    }

    @Test
    public void testQueryByUsernameAndPassword(){
        System.out.println(adminMapper.queryByUsernameAndPassword("admin","admin"));
        System.out.println(adminMapper.queryByUsernameAndPassword("admin","user"));
        System.out.println(adminMapper.queryByUsernameAndPassword("user","admin"));
        System.out.println(adminMapper.queryByUsernameAndPassword("user","ad"));
    }
}
