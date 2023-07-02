package com.air.web;

import com.air.pojo.*;
import com.air.service.BookingService;
import com.air.service.impl.BookingServiceImpl;
import com.air.utils.WebUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-17 19:48
 */

public class BookingServlet extends BaseServlet {
    /**
     * @description: 按照条件获取所有航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 9:41
     */
    protected void getTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();

        //获取参数
        String line = request.getParameter("line");

        String date1 = request.getParameter("date");
        Timestamp date = null;
        if (date1 != null && !date1.equals("")) {
            Timestamp date2 = Timestamp.valueOf(date1);
            date = new Timestamp(date2.getYear(), date2.getMonth(), date2.getDate(), 0, 0, 0, 0);
        }

        String startTime1 = request.getParameter("startTime");
        Timestamp startTime = null;
        if (startTime1 != null && !startTime1.equals("")) {
            startTime = Timestamp.valueOf(startTime1);
        }

        String endTime1 = request.getParameter("endTime");
        Timestamp endTime = null;
        if (endTime1 != null && !endTime1.equals("")) {
            endTime = Timestamp.valueOf(endTime1);
        }

        String model = request.getParameter("model");
        Integer minPriceBusiness = WebUtils.parseInt(request.getParameter("minPriceBusiness"), 0);
        Integer maxPriceBusiness = WebUtils.parseInt(request.getParameter("maxPriceBusiness"), 0);
        Integer minPriceEconomy = WebUtils.parseInt(request.getParameter("minPriceEconomy"), 0);
        Integer maxPriceEconomy = WebUtils.parseInt(request.getParameter("maxPriceEconomy"), 0);
        String startPlace = request.getParameter("startPlace");
        String endPlace = request.getParameter("endPlace");


        ChooseItem chooseItem = new ChooseItem(
                line, date, startTime, endTime,
                model, minPriceBusiness, maxPriceBusiness,
                minPriceEconomy, maxPriceEconomy, startPlace, endPlace
        );
        List<AirLine> airlines = bookingService.getTickets(chooseItem);

        String object = request.getParameter("object");

        request.setAttribute("airlines", airlines);

        request.getRequestDispatcher("/pages/tickets/choose_tickets.jsp").forward(request, response);
    }


    /**
     * @description: 买商务舱时获得客户和航班信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-17 20:22
     */
    protected void getAirlineAndPriceOfBusiness(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();

        User user = (User) request.getSession().getAttribute("user");
        Customer customer = bookingService.getCustomerByName(user.getName());
        AirLine airLine = bookingService.getTickets(new ChooseItem(
                request.getParameter("line"), Timestamp.valueOf(request.getParameter("date")),
                null, null, null,
                null, null, null,
                null, null, null
        )).get(0);

        if (bookingService.queryByNameAndLineAndDate(user.getName(), airLine.getLine(), airLine.getDate()) != 0) {
            request.setAttribute("msg", "你不能在同一天订重复的机票");
            request.getRequestDispatcher("/pages/tickets/choose_tickets.jsp").forward(request, response);
        }

        int account = bookingService.getAccountByCard(customer.getCard());

        TicketsTable ticketsTable = new TicketsTable();
        double totalMoney = 1.0 * airLine.getPriceBusiness() * account / 100;

        ticketsTable.setAirline(airLine);
        ticketsTable.setCabin_type("商务舱");
        ticketsTable.setCustomer(customer);
        ticketsTable.setMoney(totalMoney);
        ticketsTable.setTotalMoney(totalMoney);
        ticketsTable.setCustomerAndMoney(new HashMap<>());
        ticketsTable.setNum(ticketsTable.getNum() + 1);

        request.getSession().setAttribute("ticketsTable", ticketsTable);

        request.getRequestDispatcher("/pages/tickets/buy_tickets.jsp").forward(request, response);
    }


    /**
     * @description: 买经济舱时获得客户和航班信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-17 20:22
     */
    protected void getAirlineAndPriceOfEconomy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();

        User user = (User) request.getSession().getAttribute("user");
        Customer customer = bookingService.getCustomerByName(user.getName());
        AirLine airLine = bookingService.getTickets(new ChooseItem(
                request.getParameter("line"), Timestamp.valueOf(request.getParameter("date")),
                null, null, null,
                null, null, null,
                null, null, null
        )).get(0);

        if (bookingService.queryByNameAndLineAndDate(user.getName(), airLine.getLine(), airLine.getDate()) != 0) {
            request.setAttribute("msg", "你不能在同一天订重复的机票");
            request.getRequestDispatcher("/pages/tickets/choose_tickets.jsp").forward(request, response);
        }

        int account = bookingService.getAccountByCard(customer.getCard());

        TicketsTable ticketsTable = new TicketsTable();
        double totalMoney = 1.0 * airLine.getPriceEconomy() * account / 100;

        ticketsTable.setAirline(airLine);
        ticketsTable.setCabin_type("经济舱");
        ticketsTable.setCustomer(customer);
        ticketsTable.setMoney(totalMoney);
        ticketsTable.setTotalMoney(totalMoney);
        ticketsTable.setCustomerAndMoney(new HashMap<>());
        ticketsTable.setNum(ticketsTable.getNum() + 1);

        request.getSession().setAttribute("ticketsTable", ticketsTable);

        request.getRequestDispatcher("/pages/tickets/buy_tickets.jsp").forward(request, response);
    }

    /**
     * @description: 添加新乘客
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-17 21:40
     */
    protected void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();

        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        Customer customer = bookingService.getCustomerByName(name);
        TicketsTable ticketsTable = (TicketsTable) request.getSession().getAttribute("ticketsTable");

        if (customer == null) {
            request.setAttribute("msg", "添加的乘客不存在");
            request.getRequestDispatcher("/pages/tickets/add_new_customer.jsp").forward(request, response);
        } else if(customer.getName().equals(user.getName())){
            request.setAttribute("msg", "不能添加本人");
            request.getRequestDispatcher("/pages/tickets/add_new_customer.jsp").forward(request, response);
        } else if (bookingService.queryByNameAndLineAndDate(customer.getName(), ticketsTable.getAirline().getLine(), ticketsTable.getAirline().getDate()) != 0) {
            request.setAttribute("msg", "该乘客当前已有行程");
            request.getRequestDispatcher("/pages/tickets/add_new_customer.jsp").forward(request, response);
        } else {
            int account = bookingService.getAccountByCard(customer.getCard());
            double money = 0.0;

            if (ticketsTable.getCabin_type().equals("商务舱")) {
                money = 1.0 * ticketsTable.getAirline().getPriceBusiness() * account / 100;
            } else {
                money = 1.0 * ticketsTable.getAirline().getPriceEconomy() * account / 100;
            }

            ticketsTable.setNum(ticketsTable.getNum() + 1);
            ticketsTable.getCustomerAndMoney().put(customer, money);
            ticketsTable.setTotalMoney(money + ticketsTable.getTotalMoney());

            request.setAttribute("ticketsTable", ticketsTable);

            request.getRequestDispatcher("/pages/tickets/buy_tickets.jsp").forward(request, response);
        }

    }

    /**
     * @description: 删除新乘客
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 8:39
     */
    protected void deleteNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();

        TicketsTable ticketsTable = (TicketsTable) request.getSession().getAttribute("ticketsTable");
        String name = request.getParameter("name");
        Customer customer = null;

        Set<Customer> set = ticketsTable.getCustomerAndMoney().keySet();
        for (Customer c : set) {
            if (c.getName().equals(name)) {
                customer = c;
                break;
            }
        }
        double d = ticketsTable.getCustomerAndMoney().get(customer);
        ticketsTable.setTotalMoney(ticketsTable.getTotalMoney() - d);
        ticketsTable.setNum(ticketsTable.getNum() - 1);
        ticketsTable.getCustomerAndMoney().remove(customer);

        request.setAttribute("ticketsTable", ticketsTable);

        request.getRequestDispatcher("/pages/tickets/buy_tickets.jsp").forward(request, response);

    }

    /**
     * @description: 支付
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 9:03
     */
    protected void addOrderAndOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingServiceImpl();
        SqlSession sqlSession = bookingService.getSqlSession();

        try{
            User user = (User) request.getSession().getAttribute("user");
            TicketsTable ticketsTable = (TicketsTable) request.getSession().getAttribute("ticketsTable");


            Order order = new Order(
                    System.currentTimeMillis()+""+user.getUsername(),
                    user.getUsername(),
                    ticketsTable.getTotalMoney(),
                    "未出行"
            );
            bookingService.addOrder(order);

            OrderItem orderItem1 = new OrderItem(
                    order.getOrderNum(),ticketsTable.getCustomer().getName(),
                    ticketsTable.getAirline().getLine(),
                    ticketsTable.getAirline().getDate(),
                    ticketsTable.getCabin_type(),
                    ticketsTable.getMoney()
            );
            bookingService.addOrderItem(orderItem1);

            for(Map.Entry<Customer,Double> entry:ticketsTable.getCustomerAndMoney().entrySet()){
                Customer c = entry.getKey();
                double m = entry.getValue();

                OrderItem orderItem2 = new OrderItem(
                        order.getOrderNum(),c.getName(),
                        ticketsTable.getAirline().getLine(),
                        ticketsTable.getAirline().getDate(),
                        ticketsTable.getCabin_type(),
                        m
                );
                bookingService.addOrderItem(orderItem2);
            }

            sqlSession.commit();
            request.setAttribute("order",order);
            request.getRequestDispatcher("/pages/tickets/success.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }
}