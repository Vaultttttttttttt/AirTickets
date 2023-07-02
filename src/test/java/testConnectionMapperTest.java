import com.air.mapper.testConnectionMapper;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 13:19
* @version 1.0
*/

public class testConnectionMapperTest {
    @Test
    public void testInsertCard(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        testConnectionMapper testConnectionMapper = sqlSession.getMapper(com.air.mapper.testConnectionMapper.class);
        testConnectionMapper.insertCard("admin","admin");
    }
}
