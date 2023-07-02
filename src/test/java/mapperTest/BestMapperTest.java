package mapperTest;

import com.air.mapper.BestMapper;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 15:12
* @version 1.0
*/

public class BestMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BestMapper bestMapper = sqlSession.getMapper(BestMapper.class);

    @Test
    public void testGetAllCompany(){
        System.out.println(bestMapper.queryAllCompany());
    }

    @Test
    public void testQueryBestByCname(){
        /*List<String> cnames = bestMapper.queryAllCompany();

        for(String cname:cnames){
            System.out.println(bestMapper.queryBestByCname(cname));
        }*/

        System.out.println(bestMapper.queryBestByCname(""));
    }

    @Test
    public void testGetBest(){
        System.out.println(bestMapper.queryBest());
    }
}
