<%--
  Created by IntelliJ IDEA.
  User: Zheng Danfeng
  Date: 2019/5/25
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看装修进度</title>
</head>
<style>
    .workerProgress {
        text-align: center;
        margin-top: 200px;
        background: #fafafa;
    }

    .workerProgress .diaryTab {
        margin-bottom: 0;
        padding: 20px 0 40px;
        height: 150px;
    }

    .workerProgress .diaryTab a {
        font-size: 16px;
        margin: 0 35px;
        background: #c1c1c1;
        width: 90px;
        height: 90px;
        line-height: 80px;
    }

    .workerProgress .diaryTab a h3 {
        font-style: normal;
        font-weight: normal;
    }

    .diaryTab {
        position: relative;
        margin: 0 auto;
        text-align: center;
        height: 130px;
        margin-bottom: 20px;
    }

    .diaryTab a {
        text-align: center;
        border-radius: 50%;
        color: #fff;
        font-size: 22px;
        cursor: pointer;
        display: inline-block;
        background: #c1c1c1;
        width: 74px;
        height: 74px;
        line-height: 64px;
        margin: 28px 13px 0;
        border: 5px solid #fff;
    }

    .diaryTab a.hover,
    .diaryTab a:hover {

        background-color: #90be20 !important;
        border: 5px solid #d1e8ae;
        text-decoration: none
    }

    .diaryTab img {
        position: absolute;
        left: 28.5px;
        top: 115px;
    }

    .diaryText {
        overflow: hidden;
      padding: 40px 80px;
    }
    .diaryText .stage,
    .diaryText h2 {
        margin: 0 auto;
        font-style: normal;
        font-weight: normal;
        text-align: center;
        margin-bottom: 12px;
        overflow: hidden;
        display: block;
        font-size: 20px;
        border: 1px solid #979797;
        width: 312px;
        height: 40px;
        line-height: 38px;
    }
    .diaryText p {
        color: #666;
        line-height: 24px;
        margin-bottom: 18px;
    }
    .diaryText .diaryTextImg {
        overflow: hidden;
        margin: 0 0 28px -12px;
    }
    .diaryText .diaryTextImg img {
        float: left;
        margin-bottom: 12px;
        margin-left: 12px;
        width: 230px;
        height: 230px;
    }
    .diaryText .buildTime {
        position: relative;
        font-style: normal;
        font-weight: normal;
        font-size: 22px;
        height: 32px;
        line-height: 32px;
        background: url(/home-decoration/image/group.png) no-repeat left center;
        padding: 0 45px;
        margin-bottom: 23px;
    }
    .diaryText .buildTime span {
        margin-left: 46px;
    }
    .diaryText .buildTime b {
        position: absolute;
        font-style: normal;
        font-weight: normal;
        font-size: 14px;
        text-align: center;
        color: #fff;
        background-color: #90be20 !important;
        right: -23px;
        width: 98px;
        height: 24px;
        line-height: 24px;
        top: 4px;
        border-radius: 12px 0 0 12px;
    }

</style>

<body>

<%@include file="nav.jsp" %>

<div class="workerProgress">
    <div class="diaryTab">

        <a href="#pointId_487" class="hover" style="overflow: hidden;"><h3>水电改造</h3></a>

        <a href="#pointId_488" class="hover" style="overflow: hidden;"><h3>厨卫墙砖</h3></a>

        <a href="#pointId_489" class="hover" style="overflow: hidden;"><h3>中期施工</h3></a>

        <a href="#pointId_490" class="hover" style="overflow: hidden;"><h3>木作安装</h3></a>

        <a href="#pointId_491" class="hover" style="overflow: hidden;"><h3>竣工验收</h3></a>

    </div>
</div>
<c:forEach items="${decorationProgressList}" var="decorationProgress">
    <div class="diaryText">
        <div class="buildTime"><span>${decorationProgress.constructionTime}</span><b>${decorationProgress.remarks}</b></div>

        <p><strong>施工内容：</strong>${decorationProgress.constructionContent}</p>
        <div class="diaryTextImg">
            <c:forEach items="${picUrlsMap[decorationProgress.id]}" var="picUrl">
                <img src="${picUrl}" alt="逸馨家装${decorationProgress.id+1000}">
            </c:forEach>

        </div>
    </div>
</c:forEach>

<%@include file="footer.jsp" %>
</body>
</html>
