package mapperTest;

import com.air.mapper.GetTicketsMapper;
import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 21:21
* @version 1.0
*/

public class GetTicketsMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    GetTicketsMapper getTicketsMapper =  sqlSession.getMapper(GetTicketsMapper.class);

    @Test
    public void testGetTickets(){
        List<AirLine> list1 = getTicketsMapper.getTickets(new ChooseItem(
                "MU22222222",null,null,null,"007",null,null,null,null,null,null
        ));
        System.out.println(list1);
    }

    @Test
    public void testQueryAccountByCard(){
        System.out.println(getTicketsMapper.queryAccountByCard("普通"));
        System.out.println(getTicketsMapper.queryAccountByCard("银卡"));
        System.out.println(getTicketsMapper.queryAccountByCard("金卡"));
    }

    @Test
    public void testQueryPriceUpdate(){
        System.out.println(getTicketsMapper.queryPriceUpdate());
    }
}
