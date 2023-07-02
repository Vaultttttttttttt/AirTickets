package mapperTest;

import com.air.mapper.SummaryMapper;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 17:58
* @version 1.0
*/

public class SummaryMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    SummaryMapper summaryMapper = sqlSession.getMapper(SummaryMapper.class);

    @Test
    public void testQuerySummaryByCname(){
        System.out.println(summaryMapper.querySummaryByCname());
    }

    @Test
    public void testQuerySummaryByModel(){
        System.out.println(summaryMapper.querySummaryByModel());
    }

    @Test
    public void testQuerySummaryByPlace(){
        System.out.println(summaryMapper.querySummaryByPlace());
    }
}
