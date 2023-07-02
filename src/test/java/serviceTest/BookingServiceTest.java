package serviceTest;

import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.service.BookingService;
import com.air.service.impl.BookingServiceImpl;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 19:02
* @version 1.0
*/

public class BookingServiceTest {
    BookingService bookingService = new BookingServiceImpl();
    SqlSession sqlSession = bookingService.getSqlSession();

    @Test
    public void testGetCustomerByName(){
        System.out.println(bookingService.getCustomerByName("汪欣骏"));
    }

    @Test
    public void testGetAccountByCard(){
        System.out.println(bookingService.getAccountByCard("普通"));
        System.out.println(bookingService.getAccountByCard("银卡"));
        System.out.println(bookingService.getAccountByCard("金卡"));
    }

    @Test
    public void testAddOrder(){
        bookingService.addOrder(new Order(
                "23324","20211445",100,"未出行"
        ));
        sqlSession.commit();
    }

    @Test
    public void testAddOrderItem(){
        bookingService.addOrderItem(new OrderItem(
                "23324","罗绍泽","MU222222", Timestamp.valueOf("2023-06-17 00:00:00"),"商务舱",1000
        ));
        sqlSession.commit();
    }

    @Test
    public void testQueryByNameAndLineAndDate(){
        System.out.println(bookingService.queryByNameAndLineAndDate("汪欣骏","MU222222",Timestamp.valueOf("2023-06-17 00:00:00")));

    }
}
