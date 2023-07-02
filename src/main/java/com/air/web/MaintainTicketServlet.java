package com.air.web;

import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.pojo.Company;
import com.air.service.GetTicketsService;
import com.air.service.MaintainTicketService;
import com.air.service.impl.GetTicketsServiceImpl;
import com.air.service.impl.MaintainTicketServiceImpl;
import com.air.utils.WebUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-12 9:39
 */

public class MaintainTicketServlet extends BaseServlet {
    /**
     * @description: 按照航班号和日期删除航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 9:41
     */
    protected void deleteTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();
        String line = request.getParameter("line");
        Timestamp date = Timestamp.valueOf(request.getParameter("date"));
        try {
            maintainTicketService.deleteTicket(line, date);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getTickets");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 添加新的航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 9:53
     */
    protected void addTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        AirLine airLine = new AirLine();
        try {
            WebUtils.copyParamToBean(request, airLine);

            //设置日期格式为yyyy-MM-dd 00:00:00格式
            Date date1 = airLine.getDate();
            airLine.setDate(new Timestamp(date1.getYear(), date1.getMonth(), date1.getDate(), 0, 0, 0, 0));

            if(!WebUtils.checkLine(airLine.getLine())){
                request.setAttribute("msg", "航班号不合法");
                request.getRequestDispatcher("pages/manager/manager_edit_airline.jsp?method=addTicket").forward(request, response);
            } else if (maintainTicketService.existLine(airLine.getLine().substring(0, 2)) == 0) {
                //检查是否存在该类航班
                request.setAttribute("msg", "航班号的前两个字母有误");
                request.getRequestDispatcher("pages/manager/manager_edit_airline.jsp?method=addTicket").forward(request, response);
            } else if (maintainTicketService.existDateAndLine(airLine.getLine(), airLine.getDate()) != 0) {
                //检查日期航班号是否重复
                request.setAttribute("msg", "该日期已经存在该航班");
                request.getRequestDispatcher("pages/manager/manager_edit_airline.jsp?method=addTicket").forward(request, response);
            } else if ((airLine.getStartTime().getYear() != airLine.getDate().getYear() || airLine.getDate().getMonth() != airLine.getStartTime().getMonth() || airLine.getStartTime().getDate() != airLine.getDate().getDate()) || airLine.getStartTime().getTime() > airLine.getEndTime().getTime()) {
                //检查时间是否有问题
                request.setAttribute("msg", "日期，出发时间和到达时间有问题");
                request.getRequestDispatcher("pages/manager/manager_edit_airline.jsp?method=addTicket").forward(request, response);
            } else {

                airLine.setNumBusiness(airLine.getTotalBusiness());
                airLine.setNumEconomy(airLine.getTotalEconomy());

                maintainTicketService.addTicket(airLine);
                sqlSession.commit();
                response.sendRedirect("getTicketsServlet?action=getTickets");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新航班信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 17:46
     */
    protected void updateTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        AirLine airLine = new AirLine();

        try {
            WebUtils.copyParamToBean(request, airLine);
            AirLine before = maintainTicketService.getLine(airLine.getLine(), airLine.getDate());
            airLine.setNumEconomy(airLine.getTotalEconomy() - (before.getTotalEconomy() - before.getNumEconomy()));
            airLine.setNumBusiness(airLine.getTotalBusiness() - (before.getTotalBusiness() - before.getNumBusiness()));

            if ((airLine.getStartTime().getYear() != airLine.getDate().getYear() || airLine.getDate().getMonth() != airLine.getStartTime().getMonth() || airLine.getStartTime().getDate() != airLine.getDate().getDate()) || airLine.getStartTime().getTime() > airLine.getEndTime().getTime()) {
                //检查时间是否有问题
                request.setAttribute("msg", "日期，出发时间和到达时间有问题");
                request.getRequestDispatcher("getTicketsServlet?action=getTicket&method=updateTicket&line=" + before.getLine() + "&date=" + before.getDate()).forward(request, response);
            } else if (airLine.getNumBusiness() < 0) {
                //检查设置的商务座总位数
                request.setAttribute("msg", "商务座总位数设置不佳");
                request.getRequestDispatcher("getTicketsServlet?action=getTicket&method=updateTicket&line=" + before.getLine() + "&date=" + before.getDate()).forward(request, response);
            } else if (airLine.getNumEconomy() < 0) {
                //检查设置的经济舱总位数
                request.setAttribute("msg", "经济舱总位数设置不佳");
                request.getRequestDispatcher("getTicketsServlet?action=getTicket&method=updateTicket&line=" + before.getLine() + "&date=" + before.getDate()).forward(request, response);
            } else {
                maintainTicketService.updateTicket(airLine);

                sqlSession.commit();
                response.sendRedirect("getTicketsServlet?action=getTickets");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("http://localhost:8080/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新每日票价因素
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-13 10:41
     */
    protected void updatePriceUpDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        try {
            int priceUpDay = WebUtils.parseInt(request.getParameter("priceUpDay"), 0);
            maintainTicketService.updatePriceUpDay(priceUpDay);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getPriceUpdate");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新销售量票价因素
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-13 10:41
     */
    protected void updatePriceUpNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        try {
            int priceUpNum = WebUtils.parseInt(request.getParameter("priceUpNum"), 0);
            maintainTicketService.updatePriceUpNum(priceUpNum);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getPriceUpdate");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新金卡的折扣
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-13 11:17
     */
    protected void updateGoldenVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        try {
            int account = WebUtils.parseInt(request.getParameter("golden"), 0);
            maintainTicketService.updateVip("金卡", account);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getCard");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新银卡的折扣
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-13 11:17
     */
    protected void updateSilverVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        try {
            int account = WebUtils.parseInt(request.getParameter("silver"), 0);
            maintainTicketService.updateVip("银卡", account);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getCard");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 更新普通的折扣
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-13 11:17
     */
    protected void updateNormalVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        try {
            int account = WebUtils.parseInt(request.getParameter("normal"), 0);
            maintainTicketService.updateVip("普通", account);
            sqlSession.commit();
            response.sendRedirect("getTicketsServlet?action=getCard");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }


    /**
     * @description: 获取所有公司的信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 19:18
     */
    protected void getAllCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();

        List<Company> companies = maintainTicketService.getAllCompany();

        request.setAttribute("companies",companies);
        request.getRequestDispatcher("/pages/manager/manager_company.jsp").forward(request,response);
    }

    /**
     * @description: 添加航空公司
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 19:18
     */
    protected void addCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintainTicketService maintainTicketService = new MaintainTicketServiceImpl();
        SqlSession sqlSession = maintainTicketService.getSqlSession();

        Company company = new Company();
        WebUtils.copyParamToBean(request,company);

        if(maintainTicketService.existCname(company.getCname()) != 0){
            request.setAttribute("msg","公司名已经存在");
            request.getRequestDispatcher("/pages/manager/manager_add_company.jsp").forward(request,response);
        }else if(maintainTicketService.existSign(company.getSign()) != 0){
            request.setAttribute("msg","航班编号已经存在");
            request.getRequestDispatcher("/pages/manager/manager_add_company.jsp").forward(request,response);
        }else if(company.getSign().length() != 2){
            request.setAttribute("msg","航班编号长度必须是两位");
            request.getRequestDispatcher("/pages/manager/manager_add_company.jsp").forward(request,response);

        }else {
            try{
                maintainTicketService.addCompany(company);
                sqlSession.commit();
                request.getRequestDispatcher("/maintainTicketServlet?action=getAllCompany").forward(request,response);
            }catch (Exception e){
                e.printStackTrace();
                sqlSession.rollback();
                response.sendRedirect("/air/pages/errors/error.jsp");
            }
        }
    }
}
