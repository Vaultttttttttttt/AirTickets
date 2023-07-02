package serviceTest;

import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.service.UserService;
import com.air.service.impl.UserServiceImpl;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 16:09
* @version 1.0
*/

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void testRegister(){
        userService.register(new User("20211446","22222","17757493805","韩杰思"));
    }

    @Test
    public void testSaveIdentity(){
        userService.saveIdentity(new Customer("基尼","男",-2,"博士生","人大"));
    }

    @Test
    public void testLogin(){
        System.out.println(userService.login(new User("20211446","22222","17757493805","韩杰思")));
    }

    @Test
    public void testExistUsername(){
        System.out.println(userService.existUsername("20211446"));
        System.out.println(userService.existUsername("20211445"));
        System.out.println(userService.existUsername("20211447"));
    }

    @Test
    public void testExistName(){
        System.out.println(userService.existName("汪欣骏"));
        System.out.println(userService.existName("韩思杰"));
        System.out.println(userService.existName("韩杰思"));
        System.out.println(userService.existName("雪花"));
    }
}
