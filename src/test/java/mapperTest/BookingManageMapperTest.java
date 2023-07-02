package mapperTest;

import com.air.mapper.BookingManageMapper;
import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 15:38
* @version 1.0
*/

public class BookingManageMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BookingManageMapper bookingManageMapper = sqlSession.getMapper(BookingManageMapper.class);

    @Test
    public void testQueryAllOrders(){
        List<Order> orders = bookingManageMapper.queryAllOrders("20211445");
        System.out.println(orders);
    }

    @Test
    public void testQueryOrderByStatus(){
        List<Order> orders = bookingManageMapper.queryOrderByStatus("20211445","未出行");
        System.out.println(orders);
    }

    @Test
    public void testQueryOrderNumByTime(){
        List<String> order = bookingManageMapper.queryOrderNumByTime(Timestamp.valueOf("2023-07-06 00:00:00"),null);
        System.out.println(order);
    }

    @Test
    public void testQueryOrderByListOfTime(){
        List<String> time = bookingManageMapper.queryOrderNumByTime(Timestamp.valueOf("2023-07-06 00:00:00"),null);
        List<Order> order = bookingManageMapper.queryOrderByListOfTime("20211445",time);
        System.out.println(order);
    }

    @Test
    public void testQueryOrderItemByOrderNum(){
        List<OrderItem> orderItems = bookingManageMapper.queryOrderItemByOrderNum("168705839965720211445");
        System.out.println(orderItems);
    }

    @Test
    public void testUpdateStatusToFinish(){
        bookingManageMapper.updateStatusToFinish("168705839965720211445");
        sqlSession.commit();
    }

    @Test
    public void testDeleteOrderByOrderNum(){
        bookingManageMapper.deleteOrderByOrderNum("168705839965720211445");
        sqlSession.commit();
    }
}
