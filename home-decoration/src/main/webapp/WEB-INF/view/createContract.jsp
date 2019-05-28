<%@page pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">

    <script src="/home-decoration/js/jquery.min.js"></script>
    <script src="/home-decoration/js/jquery.validate.min.js"></script>


    <script type="text/javascript">
        $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
            $("#contractForm").validate({
                rules: {
                    userid: {
                        required: true,
                        number: true
                    },
                    username: "required",
                    merchant: "required",
                    contractcontent: "required",
                    houselocation: "required",
                    housedescription: "required",
                    constructiontime: "required"
                },
                messages: {
                    userid: {
                        required: "用户ID不能为空",
                        number: "用户ID必须为数字"
                    },
                    username: {
                        required: "字段不能为空"
                    },
                    merchant: {
                        required: "字段不能为空"
                    },
                    contractcontent: {
                        required: "字段不能为空"
                    },
                    houselocation: {
                        required: "字段不能为空"
                    },
                    housedescription: {
                        required: "字段不能为空"
                    },
                    constructiontime: {
                        required: "字段不能为空"
                    }
                }
            })
            ;
        });
    </script>
    <style> .section-parallax {
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
        background-image: url("/home-decoration/image/background_3.jpg");
    }

    .error {
        color: red;
    }
    </style>
</head>

<body>

<%@include file="nav.jsp" %>

<div class="py-5 text-center section-parallax">
    <div class="container">
        <div class="row">
            <div class="mx-auto col-lg-6 col-10 bg-info">
                <h1>创建合同</h1>
                <form id="contractForm" class="text-left" action="/home-decoration/user/postContract" method="post">
                    <div class="form-group"><label for="form0">用户ID：</label> <input name="userid" type="text"
                                                                                    class="form-control" id="form0">
                    </div>
                    <div class="form-group"><label for="form1">甲方(装修用户)：</label> <input class="form-control" id="form1"
                                                                                        placeholder="请填写真实姓名"
                                                                                        name="username" type="text">
                    </div>
                    <div class="form-group"><label for="form2">乙方：</label> <input class="form-control" id="form2"
                                                                                  placeholder="" value="逸馨家装公司"
                                                                                  name="merchant" type="text"></div>
                    <div class="form-group"><label for="form3">合同内容：</label> <input class="form-control" id="form3"
                                                                                    value="室内装修" placeholder=""
                                                                                    name="contractcontent" type="text">
                    </div>
                    <div class="form-group"><label for="form4">装修房屋位置：</label> <input class="form-control" id="form4"
                                                                                      name="houselocation" type="text">
                    </div>
                    <div class="form-group"><label for="form5">房屋描述：</label> <input class="form-control" id="form5"
                                                                                    name="housedescription" type="text">
                    </div>
                    <div class="form-group"><label for="form6">施工时间：</label> <input class="form-control" id="form6"
                                                                                    name="constructiontime" type="text">
                    </div>
                    <button type="submit" class="btn btn-primary ">提 交</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>