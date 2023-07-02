package com.air.web;

import com.air.pojo.Order;
import com.air.pojo.OrderItem;
import com.air.pojo.User;
import com.air.service.BookingManageService;
import com.air.service.impl.BookingManageServiceImpl;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-18 17:41
 */

public class BookingManageServlet extends BaseServlet {

    /**
     * @description: 获取所有订单
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        User user = (User) request.getSession().getAttribute("user");


        List<Order> orders = bookingManageService.getAllOrders(user.getUsername());
        request.setAttribute("orders",orders);

        request.getRequestDispatcher("/pages/tickets/Order.jsp").forward(request,response);
    }

    /**
     * @description: 获取相关状态订单
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void getOrdersByStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        String status = request.getParameter("status");

        List<Order> orders = bookingManageService.getOrdersByStatus(user.getUsername(),status);
        request.setAttribute("orders",orders);

        request.getRequestDispatcher("/pages/tickets/Order.jsp").forward(request,response);
    }

    /**
     * @description: 按照时间区间获取订单
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void getOrdersByTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        Timestamp start = null;
        Timestamp end = null;

        if(startTime != null && !startTime.equals("")){
            start = Timestamp.valueOf(startTime);
        }
        if (endTime != null && !endTime.equals("")){
            end = Timestamp.valueOf(endTime);
        }

        List<Order> orders = bookingManageService.getOrdersByTime(user.getUsername(),start,end);
        request.setAttribute("orders",orders);

        request.getRequestDispatcher("/pages/tickets/Order.jsp").forward(request,response);
    }


    /**
     * @description: 获取订单详情
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void getOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        String orderNum = request.getParameter("orderNum");

        List<OrderItem> orderItems = bookingManageService.getOrderItem(orderNum);
        request.setAttribute("orderItems",orderItems);

        request.getRequestDispatcher("/pages/tickets/orderItem.jsp").forward(request,response);
    }

    /**
     * @description: 确认订单完成已出行
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void finishOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        SqlSession sqlSession = bookingManageService.getSqlSession();
        String orderNum = request.getParameter("orderNum");

        try{
            bookingManageService.updateOrderItemOfStatus(orderNum);
            sqlSession.commit();
            request.getRequestDispatcher("/bookingManageServlet?action=getAllOrders").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

    /**
     * @description: 退票
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-18 17:45
     */
    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManageService bookingManageService = new BookingManageServiceImpl();
        SqlSession sqlSession = bookingManageService.getSqlSession();
        String orderNum = request.getParameter("orderNum");

        try{
            bookingManageService.deleteOrderByOrderNum(orderNum);
            sqlSession.commit();
            request.getRequestDispatcher("/bookingManageServlet?action=getAllOrders").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }
    }

}
