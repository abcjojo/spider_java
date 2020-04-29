$(function () {
    //创建两个数组  数组长度可变
    var names = new Array();
    var scores = new Array();


    //使用ajax方法得到服务端数据
    $.get("/solr/selectAll",function (data) {
        //for (var i = 0; i < data.length; i++){
        for (var i = 0; i < 5; i++){
            names[i] = data[i].name;
            scores[i] = data[i].score;

            //alert(data[i].name);
            //console.log(data[i].name)
        }
        // alert(names);
        // alert(scores);

        //创建图表
        var options = {
            //图表类型
            chart:{
                type:"column" //柱形图
            },
            title:{
                text:"电影评分表"
            },
            xAxis:{
                //指定x轴分类
                categories:names
            },
            yAxis:{
                //设置最小值为0
                min:0,
                title:{
                    text:"评分"
                }
            },
            //数据数列
            series:[{
                name:"评分",
                //指定评分的数组
                data:scores
            }]
        };

        //绑定到div对象上
        $("#container").highcharts(options);
    });


    // //类型1占比图
    // var type1 = new Array();
    // var countType1 = new Array();
    //
    //
    // //使用ajax方法得到服务端数据
    // $.get("/solr/countByType1",function (data) {
    //     for (var i = 0; i < data.length; i++){
    //         type1[i] = data[i].type1;
    //         countType1[i] = data[i].countType1;
    //     }
    //
    //     //创建图表
    //     var countByType1 = {
    //         //图表类型
    //         chart:{
    //             type:"pie"//饼图
    //         },
    //         //主标题
    //         title:{
    //             text:"豆瓣TOP250电影类型占比图"
    //         },
    //         //数据列
    //         series:[{
    //             name:"电影类型占比",
    //             data:[type1,countType1]
    //         }]
    //     };
    //
    //     //绑定到div对象上
    //     $("#containerCountByType1").highcharts(countByType1);
    // });

});