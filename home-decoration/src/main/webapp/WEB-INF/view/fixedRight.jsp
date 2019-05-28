<%@page pageEncoding="UTF-8" %>
<head>

    <style type="text/css">
        .fixedRight {
            width: 60px;
            z-index: 98;
            background-color: white;
            position: fixed;
            right: 0px;
            top: 200px;
            font-size: 13px;
            text-align: center;
            padding: 0;
        }

        .fixedRight div {
            border: 1px solid rgb(208, 208, 208);
            cursor: pointer;
            padding-bottom: 2px;
        }

        .fixedRight div img {
            opacity: 1;
            background-color: white;
        }

        .fixedRight div:hover {
            background-color: rgb(255, 163, 31);
            box-shadow: -2px 2px rgb(192, 193, 193);
        }


        #returntop {
            display: none;

        }



    </style>
</head>
<div class="fixedRight">
    <div style="padding:0"><img src="/home-decoration/image/online.gif"></div>
    <div onclick="reserveDecoration();return false;"><img src="/home-decoration/image/fixe_about_1.png">预约装修</div>
    <div><img src="/home-decoration/image/fixe_price_1.png"><span>装修报价</span></div>
    <!--<a><div><p><img src="/assets/2017pc/img/head/gongzhonghao.jpg" alt="公众号"><span>关注公众号</span><em>领￥4999装修红包</em></p><img src="/assets/2017pc/img/fixe_new/fixe_ma_2.png"></div></a>
    -->
    <div onclick="topFunction();return false;" id="returntop"><img src="/home-decoration/image/fixe_top.jpg"></div>
</div>

<script>
    // 当网页向下滑动 20px 出现"返回顶部" 按钮
    window.onscroll = function () {
        scrollFunction()
    };

    function scrollFunction() {
        console.log(121);
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("returntop").style.display = "block";
        } else {
            document.getElementById("returntop").style.display = "none";
        }
    }

    // 点击按钮，返回顶部
    function topFunction() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }

</script>