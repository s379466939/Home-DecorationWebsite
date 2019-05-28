<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="/home-decoration/css/regist.css"/>
    <script type="text/javascript" src="/home-decoration/js/jquery.min.js"></script>
    <script type="text/javascript" src="/home-decoration/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/home-decoration/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/home-decoration/js/messages_zh.js"></script>

    <style>

        label.error {
            background: url(img/unchecked.jpg) no-repeat 10px 3px;
            padding-left: 30px;
            font-family: georgia;
            font-size: 15px;
            font-style: normal;
            color: red;
        }

        label.success {
            background: url(img/checked.gif) no-repeat 10px 3px;
            padding-left: 30px;
        }
    </style>

    <script>
        $(function () {
            $("#registForm").validate({
                rules: {
                    account: {
                        required: true,
                        minlength: 6
                    },
                    password: {
                        required: true,
                        minlength: 6
                    },
                    repassword: {
                        required: true,
                        equalTo: "[name='password']"
                    },
                    role: {
                        required: true
                    },
                    ncname: {
                        required: true
                    }
                },
                messages: {
                    username: {
                        required: "用户名不能为空!",
                        minlength: "用户名不得少于6位!"
                    },
                    password: {
                        required: "密码不能为空!",
                        minlength: "密码不得少于6位!"
                    },
                    repassword: {
                        required: "确认密码不能为空!",
                        equalTo: "两次输入密码不一致!"
                    },
                    role: {
                        required: "请选择用户类别！"
                    },
                    ncname: {
                        required: "昵称必须填写！"
                    }

                },
                errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
                success: function (label) { //验证成功后的执行的回调函数
                    //label指向上面那个错误提示信息标签label
                    label.text(" ") //清空错误提示消息
                        .addClass("success"); //加上自定义的success类
                }
            });
        });
    </script>


</head>
<body class="login_bj">

<div class="zhuce_body">
    <!--<div class="logo"><a href="#"><img src="img" width="114" height="54" border="0"></a></div>-->
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <h3>欢迎注册</h3>
                <form action="/home-decoration/user/register" method="post" id="registForm">
                    <input name="account" type="text" class="kuang_txt phone" placeholder="账号">
                    <input name="password" type="password" class="kuang_txt possword" placeholder="密码">
                    <input name="repassword" type="password" class="kuang_txt possword" placeholder="重复密码">
                    <input name="nickname" type="text" class="kuang_txt phone" placeholder="昵称">
                    <input name="" type="text" class="kuang_txt yanzm" placeholder="验证码">
                    <img src="/home-decoration/img/zc_22.jpg" width="92" height="20"><br/><br/>

                    <input type="radio" name="role" value="1"/>我是装修客户
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="role" value="2"/>我是商家
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="role" value="3"/>我是系统管理员

                    <%--<label for="role" class="error" style="display: none;"></label>--%>
                    <br/>

                    <div>
                        <input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span
                            class="lan">《XXXXX使用协议》</span></a></span>
                    </div>
                    <input type="submit" class="btn_zhuce" value="注册">
                    <p style="color:red">${result}</p>

                </form>
            </div>
            <div class="bj_right">
                <p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="/home-decoration/homeDecoration/toLogin">立即登录</a></p>
                <p><a href="/home-decoration/homeDecoration/home">返回首页</a></p>

            </div>
        </div>
        <P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您来到逸馨家装注册页面</P>
    </div>

</div>


</body>


</body>
</html>
