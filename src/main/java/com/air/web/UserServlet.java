package com.air.web;

import com.air.pojo.Customer;
import com.air.pojo.User;
import com.air.service.UserService;
import com.air.service.impl.UserServiceImpl;
import com.air.utils.SqlSessionUtil;
import com.air.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxj27
 * @version 1.0
 * @description: TODO
 * @date 2023-05-28 17:32
 */


public class UserServlet extends BaseServlet {
    /**
     * @description: 用户注册并添加个人信息
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-05-28 19:51
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String tel = request.getParameter("tel");
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String job = request.getParameter("job");

        String true_code = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        if (code != null && code.equalsIgnoreCase(true_code)) {
            UserService userService = new UserServiceImpl();
            if (userService.existUsername(username) == 1) {
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("tel", tel);
                request.setAttribute("name", name);
                request.setAttribute("age", age);
                request.setAttribute("job", job);
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
            } else if (userService.existName(name) == 1) {
                request.setAttribute("msg", "此姓名已存在");
                request.setAttribute("username", username);
                request.setAttribute("tel", tel);
                request.setAttribute("name", name);
                request.setAttribute("age", age);
                request.setAttribute("job", job);
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
            } else {
                try {
                    User user = new User();
                    Customer customer = new Customer();

                    WebUtils.copyParamToBean(request, user);
                    WebUtils.copyParamToBean(request, customer);

                    userService.saveIdentity(customer);
//                    int i = 8 / 0;
                    userService.register(user);

                    request.getSession().setAttribute("user", user);

                    userService.getSqlSession().commit();

                    request.getRequestDispatcher("/pages/tickets/tickets.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    userService.getSqlSession().rollback();
                    response.sendRedirect("/air/pages/errors/error.jsp");
                }
            }
        } else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("tel", tel);
            request.setAttribute("name", name);
            request.setAttribute("age", age);
            request.setAttribute("job", job);
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
        }
    }

    /**
     * @description: 用户登录
     * @param: request
     * @param: response
     * @return: void
     * @author wxj27
     * @date: 2023-05-28 19:53
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取账号和密码的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User prev = new User(username, password, null, null);
        UserService userService = new UserServiceImpl();

        if (userService.existUsername(username) == 1) {
            User user = userService.login(prev);

            if (user != null) {
                request.getSession().setAttribute("user", user);

                request.getRequestDispatcher("/pages/tickets/tickets.jsp").forward(request, response);

            } else {
                request.setAttribute("msg", "密码错误");
                request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }
}
