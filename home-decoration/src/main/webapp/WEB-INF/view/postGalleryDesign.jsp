<%@page pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    <link rel="stylesheet" href="/home-decoration/css/aquamarine.css">

    <script src="/home-decoration/js/jquery.min.js"></script>
    <script src="/home-decoration/js/jquery.validate.min.js"></script>
    <script>
        $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
            $("#galleryForm").validate({
                rules: {
                    community: {
                        required: true,
                        minlength: 1
                    },
                    picUrl: "required",
                    housetype: {
                        required: true
                    },
                    area: {
                        required: true,
                        number: true
                    },
                    cost: {
                        required: true,
                        number: true
                    },
                    style: {
                        required: true
                    }
                },
                messages: {
                    community: {
                        required: "请输入小区名称",
                        minlength: "小区名称至少一个字符组成"
                    },
                    picUrl:"上传图片不能为空",
                    area:{
                        required: "室内面积不能为空",
                        number:"请输入有效室内面积数值"
                    },
                    cost:{
                        required: "整体造价不能为空",
                        number:"请输入有效整体造价数值"
                    }
                }
            });
        });

    </script>
    <style>
        .error{
              color:red;
          }

    </style>
</head>

<body>

<%@include file="nav.jsp" %>
<div class="py-5 text-center section-parallax">
    <div class="container">
        <div class="row">
            <div class="mx-auto col-lg-6 col-10 bg-info">
                <h1>发布装修案例</h1>
                <form id="galleryForm" class="text-left" action="/home-decoration/user/postGalleryDesign" method="post" enctype="multipart/form-data">
                    <div class="form-group"><label for="community">小 区：</label>
                        <input type="text" class="form-control" id="community" name="community" placeholder="紫薇田园都市">
                    </div>
                    <div class="form-group"><label for="picUrl">室内取景：</label>
                        <input type="file" class="form-control" id="picUrl" name="picUrl"></div>
                    <div class="form-group"><label for="housetype">户 型：</label>
                        <select class="form-control" id="housetype" name="housetype">
                            <option value="一居室">一居室</option>
                            <option value="二居室" selected="selected">二居室</option>
                            <option value="三居室">三居室</option>
                            <option value="四居室">四居室</option>
                            <option value="其他">其他</option>
                        </select></div>
                    <div class="form-group"><label for="area">面 积（平方米）：</label>
                        <input type="text" class="form-control" id="area" name="area" placeholder=""></div>
                    <div class="form-group"><label for="cost">整体造价(万元)：</label>
                        <input type="text" class="form-control" id="cost" name="cost" placeholder=""></div>
                    <div class="form-group"><label for="style">风 格：（按住 shift 键，可以选取多个风格）</label>
                        <select id="style" name="style" class="form-control" multiple="">
                            <option selected="selected" value="简约">简约</option>
                            <option value="欧式">欧式</option>
                            <option value="美式">美式</option>
                            <option value="中式">中式</option>
                            <option value="地中海">地中海</option>
                            <option value="田园">田园</option>
                            <option value="北欧">北欧</option>
                            <option value="简欧">简欧</option>
                            <option value="工业">工业</option>
                            <option value="日式">日式</option>
                            <option value="复古">复古</option>
                            <option value="意大利">意大利</option>
                            <option value="现代">现代</option>
                        </select></div>
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