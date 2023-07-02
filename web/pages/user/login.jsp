<%--
  Created by IntelliJ IDEA.
  User: wxj27
  Date: 2023-05-28
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        #l_content span {
            font-size: 100px;
            color: #120202;
        }
        .login_banner {
            height: 600px;
            background-color: #39489800;
        }
        #sub_btn {
            background-color: #1480f7;
            border: none;
            color: #fff;
            width: 360px;
            height: 40px;
        }
        body{
            background-size: cover;
        }
    </style>
</head>
<body background="static/img/登录界面.jpg">
<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <a href="pages/admin/login.jsp">管理员登录</a>
                    <a href="pages/user/register.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
