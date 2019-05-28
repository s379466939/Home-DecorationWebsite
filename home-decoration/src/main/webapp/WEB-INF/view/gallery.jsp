<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    <link rel="stylesheet" href="/home-decoration/css/aquamarine.css" type="text/css">
    <script src="/home-decoration/js/ssejld.js"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <style>


        .search-table {
            width: 372px;
            line-height: 30px;
        }

        .inline {
            display: inline;
        }


        .search-table label {
            padding: 0;
            font-weight: bold;
        }

        .search-table ul {
            width: 400px;
            line-height: 30px;
        }

        .search-table ul li {
            display: inline;
            text-align: center;
            height: 30px;
            line-height: 30px;
            cursor: pointer;
            margin-right: 18px;
            margin-bottom: 2px;
            padding: 5px 7px;
            color: #333;
            font-weight: normal;
        }

        .search-table ul li:hover {
            color: #ffa31f;
        }

        .search-table ul li.active {
            background-color: #ffa31f !important;
            color: #fff;
            border-radius: 4px;;
        }

        .search-table ul li.align {
            margin-left: 85px;
        }


        .search-table ul li.choice {

            background-color: #ffa31f !important;
            color: #fff;
            border-radius: 4px;
        }

        /*设置选择页样式*/
        .Paging {
            height: 60px;
            padding-top: 10px;
        }

        .Paging p {
            float: left;
            color: #999;
            line-height: 40px;
            padding: 0 10px 0 4px;
        }

        .Paging ul {
            float: right;
            width: auto !important;
        }

        .Paging li {
            list-style: none;
            float: left;
            width: 40px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            margin-right: 10px;
            background: #f3f3f3;
        }

        .Paging li a {
            text-decoration: none;
            display: block;
            color: #555;
        }

        .Paging li:hover,
        .Paging li.hover {
            background: #d7d7d7;
        }

        .Paging li.paging_prev,
        .Paging li.paging_next {
            width: 60px;
        }
    </style>
    <script>
        $(function () {
            var keyArr = ['houseType', 'area', 'cost', 'style'];
            var keyObj = {
                'houseType': '',
                'area': '',
                'cost': '',
                'style': ''
            };
            // $(".Paging ul li").click(function(){
            //     alert("ul li 被点击")
            //         window.event.returnValue = false;
            // })
            $("body .Paging  ").on("click", "li", function () {
                var pageNum = $(this).val();
                var isChoosed = $(this).hasClass("hover");
                console.log("pageNum: " + pageNum + "  isChoosed: " + isChoosed);
                //更改页码选择
                if (!isChoosed) {
                    $(this).addClass("hover");
                    $(this).siblings().removeClass("hover");
                }

                alert("pause1");
                $.ajax({
                    type: "POST",
                    url: "/home-decoration/homeDecoration/filteGalleryDesignByPageNum",
                    dataType: "json", //从后台接收的数据类型
                    // contentType: 'text', //传入后台的数据类型
                    data: {
                        jsonObject: JSON.stringify(keyObj, undefined, 4),
                        pageNum: pageNum
                    },
                    success: function (data) {
                        var galleryDesignList = data["galleryDesignList"];
                        var pageObject = data["pageObject"];
                        console.log("galleryDesignList的长度: " + Object.keys(galleryDesignList).length);
                        var html = updateHtmlByGalleryDesigList(galleryDesignList);
                        var pageHtml = updateHtmlByPageObject(pageObject);
                        console.log("pageHtml: " + pageHtml);
                        console.log("html: " + html);
                        //更新html
                        $("#myul").html(html);
                        $("#mypage").html(pageHtml);
                        alert("pause3")
                        // window.event.returnValue = false;

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.readyState + ">>>>>>\n" + XMLHttpRequest.status + ">>>>>>\n" + XMLHttpRequest.responseText);
                    }
                })
                // 禁止页面跳转
                alert("pause2");
                window.event.returnValue = false;
            });

            $(".search-table-tbody li").click(function () {
                var isChoose = $(this).hasClass("choice");
                var chooseLen = null;
                var $parent = $(this).parent();
                var $index = $(this).parents('.search-table').index();

                console.log($(this).index())
                if ($(this).index() !== 0) {
                    $(this).siblings().removeClass("active");
                    if (!isChoose) {
                        $(this).addClass("choice");
                        $(this).siblings().removeClass("choice");
                    } else {
                        $(this).removeClass("choice");
                    }
                    chooseLen = $parent.children('.choice').length;
                    if (chooseLen == 0) {
                        $parent.children('td').eq(0).addClass('active');
                    }
                    findQuery($parent, $index)
                } else {
                    $(this).addClass("active")
                    $(this).siblings().removeClass("choice");
                    findQuery($parent, $index);
                }
                //ajax
                console.log(JSON.stringify(keyObj, undefined, 4));
                //$("#searchResult").text(JSON.stringify(keyObj, undefined, 4));

                $.ajax({
                    type: "POST",
                    url: "/home-decoration/homeDecoration/filteGalleryDesign",
                    dataType: "json", //从后台接收的数据类型
                    contentType: 'application/json', //传入后台的数据类型
                    data: JSON.stringify(keyObj, undefined, 4),
                    success: function (data) {
                        var galleryDesignList = data["galleryDesignList"];
                        var pageObject = data["pageObject"];
                        console.log("galleryDesignList的长度: " + Object.keys(galleryDesignList));
                        var html = updateHtmlByGalleryDesigList(galleryDesignList);
                        var pageHtml = updateHtmlByPageObject(pageObject);
                        console.log("pageHtml: " + pageHtml);
                        //更新html
                        $("#myul").html(html);
                        $("#mypage").html(pageHtml);
                        // window.event.returnValue = false;
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.readyState + ">>>>>>\n" + XMLHttpRequest.status + ">>>>>>\n" + XMLHttpRequest.responseText);
                    }
                });
                //禁止页面自动刷新
                window.event.returnValue = false;
            });


            function findQuery($ele, _index) {
                searchCon = {};
                var oKey = keyArr[_index];
                var hasActive = null;
                hasActive = $ele.children('.active').length > 0;
                if (hasActive) {
                    keyObj[oKey] = '';
                } else {
                    var arr = [];
                    $ele.children('.choice').each(function (index, item) {
                        arr.push($(item).text());
                    });
                    keyObj[oKey] = arr;
                    keyObj[oKey] = arr.join(',');
                }
            }

            function updateHtmlByGalleryDesigList(galleryDesignList) {
                var html = "";
                if (Object.keys(galleryDesignList).length === 0) {
                    html += "\t<h3 style=\"font-family:Arial\">非常抱歉，没有您查询的结果！</h3>";
                }
                $.each(galleryDesignList, function (i, galleryDesign) {
                    html += "<li>\n" +
                        "                    <i><a ><img\n" +
                        "                            src=\"" + galleryDesign.picurl + "\"\n" +
                        "                            alt=\"" + galleryDesign.community + "\"></a></i>\n" +
                        "                    <div>\n" +
                        "                        <div>\n" +
                        "                            <a >\n" +
                        "                                <h4>" + galleryDesign.community + "</h4>\n" +
                        "                                <span> " + galleryDesign.housetype + " 【" + galleryDesign.area + "m²】" + galleryDesign.cost + "</span>\n" +
                        "                            </a>\n" +
                        "                        </div>\n" +
                        "                        <em onclick=\"return false\" style=\"\">免费<br>报价</em>\n" +
                        "                    </div>\n" +
                        "                </li>\n"
                });
                return html;
            }

            function updateHtmlByPageObject(pageObject) {
                //编写选择页html代码
                var pageHtml = "";
                pageHtml += " <p>\n" +
                    "            第" + (pageObject.totalPage === 0 ? 0 : pageObject.currPage) + "页，共" + pageObject.totalPage + "页，每页" + pageObject.pageSize + "条</p>\n" +
                    "        <ul>\n";
                if (pageObject.currPage !== 1) {
                    pageHtml += "<li class=\"paging_prev\" value=\"" + (pageObject.currPage - 1) + "\"><a >上一页</a></li>\n"
                }
                var j;
                for (j = 0; j < pageObject.totalPage; j++) {
                    pageHtml += " <li class=" + ((j === (pageObject.currPage - 1)) ? '"hover"' : '""') + " value=\"" + (j + 1) + "\"><a  >" + (j + 1) + "</a></li>"
                }
                if (pageObject.currPage !== pageObject.totalPage && pageObject.totalPage !== 0) {
                    pageHtml += "<li value=\"" + (pageObject.currPage + 1) + "\" class=\"paging_next\"><a >下一页</a></li>  "
                }
                pageHtml += "</ul>";
                return pageHtml;
            }

        })


    </script>
</head>

<body>

<%@include file="nav.jsp" %>
<!--关闭筛选-->
<div class="mx-0 px-0">
    <div class="row">
        <div class="caseBanner">
            <div class="p-0 col-lg-12 mb-5">
                <div class="carousel slide" data-interval="5000" data-ride="carousel" id="carousel2">
                    <div class="carousel-inner">
                        <div class="carousel-item active"><img class="d-block w-100"
                                                               src="/home-decoration/image/gallery_nav_1.jpg"
                                                               width="1200px" height="400px" style="">
                        </div>
                        <div class="carousel-item"><img class="d-block w-100"
                                                        src="/home-decoration/image/gallery_nav_3.jpg"
                                                        width="1200px" height="400px
280px"></div>
                    </div>
                    <a class="carousel-control-prev" href="#carousel2" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span></a>
                    <a class="carousel-control-next" href="#carousel2" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span></a>
                </div>
            </div>
            <div class="caseChoice">
                <div class="search-table inline">
                    <label class="inline"><b>户型</b></label>
                    <ul class="inline search-table-tbody">
                        <li class="active">不限</li>
                        <li>一居室</li>
                        <li>二居室</li>
                        <li>三居室</li>
                        <li>四居室</li>
                        <li class="align">其他</li>
                    </ul>
                </div>
                <div class="search-table inline">
                    <br/>
                    <label class="inline"><b>面积</b></label>
                    <ul class="inline search-table-tbody">
                        <li class="active">不限</li>
                        <li>60m²以下</li>
                        <li>60~80m²</li>
                        <li>80~100m²</li>
                        <li class="align">100~120m²</li>
                        <li>120~180m²</li>
                        <li>180m²以上</li>
                    </ul>
                </div>
                <div class="search-table inline">
                    <br/>
                    <label class="inline"><b>预算</b></label>
                    <ul class="inline search-table-tbody">
                        <li class="active">不限</li>
                        <li>5万以下</li>
                        <li>5~8万</li>
                        <li>8万以上</li>
                    </ul>
                </div>
                <div class="search-table inline">
                    <br/>
                    <label class="inline"><b>风格</b></label>
                    <ul class="inline search-table-tbody">
                        <li class="active">不限</li>
                        <li>简约</li>
                        <li>欧式</li>
                        <li>美式</li>
                        <li>中式</li>
                        <li>地中海</li>
                        <li class="align">田园</li>
                        <li style="">北欧</li>
                        <li>简欧</li>
                        <li>工业</li>
                        <li>日式</li>
                        <li>复古</li>
                        <li class="align">意大利</li>
                        <li>现代</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- tag-->
<div class="crumbs mt-5">
    <a href="/">逸馨家装</a>
    <span>&gt;</span>
    <span>经典案例</span>
</div>

<div class="caseText">
    <ul id="myul" class="caseList p-0" style="">
        <c:forEach items="${galleryDesignList}" var="galleryDesign">
            <li>
                <i><a href="/case/937.html"><img
                        src="${galleryDesign.picurl}"
                        alt="${galleryDesign.community}"></a></i>
                <div>
                    <div>`
                        <a href="/case/937.html">
                            <h4>${galleryDesign.community}</h4>
                            <span> ${galleryDesign.housetype} 【${galleryDesign.area}m²】${galleryDesign.cost}</span>
                        </a>
                    </div>
                    <em onclick="javascript:RES.offer();" style="">免费<br>报价</em>
                </div>
            </li>

        </c:forEach>


    </ul>
    <div id="mypage" class="Paging">
        <p>
            第${pageObject.totalPage == 0 ? 0 : pageObject.currPage}页，共${pageObject.totalPage}页，每页${pageObject.pageSize}条</p>
        <ul>
            <c:if test="${pageObject.currPage != 1}">
                <li class="paging_prev" value="${pageObject.currPage-1}"><a>上一页</a></li>
            </c:if>
            <c:if test="${pageObject.totalPage != 0}">
                <c:forEach var="i" begin="1" end="${pageObject.totalPage}">
                    <li class="${i == pageObject.currPage ? 'hover': ''}" value="${i}"><a>${i}</a></li>
                </c:forEach>

            </c:if>

            <c:if test="${pageObject.currPage != pageObject.totalPage && pageObject.totalPage != 0}">
                <li class="paging_next" value="${pageObject.currPage + 1}"><a>下一页</a></li>
            </c:if>
        </ul>
    </div>
</div>
<div class="pt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3 class="">精品案例&nbsp;<span class="badge badge-light">New</span></h3>
            </div>
            <div class="col-md-6">
                <h6 class="text-right"><i class="fa fa-user fa-fw"></i>换一批</h6>
            </div>
        </div>
    </div>
</div>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-bubble-dark.svg">
                <h2 class="my-3"><b>One&nbsp;</b></h2>
                <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring
                    which I enjoy with my whole heart.</p>
            </div>
            <div class="col-md-4 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-moon.svg">
                <h2 class="my-3"><b>Two</b></h2>
                <p>I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls
                    like mine. I am so happy, my dear friend.</p>
            </div>
            <div class="col-md-4 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-bubble-light.svg">
                <h2 class="my-3"><b>Three</b></h2>
                <p>So absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be
                    incapable of drawing a single stroke.</p>
            </div>
        </div>
    </div>
</div>
<div class="pt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h3 class="">精选推荐&nbsp;<span class="badge badge-light">New</span></h3>
            </div>
            <div class="col-md-6">
                <h6 class="text-right"><i class="fa fa-user fa-fw"></i>换一批</h6>
            </div>
        </div>
    </div>
</div>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-bubble-dark.svg">
                <h2 class="my-3"><b>One&nbsp;</b></h2>
                <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring
                    which I enjoy with my whole heart.</p>
            </div>
            <div class="col-md-3 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-moon.svg">
                <h2 class="my-3"><b>Two</b></h2>
                <p>I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls
                    like mine. I am so happy, my dear friend.</p>
            </div>
            <div class="col-md-3 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-bubble-light.svg">
                <h2 class="my-3"><b>Three</b></h2>
                <p>So absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be
                    incapable of drawing a single stroke.</p>
            </div>
            <div class="col-md-3 col-6 p-3"><img class="img-fluid d-block"
                                                 src="https://static.pingendo.com/cover-bubble-light.svg">
                <h2 class="my-3"><b>Three</b></h2>
                <p>So absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be
                    incapable of drawing a single stroke.</p>
            </div>
        </div>
    </div>
</div>

<%@include file="fixedRight.jsp" %>
<%@include file="reserveDecoration.jsp" %>
<%@include file="footer.jsp" %>


<script>


</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>