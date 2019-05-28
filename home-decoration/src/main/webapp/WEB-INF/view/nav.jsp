<%--
  Created by IntelliJ IDEA.
  User: Zheng Danfeng
  Date: 2019/5/3
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        .dropbtn {
            background-color: rgb(204, 204, 204);
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: rgb(92, 90, 95);
        }
    </style>
    <script src="/home-decoration/js/ssejld.js"></script>
    <script>

        window.onload = function () {
            function haveLogin() {
                var nickname = "${sessionScope.user.nickname}";
                var role = "${sessionScope.user.role}"
                var demo = document.getElementById("dropdownbt");
                var demo1 = document.getElementById("login");
                var demo2 = document.getElementById("register");
                if (nickname != "") {
                    demo.innerHTML = "欢迎你," + nickname + "!";
                    demo1.innerHTML = "个人中心";
                    if (role == 1) {
                        demo1.href = "/home-decoration/user/toUserCenter?userId=${sessionScope.user.id}"
                    } else if (role == 2) {
                        demo1.href = "/home-decoration/user/toMerchantCenter?userId=${sessionScope.user.id}"
                    } else if(role == 3){
                        alert("还未分配系统管理员！");
                        demo1.href = "/home-decoration/user/toMerchantCenter"
                    }else{
                        alert("用户角色异常！");
                    }
                    demo2.innerHTML = "注销";
                    demo2.href = "/home-decoration/user/logout";
                }
            }



            haveLogin()

        }

        presentResult("${result}");
    </script>
</head>

<nav class="navbar navbar-expand-md fixed-top navbar-light bg-info shadow" style="">
    <div class="container">
        <a class="navbar-brand text-primary" href="/home-decoration/homeDecoration/home">
            <i class="fa d-inline fa-lg fa-circle-o"></i>
            <span class="title1">逸馨家装</span>
        </a>
<%--        <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse"--%>
<%--                data-target="#navbar5">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
        <div class="collapse navbar-collapse" id="navbar5">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" href="/home-decoration/homeDecoration/home">首页</a></li>
                <li class="nav-item"><a class="nav-link" href="/home-decoration/homeDecoration/decorationTips">装修攻略</a></li>
                <li class="nav-item"><a class="nav-link" href="/home-decoration/homeDecoration/gallery">经典案例</a></li>
                <li class="nav-item"><a class="nav-link" href="#">装修工地</a></li>
                <li class="nav-item"><a class="nav-link" href="#">装修学院</a></li>
                <li class="nav-item"><a class="nav-link" href="#">尊享服务</a></li>
            </ul>

            <div class="dropdown">
                <button id="dropdownbt" class="dropbtn">登录/注册</button>
                <div class="dropdown-content">
                    <a id="login" href="/home-decoration/homeDecoration/toLogin">登录</a>
                    <a id="register" href="/home-decoration/homeDecoration/toRegister">注册</a>
                </div>
            </div>
        </div>
    </div>
</nav>