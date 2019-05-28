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
    <style> .section-parallax {
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
        background-image: url("/home-decoration/image/background_2.jpg");
    }

    .error {
        color: red;
    }
    </style>
    <script>
        $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
            $("#decoForm").validate({
                rules: {
                    constructionTime: {
                        required: true,
                    },
                    constructionContent: "required",
                    conPicUrls: {
                        required: true
                    },
                    remarks: {
                        required: true,
                    }
                },
                messages: {
                    constructionTime: {
                        required: "施工时间不能为空",
                    },
                    constructionContent: "施工内容不能为空",
                    conPicUrls: {
                        required: "施工拍照不能为空",
                    },
                    remarks: {
                        required: "施工描述不能为空",
                    }
                }
            });
        });

    </script>
</head>

<body>
<%@include file="nav.jsp" %>
<div class="py-5 text-center section-parallax">
    <div class="container">
        <div class="row">
            <div class="mx-auto col-lg-6 col-10 bg-info">
                <h1>发布装修进度信息</h1>
                <form id="decoForm" class="text-left" action="/home-decoration/user/postDecorationProcess" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="contract_id" value="${contract_id}" alt="contract_id"  />
                    <div class="form-group"><label for="form0">施工日期：</label>
                        <input name="constructionTime" type="text"
                               class="form-control" id="form0"
                               placeholder="yyyy-MM-dd 上午/下午">
                    </div>
                    <div class="form-group"><label for="form1">施工内容：</label>
                        <input class="form-control" id="form1"
                               placeholder="例如，刷墙"
                               name="constructionContent"
                               type="text"></div>
                    <div class="form-group"><label for="form2">施工拍照：</label>
                        <input class="form-control" id="form2"
                               placeholder="" value="逸馨家装公司"
                               name="conPicUrls"
                               type="file" multiple="multiple">
                    </div>
                    <div class="form-group"><label for="form3">施工描述：</label>
                        <input class="form-control" id="form3"
                               value="正常施工" placeholder=""
                               name="remarks" type="text"></div>
                    <button type="submit" class="btn btn-primary ">提 交</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>