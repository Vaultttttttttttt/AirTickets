package mapperTest;

import com.air.mapper.MaintainTicketMapper;
import com.air.pojo.AirLine;
import com.air.pojo.Company;
import com.air.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 10:18
* @version 1.0
*/

public class MaintainAirLineTest {
    @Test
    public void testInsertTicket(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.insertTicket(new AirLine(
                "MU22222222",Timestamp.valueOf("2023-7-15 09:00:00"),
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),
                "007",100,100,100,100,"上海","俄罗斯",
                100,100
        ));
    }

    @Test
    public void testQueryCountByLine(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        System.out.println(maintainTicketMapper.queryCountByLine("Mu"));
        System.out.println(maintainTicketMapper.queryCountByLine("CC"));
    }

    @Test
    public void testQueryByLineAndDate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        System.out.println(maintainTicketMapper.queryByLineAndDate("MU22222222",Timestamp.valueOf("2023-7-15 08:00:00")));
        System.out.println(maintainTicketMapper.queryByLineAndDate("MU2222222",Timestamp.valueOf("2023-7-15 08:00:00")));
        System.out.println(maintainTicketMapper.queryByLineAndDate("MU22222222",Timestamp.valueOf("2023-7-15 07:00:00")));
        System.out.println(maintainTicketMapper.queryByLineAndDate("MU22222221",Timestamp.valueOf("2023-7-15 06:00:00")));
    }

    @Test
    public void testUpdateByLineAndDate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.updateByLineAndDate(new AirLine(
                "MU22222222",Timestamp.valueOf("2023-7-15 08:00:00"),
                Timestamp.valueOf("2023-7-15 09:00:00"),new Timestamp(System.currentTimeMillis()),
                "007",100,100,100,100,"上海","俄罗斯",
                100,100
        ));

        maintainTicketMapper.updateByLineAndDate(new AirLine(
                "MU22222222",Timestamp.valueOf("2023-7-15 09:00:00"),
                Timestamp.valueOf("2023-7-15 09:00:00"),new Timestamp(System.currentTimeMillis()),
                "007",150,150,100,100,"上海","俄罗斯",
                100,100
        ));
    }

    @Test
    public void testDeleteByLineAndDate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.deleteByLineAndDate("MU22222222",Timestamp.valueOf("2023-7-15 9:00:00"));
    }

    @Test
    public void testUpdateByPriceUpdateDay(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.updateByPriceUpDay(12);
    }


    @Test
    public void testUpdateByPriceUpNum(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.updateByPriceUpNum(13);
    }

    @Test
    public void testUpdateByCard(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.updateByCard("金卡",85);
    }

    @Test
    public void testQueryAndGetByLineAndDate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        System.out.println(maintainTicketMapper.queryAndGetByLineAndDate("MU22222222",Timestamp.valueOf("2023-7-15 08:00:00")));
        System.out.println(maintainTicketMapper.queryAndGetByLineAndDate("MU2222222",Timestamp.valueOf("2023-7-15 08:00:00")));
        System.out.println(maintainTicketMapper.queryAndGetByLineAndDate("MU22222222",Timestamp.valueOf("2023-7-15 07:00:00")));
        System.out.println(maintainTicketMapper.queryAndGetByLineAndDate("MU22222221",Timestamp.valueOf("2023-7-15 06:00:00")));
    }

    @Test
    public void testQueryCompany(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        List<Company> companies = maintainTicketMapper.queryCompany();
        System.out.println(companies);
    }

    @Test
    public void testAddCompany(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        MaintainTicketMapper maintainTicketMapper = sqlSession.getMapper(MaintainTicketMapper.class);

        maintainTicketMapper.addCompany(new Company(
                "吉祥","HO"
        ));

        sqlSession.commit();
    }
}
