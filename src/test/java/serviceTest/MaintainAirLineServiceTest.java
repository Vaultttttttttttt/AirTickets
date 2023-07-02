package serviceTest;

import com.air.pojo.AirLine;
import com.air.service.MaintainTicketService;
import com.air.service.impl.MaintainTicketServiceImpl;
import org.junit.Test;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 19:07
* @version 1.0
*/

public class MaintainAirLineServiceTest {
    MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();

    @Test
    public void testExistLine(){
        System.out.println(maintainTicketService.existLine("MU"));
        System.out.println(maintainTicketService.existLine("DD"));
    }

    @Test
    public void testExistDateAndLine(){
        System.out.println(maintainTicketService.existDateAndLine("MU22222222", Timestamp.valueOf("2023-07-15 08:00:00")));
        System.out.println(maintainTicketService.existDateAndLine("MU22222222", Timestamp.valueOf("2023-07-15 09:00:00")));
        System.out.println(maintainTicketService.existDateAndLine("MU22222211", Timestamp.valueOf("2023-07-15 08:00:00")));
        System.out.println(maintainTicketService.existDateAndLine("MU22222213", Timestamp.valueOf("2023-07-16 08:00:00")));
    }

    @Test
    public void testAddTicket(){
        maintainTicketService.addTicket(new AirLine(
                "MU22222222",Timestamp.valueOf("2023-7-16 09:00:00"),
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),
                "007",100,100,100,100,"上海","俄罗斯",
                100,100
        ));

        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testUpdateTicket(){
        maintainTicketService.updateTicket(new AirLine(
                "MU22222222",Timestamp.valueOf("2023-7-16 09:00:00"),
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),
                "007",100000,100,100,100,"上海","俄罗斯",
                100,100
        ));

        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testDeleteTicket(){
        maintainTicketService.deleteTicket("MU22222222",Timestamp.valueOf("2023-7-16 09:00:00"));
        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testUpdatePriceUpDay(){
        maintainTicketService.updatePriceUpDay(10);
        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testUpdatePriceUpNum(){
        maintainTicketService.updatePriceUpNum(10);
        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testUpdateVip(){
        maintainTicketService.updateVip("银卡",95);
        maintainTicketService.updateVip("金卡",90);
        maintainTicketService.getSqlSession().commit();
    }

    @Test
    public void testGetLine(){
        System.out.println(maintainTicketService.getLine("MU22222222", Timestamp.valueOf("2023-07-15 08:00:00")));
        System.out.println(maintainTicketService.getLine("MU22222222", Timestamp.valueOf("2023-07-15 09:00:00")));
        System.out.println(maintainTicketService.getLine("MU22222211", Timestamp.valueOf("2023-07-15 08:00:00")));
        System.out.println(maintainTicketService.getLine("MU22222213", Timestamp.valueOf("2023-07-16 08:00:00")));
    }
}
