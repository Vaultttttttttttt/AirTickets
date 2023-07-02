package com.air.web;

import com.air.service.AdminService;
import com.air.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-05-28 20:56
 */

public class AdminServlet extends BaseServlet {
    /**
     * @description: 登录管理员用户
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-05-28 20:58
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取账号密码参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminService adminService =new AdminServiceImpl();

        if(adminService.existUsername(username)==0){
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("/pages/admin/login.jsp").forward(request, response);
        }else{
            if(adminService.login(username,password) == 0){
                request.setAttribute("msg", "密码错误");
                request.getRequestDispatcher("/pages/admin/login.jsp").forward(request, response);
            } else{
                request.getRequestDispatcher("/pages/manager/manager.jsp").forward(request, response);
            }
        }
    }
}
