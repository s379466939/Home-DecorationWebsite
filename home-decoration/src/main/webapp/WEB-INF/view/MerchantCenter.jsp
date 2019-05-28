<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="/home-decoration/css/UserCenter.css" type="text/css">
    <link rel="stylesheet" href="/home-decoration/css/aquamarine.css" type="text/css">
    <script src="/home-decoration/js/jquery.min.js"></script>
    <title>商家中心</title>
</head>

<body>

<%@include file="nav.jsp" %>

<div class="py-5 my-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class=""><i class="fa fa-user fa-fw"></i>商家中心 <font color="#6c757d"><span
                        style="font-size: 25.6px;">目录</span></font>
                </h2>
            </div>
        </div>
        <div class="row">
            <div class="col-3 border p-0 mr-auto border-info">
                <ul class="nav nav-pills flex-column text-center">
                    <li class="nav-item"><a href="/home-decoration/user/toPostGalleryDesign" class="nav-link">发布装修案例</a>
                    </li>
                    <li class="nav-item"><a href="" class="active nav-link" data-toggle="pill" data-target="#tabone">我的预约</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="" data-toggle="pill" data-target="#tabtwo">我的合同</a>
                    </li>
                    <li class="nav-item"><a href="" class="nav-link" data-toggle="pill" data-target="#tabthree">我的收藏</a>
                    </li>
                    <li class="nav-item"><a href="" class="nav-link" data-toggle="pill" data-target="#tabfour">我的问答</a>
                    </li>
                    <li class="nav-item"><a href="" class="nav-link" data-toggle="pill" data-target="#tabfive">个人设置</a>
                    </li>
                </ul>
            </div>
            <div class="mx-0 col-8 border border-info">
                <div class="tab-content m-10">
                    <div class="tab-pane fade show active" id="tabone" role="tabpanel">
                        <p id="presentReservation" class="">您暂时还没有预约！<br></p>
                    </div>
                    <div class="tab-pane fade" id="tabtwo" role="tabpanel">
                        <p id="presentContract" class=""> 您暂时还没有合同！</p>
                        <button type="button" class="btn btn-info"
                                onclick="window.location.href='/home-decoration/user/createContract'">创建合同
                        </button>
                    </div>
                    <div class="tab-pane fade" id="tabthree" role="tabpanel">
                        <p class="">您暂时还没有收藏</p>
                    </div>
                    <div class="tab-pane fade" id="tabfour" role="tabpanel">
                        <p class="">您暂时还没有问答！</p>
                    </div>
                    <div class="tab-pane fade" id="tabfive" role="tabpanel">
                        <div class="pi-wrapper pi-draggable text-center" draggable="true">
                            <ul class="nav nav-pills w-75 mx-auto">
                                <li class="nav-item"><a href="" class="active nav-link" data-toggle="pill"
                                                        data-target="#tabone_">我的头像</a></li>
                                <li class="nav-item"><a class="nav-link" href="" data-toggle="pill"
                                                        data-target="#tabtwo_">个人信息</a></li>
                                <li class="nav-item"><a href="" class="nav-link" data-toggle="pill"
                                                        data-target="#tabthree_">修改密码</a></li>
                            </ul>
                            <div class="tab-content mt-2">
                                <div class="tab-pane fade show active" align="center" id="tabone_" role="tabpanel">
                                    <div class="headImage" alt="头像"></div>
                                    <div style="margin:20px 0">
                                        <form>
                                            <input type="file" class="inputFile" id="HeadImage" name="HeadImage"/>
                                            <input class="saveBtn" type="submit"/>
                                        </form>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="tabtwo_" role="tabpanel">
                                    <form>
                                        真实姓名：<input type="text" class="inputText" name="realName"/><br/>
                                        <div align="left" style="margin-top:20px">
                                            <span style="margin-left: 90px">性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                            <input type="radio" name="gender" value="男"/>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" name="gender" value="女"/>女
                                        </div>
                                        <br/>
                                        出生日期： <input type="date" class="inputText" name="birthday"/><br/>
                                        <input type="submit" class="saveBtn" value="保存"/>

                                    </form>

                                </div>
                                <div class="tab-pane fade" id="tabthree_" role="tabpanel">
                                    <form>
                                        <p><span>当前密码：</span><input type="text" class="inputText" name="password"/></p>
                                        <p><span>新 密 码：</span><input type="text" class="inputText" name="newPassword"/>
                                        </p>
                                        <p><span>新 密 码：</span><input type="text" class="inputText"
                                                                     name="reNewPassword"/></p>
                                        <!-- <i class="error">当前密码输入不正确!</i>-->
                                        <button class="saveBtn">保存</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function updateMerchantCenterData() {
        var presentReservation = document.getElementById("presentReservation");
        var presentContract = document.getElementById("presentContract");
        $.ajax({
            url: '/home-decoration/user/MerchantCenter_data',
            data: {
                userId: "${sessionScope.user.id}"
            },
            type: 'POST',
            dataType: 'json',
            success: function (data) {
                var reservationList = data["reservationList"];
                var contractList = data["contractList"];
                var resListLength = Object.keys(reservationList).length;
                var conListLength = Object.keys(contractList).length;
                console.log("resListLength:" + resListLength);
                console.log("conListLength: " + conListLength);
                var html ;
                if (resListLength !== 0) {
                    html = "<table class=\"table\">\n" +
                        "\t<thead>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<th>订单编号</th>\n" +
                        "\t\t\t<th>用户ID</th>\n" +
                        "\t\t\t<th>姓名</th>\n" +
                        "\t\t\t<th>联系电话</th>\n" +
                        "\t\t\t<th>预约日期</th>\n" +
                        "\t\t\t<th>预约状态</th>\n" +
                        "\t\t</tr>\n" +
                        "\t</thead>\n"
                    $.each(reservationList, function (i, item) {
                        console.log(item);
                        if (i === 0) {
                            html += "<tbody>"
                        }
                        html += "<tr>\n" +
                            "\t\t\t<td>" + eval(i + 1) + "</td>\n" +
                            "\t\t\t<td>" + item.userid + "</td>\n" +
                            "\t\t\t<td>" + item.realname + "</td>\n" +
                            "\t\t\t<td>" + item.tel + "</td>\n" +
                            "\t\t\t<td>" + (new Date(item.reservedate)).getFullYear() + "-"
                            + (new Date(item.reservedate)).getMonth() + "-"
                            + (new Date(item.reservedate)).getDate()
                            + "</td>\n" +
                            "\t\t\t<td>" + handleReservation(item.isdone, item.id) + "</td>\n" +
                            "\t\t</tr>"
                        if (i === resListLength - 1) {
                            html += "</tbody></table>";
                        }
                    });
                    presentReservation.innerHTML = html;
                }
                if (conListLength !== 0) {
                    html = "<table class=\"table\">\n" +
                    "\t<thead>\n" +
                    "\t\t<tr>\n" +
                    "\t\t\t<th>合同编号</th>\n" +
                    "\t\t\t<th>用户ID</th>\n" +
                    "\t\t\t<th>甲方</th>\n" +
                    "\t\t\t<th>乙方</th>\n" +
                    "\t\t\t<th>合同内容</th>\n" +
                    "\t\t\t<th>房子位置</th>\n" +
                    "\t\t\t<th>房子描述</th>\n" +
                    "\t\t\t<th>施工时间</th>\n" +
                    "\t\t\t<th>合同状态</th>\n" +
                    "\t\t\t<th>装修进度</th>\n" +
                    "\t\t</tr>\n" +
                    "\t</thead>\n"
                    $.each(contractList, function (i, item) {
                        //console.log(item);
                        if (i === 0) {
                            html += "<tbody>"
                        }
                        html += "<tr>\n" +
                            "\t\t\t<td>" + eval(i + 1) + "</td>\n" +
                            "\t\t\t<td>" + item.userid + "</td>\n" +
                            "\t\t\t<td>" + item.username + "</td>\n" +
                            "\t\t\t<td>" + item.merchant + "</td>\n" +
                            "\t\t\t<td>" + item.contractcontent + "</td>\n" +
                            "\t\t\t<td>" + item.houselocation + "</td>\n" +
                            "\t\t\t<td>" + item.housedescription + "</td>\n" +
                            "\t\t\t<td>" + item.constructiontime + "</td>\n" +
                            "\t\t\t<td>" + handleContractState(item.contractstate, item.id) + "</td>\n" +
                            "\t\t\t<td><button type=\"button\" class=\"btn btn-success\"" +
                            "onclick=\"window.location.href='/home-decoration/user/toPostDecorationProcess?contract_id='+"+item.id+"\">发布装修进度</button>" +
                            "<button type=\"button\" class=\"btn btn-success\"" +
                            "onclick=\"window.location.href='/home-decoration/user/viewDecorationProgress?contract_id='+"+item.id+"\">查看装修进度</button> </td>\n" +
                            "\t\t</tr>"
                        if (i === resListLength - 1) {
                            html += "</tbody></table>";
                        }
                    });
                    presentContract.innerHTML = html;
                }

            }
        });
    };

    function handleReservation(isdone, id) {
        var changedHtml = "";
        if (isdone) {
            changedHtml += "<span>预约结束/</span>\n" +
                "\t<button type=\"button\" class=\"btn btn-warning\" " +
                "onclick=\"window.location.href='/home-decoration/user/modifyReservationState" + "?id=" + id + "&isdone=" + isdone + "' \">修改</button>"
        } else {
            changedHtml += "<span>正在预约/</span>\n" +
                "\t<button type=\"button\" class=\"btn btn-warning\" " +
                "onclick=\"window.location.href='/home-decoration/user/modifyReservationState" + "?id=" + id + "&isdone=" + isdone + "' \">修改</button>"
        }
        return changedHtml;
    }
    function handleContractState(contractState, id) {
        var changedHtml = "";
        if (contractState) {
            changedHtml += "<span>合同有效/</span>\n" +
                "\t<button type=\"button\" class=\"btn btn-warning\" " +
                "onclick=\"window.location.href='/home-decoration/user/modifyContractState" + "?id=" + id + "&contractState=" + contractState + "' \">修改</button>"
        } else {
            changedHtml += "<span>合同失效/</span>\n" +
                "\t<button type=\"button\" class=\"btn btn-warning\" " +
                "onclick=\"window.location.href='/home-decoration/user/modifyContractState" + "?id=" + id + "&contractState=" + contractState + "' \">修改</button>"
        }
        return changedHtml;
    }

    updateMerchantCenterData();

</script>
<%@include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>

