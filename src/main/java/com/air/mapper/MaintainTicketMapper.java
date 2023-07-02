package com.air.mapper;

import com.air.pojo.AirLine;
import com.air.pojo.Company;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 9:33
* @version 1.0
*/

public interface MaintainTicketMapper {
    //插入一条机票
    public void insertTicket(@Param("airLine") AirLine airLine);
    public void insertTicketOther(@Param("airLine") AirLine airLine);

    //查询航班号的多少
    public int queryCountByLine(@Param("line") String line);

    //按照日期和航班号查询
    public int queryByLineAndDate(@Param("line") String line, @Param("date") Timestamp date);

    //按照日期和航班号查询
    public AirLine queryAndGetByLineAndDate(@Param("line") String line, @Param("date") Timestamp date);


    //按照航班号和日期修改机票
    public void updateByLineAndDate(@Param("airLine") AirLine airLine);
    public void updateByLineAndDateOther(@Param("airLine") AirLine airLine);

    //按照航班号和日期删除机票
    public void deleteByLineAndDate(@Param("line") String line,@Param("date") Timestamp date);
    public void deleteByLineAndDateOther(@Param("line") String line,@Param("date") Timestamp date);

    //修改每日票价浮动因素
    public void updateByPriceUpDay(@Param("n") int n);

    //修改售票情况票价浮动因素
    public void updateByPriceUpNum(@Param("n") int n);

    //按照会员等级和折扣修改享受待遇
    public void updateByCard(@Param("card") String card,@Param("account") int account);

    //查询全部的公司
    public List<Company> queryCompany();

    //添加公司
    public void addCompany(Company company);

    //按照公司名查找公司数量
    public int queryCountByCname(@Param("cname") String cname);

    //按照公司名查找航班编号
    public int queryCountBySign(@Param("sign") String sign);
}
