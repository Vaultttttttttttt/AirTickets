package mapperTest;

import com.air.mapper.RecommendMapper;
import com.air.pojo.AirLine;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 9:39
* @version 1.0
*/

public class RecommendMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    RecommendMapper recommendMapper = sqlSession.getMapper(RecommendMapper.class);

    @Test
    public void testQueryAirlineByGender(){
        List<AirLine> airLine1 = recommendMapper.queryAirlineByGender("男");
        List<AirLine> airLine2 = recommendMapper.queryAirlineByGender("女");

        System.out.println(airLine1);
        System.out.println(airLine2);
    }

    @Test
    public void testQueryAirlineByAge(){
        List<AirLine> airLine1 = recommendMapper.queryAirlineByAge(0,14);
        List<AirLine> airLine2 = recommendMapper.queryAirlineByAge(15,35);
        List<AirLine> airLine3 = recommendMapper.queryAirlineByAge(36,64);
        List<AirLine> airLine4 = recommendMapper.queryAirlineByAge(65,null);

        System.out.println(airLine1);
        System.out.println(airLine2);
        System.out.println(airLine3);
        System.out.println(airLine4);
    }

    @Test
    public void testQueryAirlineByLevel(){
        List<AirLine> airLine = recommendMapper.queryAirlineByLevel("本科生");
        System.out.println(airLine);
    }

    @Test
    public void testQueryAllJobs(){
        Set<String> job = recommendMapper.queryAllJobs();
        System.out.println(job);
    }

    @Test
    public void testQueryAirlineByJob(){
        Set<String> jobs = recommendMapper.queryAllJobs();
        Map<String,List<AirLine>> map = new HashMap<>();

        for(String job:jobs){
            map.put(job,recommendMapper.queryAirlineByJob(job));
        }

        System.out.println(map);
    }
}
