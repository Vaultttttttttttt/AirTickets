package serviceTest;

import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.service.BookingManageService;
import com.air.service.impl.BookingManageServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 16:20
* @version 1.0
*/

public class BookingManageServiceTest {
    BookingManageService bookingManageService = new BookingManageServiceImpl();

    @Test
    public void testGetAllOrders(){
        List<Order> orders = bookingManageService.getAllOrders("20211445");
        System.out.println(orders);
    }

    @Test
    public void testGetOrdersByStatus(){
        List<Order> orders = bookingManageService.getOrdersByStatus("20211445","未出行");
        System.out.println(orders);
    }

    @Test
    public void testGetOrdersByTime(){
        List<Order> orders = bookingManageService.getOrdersByTime("20211445", Timestamp.valueOf("2023-07-17 00:00:00"),Timestamp.valueOf("2023-07-28 00:00:00"));
        System.out.println(orders);
    }

    @Test
    public void testGetOrderItem(){
        List<OrderItem> orderItems = bookingManageService.getOrderItem("168707673453820211445");
        System.out.println(orderItems);
    }

    @Test
    public void testUpdateOrderItemOfStatus(){
        bookingManageService.updateOrderItemOfStatus("168707673453820211445");
        bookingManageService.getSqlSession().commit();
    }

    @Test
    public void testDeleteOrderByOrderNum(){
        bookingManageService.deleteOrderByOrderNum("168707673453820211445");
        bookingManageService.getSqlSession().commit();
    }
}
