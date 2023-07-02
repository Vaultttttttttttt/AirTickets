package com.air.web;

import com.air.pojo.AirLine;
import com.air.pojo.ChooseItem;
import com.air.pojo.PriceUpdate;
import com.air.service.AdminService;
import com.air.service.GetTicketsService;
import com.air.service.impl.AdminServiceImpl;
import com.air.service.impl.GetTicketsServiceImpl;
import com.air.utils.WebUtils;

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
 * @date 2023-06-12 9:01
 */

public class GetTicketsServlet extends BaseServlet {
    /**
     * @description: 按照条件获取所有航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 9:41
     */
    protected void getTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetTicketsService getTicketsService = new GetTicketsServiceImpl();

        //获取参数
        String line = request.getParameter("line");

        String date1 = request.getParameter("date");
        Timestamp date = null;
        if(date1 != null && !date1.equals("") ){
            Timestamp date2 = Timestamp.valueOf(date1);
            date = new Timestamp(date2.getYear(),date2.getMonth(),date2.getDate(),0,0,0,0);
        }

        String startTime1 = request.getParameter("startTime");
        Timestamp startTime = null;
        if(startTime1 != null && !startTime1.equals("")){
            startTime = Timestamp.valueOf(startTime1);
        }

        String endTime1 = request.getParameter("endTime");
        Timestamp endTime = null;
        if(endTime1 != null && !endTime1.equals("")){
            endTime = Timestamp.valueOf(endTime1);
        }

        String model = request.getParameter("model");
        Integer minPriceBusiness = WebUtils.parseInt(request.getParameter("minPriceBusiness"),0);
        Integer maxPriceBusiness = WebUtils.parseInt(request.getParameter("maxPriceBusiness"),0);
        Integer minPriceEconomy = WebUtils.parseInt(request.getParameter("minPriceEconomy"),0);
        Integer maxPriceEconomy = WebUtils.parseInt(request.getParameter("maxPriceEconomy"),0);
        String startPlace = request.getParameter("startPlace");
        String endPlace = request.getParameter("endPlace");


        ChooseItem chooseItem = new ChooseItem(
                line,date,startTime,endTime,
                model,minPriceBusiness,maxPriceBusiness,
                minPriceEconomy,maxPriceEconomy,startPlace,endPlace
        );
        List<AirLine> airlines = getTicketsService.getTickets(chooseItem);


        request.setAttribute("airlines", airlines);

        request.getRequestDispatcher("/pages/manager/manager_airline.jsp").forward(request, response);
    }

    /**
     * @description: 更新某一航班信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-12 17:55
     */
    protected void getTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetTicketsService getTicketsService = new GetTicketsServiceImpl();

        String line = request.getParameter("line");
        Timestamp date = Timestamp.valueOf(request.getParameter("date"));

        AirLine airline = getTicketsService.getTickets(new ChooseItem(
                line,date,null,null,
                null,null,null,
                null,null,null,null
        )).get(0);
        request.setAttribute("airline", airline);
        request.getRequestDispatcher("/pages/manager/manager_edit_airline.jsp").forward(request, response);
    }

    protected void getPriceUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetTicketsService getTicketsService = new GetTicketsServiceImpl();

        PriceUpdate priceUpdate = getTicketsService.getPriceUpdate();

        request.setAttribute("priceUpdate",priceUpdate);

        request.getRequestDispatcher("/pages/manager/manager_priceUpdate.jsp").forward(request,response);
    }

    protected void getCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        GetTicketsService getTicketsService = new GetTicketsServiceImpl();

        request.setAttribute("golden",getTicketsService.getCard("金卡"));
        request.setAttribute("silver",getTicketsService.getCard("银卡"));
        request.setAttribute("normal",getTicketsService.getCard("普通"));

        request.getRequestDispatcher("/pages/manager/manager_vip.jsp").forward(request,response);
    }
}
