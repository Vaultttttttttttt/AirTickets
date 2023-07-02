package mapperTest;

import com.air.mapper.IdentityManagementMapper;
import com.air.pojo.Customer;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 10:16
* @version 1.0
*/

public class IdentityManagementMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    IdentityManagementMapper identityManagementMapper = sqlSession.getMapper(IdentityManagementMapper.class);

    @Test
    public void testUpdateVipInCustomerByName(){
        identityManagementMapper.updateVipInCustomerByName("汪欣骏","金卡");
        identityManagementMapper.updateVipInCustomerByName("Takura","银卡");
        sqlSession.commit();
    }

    @Test
    public void testQueryCardByName(){
        System.out.println(identityManagementMapper.queryCardByName("汪欣骏"));
        System.out.println(identityManagementMapper.queryCardByName("Takura"));
        System.out.println(identityManagementMapper.queryCardByName("Mard"));
    }

    @Test
    public void testQueryCustomerByName(){
        System.out.println(identityManagementMapper.queryCustomerByName("汪欣骏"));
        System.out.println(identityManagementMapper.queryCustomerByName("Takura"));
        System.out.println(identityManagementMapper.queryCustomerByName("Mard"));
    }

    @Test
    public void testUpdateCustomerInCustomerByName(){
        identityManagementMapper.updateCustomerInCustomerByName(new Customer(
                "汪欣骏","男",24,"硕士","会计"
        ));
        sqlSession.commit();
    }

    @Test
    public void testQueryAccountByCard(){
        System.out.println(identityManagementMapper.queryAccountByCard("金卡"));
        System.out.println(identityManagementMapper.queryAccountByCard("银卡"));
        System.out.println(identityManagementMapper.queryAccountByCard("普通"));
    }
}
