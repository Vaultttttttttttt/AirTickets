package com.air.web;

import com.air.pojo.DetailedAirline;
import com.air.service.SummaryService;
import com.air.service.impl.SummaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-19 18:17
 */

public class SummaryServlet extends BaseServlet {
    /**
     * @description: 按照航空公司给出报表
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 18:19
     */
    protected void getSummaryByCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SummaryService summaryService = new SummaryServiceImpl();
        List<DetailedAirline> detailedAirlines = summaryService.getSummaryByCname();

        request.setAttribute("detailedAirlines",detailedAirlines);
        request.setAttribute("method","company");

        request.getRequestDispatcher("/pages/Summary/Summary.jsp").forward(request,response);
    }

    /**
     * @description: 按照机型给出报表
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 18:19
     */
    protected void getSummaryByModel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SummaryService summaryService = new SummaryServiceImpl();
        List<DetailedAirline> detailedAirlines = summaryService.getSummaryByModel();

        request.setAttribute("detailedAirlines",detailedAirlines);
        request.setAttribute("method","model");

        request.getRequestDispatcher("/pages/Summary/Summary.jsp").forward(request,response);
    }

    /**
     * @description: 按照航线给出报表
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 18:19
     */
    protected void getSummaryByPlace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SummaryService summaryService = new SummaryServiceImpl();
        List<DetailedAirline> detailedAirlines = summaryService.getSummaryByPlace();

        request.setAttribute("detailedAirlines",detailedAirlines);
        request.setAttribute("method","place");

        request.getRequestDispatcher("/pages/Summary/Summary.jsp").forward(request,response);
    }
}
