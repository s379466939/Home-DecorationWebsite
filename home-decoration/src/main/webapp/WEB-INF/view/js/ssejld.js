//1.创建一个二维数组用于存储省份和城市
var cities = [];
cities["湖北省"] = new Array("武汉市", "黄冈市", "襄阳市", "荆州市");
cities["湖南省"] = new Array("长沙市", "郴州市", "株洲市", "岳阳市");
cities["河北省"] = new Array("石家庄市", "邯郸市", "廊坊市", "保定市");
cities["河南省"] = new Array("郑州市", "洛阳市", "开封市", "安阳市");
cities["陕西省"] = new Array("西安市", "咸阳市", "安康市", "宝鸡市", "汉中市", "商洛市", "铜川市", "渭南市", "延安市", "榆林市");

function changeCity(val) {
    //7.获取第二个下拉列表
    var cityEle = document.getElementById("city");

    //9.清空第二个下拉列表的option内容
    cityEle.options.length = 0;


    for (var j = 0, len = cities[val].length; j < len; j++) {
        //4.创建城市的文本节点
        var textNode = document.createTextNode(cities[val][j]);
        //5.创建option元素节点
        var opEle = document.createElement("option");
        //6.将城市的文本节点添加到option元素节点
        opEle.appendChild(textNode);
        //8.将option元素节点添加到第二个下拉列表中去
        cityEle.appendChild(opEle);
    }
    // alert("changeCity(val): cities[val].toStrinig(): " + cities[val].toString());
}

function isEmpty(data) {
// || isNaN(data)
    return (data == "" || data == undefined || data == null ) ? true : false;
}

function forceIntegerNumber(obj) {
    var num = parseInt(obj.value)
    if (isNaN(num)) {
        obj.style.border = "2px solid red"
        alert("订购数量应为整数！")
    } else {
        obj.style.border = "1px solid black"
    }
}

function forceFloatNumber(obj) {
    var num = parseFloat(obj.value)
    if (isNaN(num)) {
        obj.style.border = "2px solid red"
        alert("价格应该为数字！")
    }else if(num < 0){
        obj.style.border = "2px solid red"
        alert("价格应该不小于0元！")
    }
    else {
        obj.style.border = "1px solid black"
    }
}

function presentResult(result) {
    var flag = isEmpty(result)
    if (flag == false) {
        alert(result)
    }
}
//UserCenter.jsp
