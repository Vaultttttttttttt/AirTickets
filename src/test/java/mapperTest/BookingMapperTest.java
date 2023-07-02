package mapperTest;

import com.air.mapper.BookingMapper;
import com.air.pojo.Customer;
import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.utils.SqlSessionUtil;
import com.air.utils.WebUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 18:33
* @version 1.0
*/

public class BookingMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BookingMapper bookingMapper = sqlSession.getMapper(BookingMapper.class);

    @Test
    public void testQueryCustomerByName(){
        System.out.println(bookingMapper.queryCustomerByName("汪欣骏"));
    }

    @Test
    public void testQueryAccountByCard(){
        System.out.println(bookingMapper.queryAccountByCard("金卡"));
        System.out.println(bookingMapper.queryAccountByCard("银卡"));
        System.out.println(bookingMapper.queryAccountByCard("普通"));
    }

    @Test
    public void testInsertOrder(){
        bookingMapper.insertOrder(new Order(
                "2222","20211448",1000,"未出行"
        ));
        sqlSession.commit();
    }

    @Test
    public void testInsertOrderItem(){
        bookingMapper.insertOrderItem(new OrderItem(
                "2222","罗绍泽","MU222222", Timestamp.valueOf("2023-06-17 00:00:00"),"商务舱",1000
        ));
        sqlSession.commit();
    }

    @Test
    public void testQueryByNameAndLineAndDate(){
        System.out.println(bookingMapper.queryByNameAndLineAndDate("汪欣骏","MU222222",Timestamp.valueOf("2023-06-17 00:00:00")));
    }
}
