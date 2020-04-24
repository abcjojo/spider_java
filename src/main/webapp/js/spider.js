$(function () {
    //创建两个数组
    var countries = new Array();
    var num = new Array();

    //使用ajax方法得到服务端数据
    $.get("/solr/selectAll",function (data) {
        alert(data)
    })

})