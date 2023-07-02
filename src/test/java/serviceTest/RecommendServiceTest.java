package serviceTest;

import com.air.service.RecommendService;
import com.air.service.impl.RecommendServiceImpl;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 10:17
* @version 1.0
*/

public class RecommendServiceTest {
    RecommendService recommendService = new RecommendServiceImpl();

    @Test
    public void testGetAirlineByGender(){
        System.out.println(recommendService.getAirlineByGender("男"));
    }

    @Test
    public void testGetAirlineByAge(){
        System.out.println(recommendService.getAirlineByAge(30,null));
    }

    @Test
    public void testGetAirlineByLevel(){
        System.out.println(recommendService.getAirlineByLevel("本科生"));
    }

    @Test
    public void testGetAllJobs(){
        System.out.println(recommendService.getAllJobs());
    }

    @Test
    public void testGetAirlineByJob(){
        System.out.println(recommendService.getAirlineByJob("人大"));
    }
}
