<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>逸馨家装用户登录</title>
    <link href="/home-decoration/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="/home-decoration/js/jquery.min.js"></script>
    <script type="text/javascript" src="/home-decoration/js/ssejld.js"></script>
    <style>
        label {
            float: left;
        }

        input {
            float: left;
        }

        form {
            algin: center;
        }
    </style>
    <script>
        <%--$(function(){--%>
            <%--var result = "${result}"--%>
            <%--if(isEmpty(result) == false) {--%>
                <%--alert(result);--%>
            <%--}--%>
        <%--})--%>

        function checkForm() {
            /**校验用户名*/
                //获取用户输入的数据
            var uValue = document.getElementById("username1").value;
            var pValue = document.getElementById("password").value;
            if (uValue == "") {
                alert("用户名不能为空!");
                return false;

            }
            else if (pValue == "") {
                alert("密码不能为空!");
                return false;
            }
            else {
                return true;
                document.getElementById("form").submit();
            }
        }
    </script>

</head>

<body>
<!--header start here-->
<div class="login-form">
    <div class="top-login">
        <span><img src="/home-decoration/img/group.png" alt="零食淘用户登录"/></span>
    </div>
    <h1>登录</h1>
    <div class="login-top">
            <form action="/home-decoration/user/login" style="align:center" method="post" id="form" onsubmit="return checkForm()">
                <div class="login-ic">
                    <label style="padding-top: 8px; color: black "><b>用户名:&nbsp;</b></label>
                    <input style="width: 350px" type="text" id="username1" name="account" onFocus="changebgColor(this)"
                           placeholder="请输入用户名"/>
                </div>
                <div class="login-ic">
                    <label style="padding-top: 8px; color: black"><b>密&nbsp;&nbsp;&nbsp;码:&nbsp; </b></label>
                    <input style="width: 350px" type="password" id="password" name="password"
                           onFocus="changebgColor(this)" placeholder="请输入密码"/>
                </div>
                <div style="margin-bottom: 20px">
                    <b style="color: white;">记住用户名</b>&nbsp;&nbsp;<input type="checkbox" name="checkbox"
                                                                         value="checkbox"/>
                    <a href="/home-decoration/homeDecoration/toRegister" style="color: black; padding-left: 160px; ">新账号注册</a>
                    |&nbsp;&nbsp;<a href="/home-decoration/homeDecoration/home" style="color: black;">返回首页</a>
                </div>
                <div class="log-bwn">
                    <input type="submit" style="margin-left: 160px;height: 40px" value="Login">
                </div>
                <p style="color:red">${result}</p>
            </form>
    </div>
    <p class="copy">© 2019 逸馨家装</p>
</div>
<script type="text/javascript">
    // $(function(){
    $(document).ready(function () {
        var result = "${result}"
        if(isEmpty(result) == false) {
            alert(result);
        }
    })
</script>
</body>
</html>
