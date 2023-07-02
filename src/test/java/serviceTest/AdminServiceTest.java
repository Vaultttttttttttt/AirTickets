package serviceTest;

import com.air.pojo.User;
import com.air.service.AdminService;
import com.air.service.impl.AdminServiceImpl;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-28 20:52
* @version 1.0
*/

public class AdminServiceTest {
    AdminService adminService = new AdminServiceImpl();

    @Test
    public void testExistUsername(){
        System.out.println(adminService.existUsername("admin"));
        System.out.println(adminService.existUsername("user"));
    }

    @Test
    public void testLogin(){

        System.out.println(adminService.login("admin","admin"));
        System.out.println(adminService.login("admin","user"));
        System.out.println(adminService.login("user","admin"));
        System.out.println(adminService.login("user","ad"));
    }
}
