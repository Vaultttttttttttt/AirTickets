package com.air.web;

import com.air.pojo.AirLine;
import com.air.service.RecommendService;
import com.air.service.impl.RecommendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-06-19 10:22
 */

public class RecommendServlet extends BaseServlet {
    /**
     * @description: 按照性别推荐航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 10:23
     */
    protected void recommendAirlineByGender(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecommendService recommendService = new RecommendServiceImpl();
        String gender = request.getParameter("gender");

        List<AirLine> airLines = recommendService.getAirlineByGender(gender);
        request.setAttribute("kind","性别为"+gender);
        request.setAttribute("airlines",airLines);

        request.getRequestDispatcher("/pages/Summary/Recommend.jsp").forward(request,response);
    }

    /**
     * @description: 按照年龄推荐航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 10:23
     */
    protected void recommendAirlineByAge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecommendService recommendService = new RecommendServiceImpl();
        String age = request.getParameter("age");

        List<AirLine> airLines = new ArrayList<>();

        if(age.equals("少年儿童")){
            airLines = recommendService.getAirlineByAge(0,14);
        }else if(age.equals("青年人")){
            airLines = recommendService.getAirlineByAge(15,35);
        }else if(age.equals("中年人")){
            airLines = recommendService.getAirlineByAge(36,65);
        }else {
            airLines = recommendService.getAirlineByAge(66,null);
        }

        request.setAttribute("kind","年龄段为"+age);
        request.setAttribute("airlines",airLines);
        request.getRequestDispatcher("/pages/Summary/Recommend.jsp").forward(request,response);
    }

    /**
     * @description: 按照学历推荐航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 10:23
     */
    protected void recommendAirlineByLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecommendService recommendService = new RecommendServiceImpl();
        String level = request.getParameter("level");

        List<AirLine> airLines = recommendService.getAirlineByLevel(level);

        request.setAttribute("kind","学历为"+level);
        request.setAttribute("airlines",airLines);
        request.getRequestDispatcher("/pages/Summary/Recommend.jsp").forward(request,response);

    }

    /**
     * @description: 按照工作推荐航班
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 10:23
     */
    protected void recommendAirlineByJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecommendService recommendService = new RecommendServiceImpl();
        String job = request.getParameter("job");

        List<AirLine> airLines = recommendService.getAirlineByJob(job);

        request.setAttribute("kind","工作为"+job);
        request.setAttribute("airlines",airLines);
        request.getRequestDispatcher("/pages/Summary/Recommend.jsp").forward(request,response);

    }

    /**
     * @description: 获取所有工作
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-06-19 10:23
     */
    protected void getAllJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecommendService recommendService = new RecommendServiceImpl();
        Set<String> jobs = recommendService.getAllJobs();

        request.getSession().setAttribute("jobs",jobs);
        request.getRequestDispatcher("/pages/Summary/Recommend.jsp").forward(request,response);

    }
}
