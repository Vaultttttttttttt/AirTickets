package serviceTest;

import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.service.GetTicketsService;
import com.air.service.impl.GetTicketsServiceImpl;
import org.junit.Test;

import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-12 9:19
* @version 1.0
*/

public class GetTicketsServiceTest {
    GetTicketsService getTicketsService = new GetTicketsServiceImpl();
    @Test
    public void testGetTickets(){
        List<AirLine> airLines = getTicketsService.getTickets(new ChooseItem());
        for(AirLine airLine:airLines){
            System.out.println(airLine);
        }
    }

    @Test
    public void testGetCard(){
        System.out.println(getTicketsService.getCard("普通"));
        System.out.println(getTicketsService.getCard("银卡"));
        System.out.println(getTicketsService.getCard("金卡"));
    }

    @Test
    public void testGetPriceUpdate(){
        System.out.println(getTicketsService.getPriceUpdate());
    }
}
