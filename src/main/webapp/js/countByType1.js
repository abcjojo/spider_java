$(function () {

//类型1占比图
    var type1 = new Array();
    var countType1 = new Array();


    //使用ajax方法得到服务端数据
    $.get("/solr/countByType1",function (data) {
        for (var i = 0; i < data.length; i++){
            type1[i] = data[i].type1;
            countType1[i] = data[i].countType1;
        }

        console.log(type1s);
        console.log(countType1);

        //创建图表
        var options = {
            //图表类型
            chart:{
                type:"pie"//饼图
            },
            //主标题
            title:{
                text:"豆瓣TOP250电影类型占比图"
            },
            //数据列
            series:[{
                name:"电影类型占比",
                data:[type1s,countType1s]
            }]
        };

        //绑定到div对象上
        $("#containerCountByType1").highcharts(options);
    });
});