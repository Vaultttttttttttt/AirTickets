<%--
  Created by IntelliJ IDEA.
  User: wxj27
  Date: 2023-05-28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册界面</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {

            $("#code_img").click(function () {
                this.src="${basePath}kaptcha.jpg";
            })


            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^[A-Za-z0-9]+$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^[A-Za-z0-9]+$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 电话验证：xxxxx@xxx.com
                //1 获取电话里的内容
                var telText = $("#tel").val();
                //2 创建正则表达式对象
                var telPatt = /^[0-9]{11}$/;
                //3 使用test方法验证是否合法
                if (!telPatt.test(telText)) {
                    //4 提示用户
                    $("span.errorMsg").text("电话格式不合法！");

                    return false;
                }
                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>

    <style type="text/css">
        .login_form{
            height:500px;
            margin-top: 25px;
        }

        #l_content span {
            font-size: 100px;
            color: #131111;
        }

        .login_banner {
            height: 600px;
            background-color: rgba(57, 58, 152, 0);
        }
        body{
            background-size: cover;
        }
        #sub_btn {
            background-color: #2476c5;
            border: none;
            color: #fff;
            width: 360px;
            height: 40px;
        }
    </style>
</head>
<body background="static/img/登录界面.jpg">
<div class="login_banner">

    <div id="l_content">
        <span class="login_word">注册会员</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>欢迎注册</h1>
                    <span class="errorMsg">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名(只支持数字+字母)"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${requestScope.username}"
                        />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码(只支持数字+字母)"
                               autocomplete="off" tabindex="1" name="password" id="password" />
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                        <br />
                        <br />
                        <label>电话号码：</label>
                        <input class="itxt" type="text" placeholder="请输入电话号码"
                               autocomplete="off" tabindex="1" name="tel" id="tel"
                               value="${requestScope.tel}"
                        />
                        <br />
                        <br />
                        <label>姓名：</label>
                        <input class="itxt" type="text" placeholder="请输入姓名"
                               autocomplete="off" tabindex="1" name="name" id="name"
                               value="${requestScope.name}"
                        />
                        <br />
                        <br />
                        <label>性别：</label>
                        <input type="radio" name="gender" checked="checked" value="男"/>男
                        <input type="radio" name="gender" value="女"/>女
                        <br />
                        <br />
                        <label>年龄：</label>
                        <input class="itxt" type="text" placeholder="请输入年龄"
                               autocomplete="off" tabindex="1" name="age" id="age"
                               value="${requestScope.age}"
                        />
                        <br />
                        <br />
                        <label>学历：</label>
                        <select name="level" id="level">
                            <option>--请输入学历--</option>
                            <option>幼儿园</option>
                            <option >小学</option>
                            <option>初中</option>
                            <option>高中</option>
                            <option selected="selected">本科生</option>
                            <option>研究生</option>
                            <option>博士生</option>
                        </select>
                        <br />
                        <br />
                        <label>职业：</label>
                        <input class="itxt" type="text" placeholder="请输入职业"
                               autocomplete="off" tabindex="1" name="job" id="job"
                               value="${requestScope.job}"
                        />
                        <br />
                        <br />
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
                        <img id="code_img"  alt="" src="http://localhost:8080/air/kaptcha.jpg" style="width: 100px; height: 30px">
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
