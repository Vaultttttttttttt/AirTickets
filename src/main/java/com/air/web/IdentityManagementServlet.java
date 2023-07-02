package com.air.web;

import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.service.IdentityManagementService;
import com.air.service.impl.IdentityManagementServiceImpl;
import com.air.utils.WebUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-14 11:17
* @version 1.0
*/

public class IdentityManagementServlet extends BaseServlet {
    //获得当前用户的vip等级和所有vip优惠制度
    protected void getVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdentityManagementService identityManagementService = new IdentityManagementServiceImpl();
        User user = (User) request.getSession().getAttribute("user");

        String card = identityManagementService.getCardByName(user.getName());
        int goldenAccount = identityManagementService.getAccountByCard("金卡");
        int silverAccount = identityManagementService.getAccountByCard("银卡");
        int normalAccount = identityManagementService.getAccountByCard("普通");
        int userAccount = identityManagementService.getAccountByCard(card);

        request.setAttribute("card", card);
        request.setAttribute("userAccount", userAccount);
        request.setAttribute("goldenAccount", goldenAccount);
        request.setAttribute("silverAccount", silverAccount);
        request.setAttribute("normalAccount", normalAccount);

        request.getRequestDispatcher("/pages/identity/user_manager_vip.jsp").forward(request, response);
    }

    //升级用户的vip等级
    protected void updateVip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdentityManagementService identityManagementService = new IdentityManagementServiceImpl();
        SqlSession sqlSession = identityManagementService.getSqlSession();

        String card = request.getParameter("card");
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();

        try {
            identityManagementService.updateVipInCustomer(name, card);

            sqlSession.commit();
            request.getRequestDispatcher("/identityManagementServlet?action=getVip").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }

    }

    //获取个人信息
    protected void getCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdentityManagementService identityManagementService = new IdentityManagementServiceImpl();

        User user = (User) request.getSession().getAttribute("user");

        Customer customer = identityManagementService.getCustomerByName(user.getName());

        request.setAttribute("customer", customer);

        request.getRequestDispatcher("/pages/identity/user_manager_customer.jsp").forward(request, response);
    }

    //修改个人信息
    protected void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IdentityManagementService identityManagementService = new IdentityManagementServiceImpl();
        SqlSession sqlSession = identityManagementService.getSqlSession();

        Customer customer = new Customer();

        try {
            WebUtils.copyParamToBean(request,customer);
            identityManagementService.updateCustomerInCustomer(customer);
            sqlSession.commit();
            request.getRequestDispatcher("/identityManagementServlet?action=getCustomer").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            response.sendRedirect("/air/pages/errors/error.jsp");
        }


    }
}
