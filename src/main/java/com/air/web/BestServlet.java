package com.air.web;

import com.air.pojo.DetailedAirline;
import com.air.service.BestService;
import com.air.service.RecommendService;
import com.air.service.impl.BestServiceImpl;
import com.air.service.impl.RecommendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-19 15:31
 */

public class BestServlet extends BaseServlet {
    /**
     * @description: 获取所有公司名称
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 15:34
     */
    protected void getAllCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BestService bestService = new BestServiceImpl();
        List<String> cnames = bestService.getAllCompany();

        request.getSession().setAttribute("cnames",cnames);
        request.getRequestDispatcher("/pages/Summary/Best.jsp").forward(request,response);
    }


    /**
     * @description: 获取每个公司航班的信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 15:34
     */
    protected void getBestInEveryCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BestService bestService = new BestServiceImpl();
        String cname = request.getParameter("cname");
        List<DetailedAirline> detailedAirlines = bestService.getBest(cname);

        request.setAttribute("detailedAirlines",detailedAirlines);
        request.getRequestDispatcher("/pages/Summary/Best.jsp").forward(request,response);
    }



    /**
     * @description: 获取最受欢迎的公司
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 15:34
     */
    protected void getBestCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BestService bestService = new BestServiceImpl();
        List<DetailedAirline> bests = bestService.Best();
        request.setAttribute("bests",bests);

        request.getRequestDispatcher("/pages/Summary/Best.jsp").forward(request,response);
    }
}
