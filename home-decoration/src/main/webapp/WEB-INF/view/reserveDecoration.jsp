<%--
  Created by IntelliJ IDEA.
  User: Zheng Danfeng
  Date: 2019/5/22
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        .fixedPop {
            position: fixed;
            width: 100%;
            height: 100%;
            top: 0px;
            left: 0px;
            background: rgba(0, 0, 0, 0.5);
            z-index: 99;
            display: none;
        }

    </style>

</head>
<div class="fixedPop" id="fixedPop" style="">
    <div style="position: fixed; width: 100%; height: 100%; left: 0px; top: 0px;"></div>
    <div style="position: relative; margin: 0px auto; background: rgb(255, 255, 255); border-radius: 6px; width: 610px; top: 30%; min-height: 20px; z-index: 1;">
        <img src="/home-decoration/image/fixe_esc1.png" onclick="fixeShut()"
             style="position: absolute; cursor: pointer; top: -17px; right: -20px; z-index: 1;">
        <div style="position: relative; height: 100px; background: rgb(253, 170, 50); border-radius: 6px 6px 0px 0px; text-align: center; color: rgb(255, 255, 255);">
            <p style="font-size: 28px; line-height: 28px; padding: 18px 0px 8px;">预约参观</p>
            <span style="line-height: 14px;">预约参观家装新风尚 品质生活触手可得</span>
            <img src="/home-decoration/image/fixe_head.png" style="position: absolute; top: 0px; left: 77px;">
        </div>
        <div style="width: 383px; margin: 0px auto; padding: 40px 0px;">
<%--            <form id="reservation" action="/home-decoration/user/reserveDecoration" onsubmit="return checkReservation();return false;" method="post">--%>
<%--                <p ><input type="hidden" name="userId" value="${sessionScope.user.id}"></p>--%>
<%--                <p style="overflow: hidden; position: relative; height: 50px; line-height: 50px; margin-bottom: 10px; z-index: 1;">--%>
<%--                    <span>您的称呼</span>--%>
<%--                    <input id="resUserName" name="realname" type="text" placeholder="请输入您的称呼"--%>
<%--                           style="display: block; height: 50px; width: 310px; float: right; border: none; background: rgb(231, 231, 231); border-radius: 4px; padding: 0px 25px;">--%>
<%--                </p>--%>
<%--                <p style="overflow: hidden; position: relative; height: 50px; line-height: 50px; margin-bottom: 10px; z-index: 1;">--%>
<%--                    <span>您的电话</span>--%>
<%--                    <input id="resMobile" name="tel" type="text" placeholder="请输入您的手机号码"--%>
<%--                           style="display: block; height: 50px; width: 310px; float: right; border: none; background: rgb(231, 231, 231); border-radius: 4px; padding: 0px 25px;">--%>
<%--                </p><i class="resError"--%>
<%--                       style="color: red; width: 100%; display: block; font-size: 12px; margin-bottom: 12px; height: 12px; padding-left: 73px; text-align: center; font-style: normal;"></i>--%>
<%--                <p style="overflow: hidden; position: relative; height: 50px; line-height: 50px; margin-bottom: 10px; z-index: 1;">--%>
<%--                    <span></span>--%>
<%--                    <button type="submit" class="aboutJs_button"--%>
<%--                            style="display: block; height: 50px; width: 310px; float: right; border: none; background: rgb(253, 170, 50); border-radius: 4px; padding: 0px 25px; font-size: 18px; color: rgb(255, 255, 255); cursor: pointer;">--%>
<%--                        立即预约</button>--%>
<%--                </p>--%>
<%--            </form>--%>
        </div>
    </div>
</div>
<script>
    var fixedPop = document.getElementById("fixedPop");

    function fixeShut() {
        fixedPop.style.display = "none";
    }

    function reserveDecoration() {
        var role = "${sessionScope.user.role}";
        if (role == "1") {
            fixedPop.style.display = "block";
            return;
        } else if (role == "2" || role == "3") {
            alert("您不是装修用户，不能预订装修！");
            return;
        }
        alert("请先登录！")
        window.location.href = "/home-decoration/homeDecoration/toLogin";
    }

    function checkReservation() {
        var resMobile = document.getElementById('resMobile').value;
        var resUserName = document.getElementById('resUserName').value;

        if (!(/^1[34578]\d{9}$/.test(resMobile))) {
            alert("手机号码有误，请重填");
            document.getElementById("resMobile").style.border = "1px solid red";
            return false;
        }
        if (isEmpty(resUserName)) {
            alert("称呼不能为空！");
            document.getElementById("resUserName").style.border = "1px solid red";
            return false;
        }
        return true;
    }

</script>