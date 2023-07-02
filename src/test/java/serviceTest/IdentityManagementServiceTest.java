package serviceTest;

import com.air.pojo.Customer;
import com.air.service.IdentityManagementService;
import com.air.service.impl.IdentityManagementServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 11:02
* @version 1.0
*/

public class IdentityManagementServiceTest {
    IdentityManagementService identityManagementService = new IdentityManagementServiceImpl();
    SqlSession sqlSession = identityManagementService.getSqlSession();

    @Test
    public void testUpdateVipInCustomer(){
        identityManagementService.updateVipInCustomer("杰尼龟","银卡");
        sqlSession.commit();
    }

    @Test
    public void testGetCardByName(){
        System.out.println(identityManagementService.getCardByName("杰尼龟"));
    }

    @Test
    public void testGetCustomerByName(){
        System.out.println(identityManagementService.getCustomerByName("杰尼龟"));
    }

    @Test
    public void testGetAccountByCard(){
        System.out.println(identityManagementService.getAccountByCard("金卡"));
        System.out.println(identityManagementService.getAccountByCard("银卡"));
        System.out.println(identityManagementService.getAccountByCard("普通"));
    }

    @Test
    public void testUpdateCustomerInCustomer(){
        identityManagementService.updateCustomerInCustomer(new Customer(
                "汪欣骏","男",24,"硕士","会计"
        ));
        sqlSession.commit();
    }
}
