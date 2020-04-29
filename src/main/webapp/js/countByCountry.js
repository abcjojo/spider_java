$(function () {

    //创建两个数组  数组长度可变
    var countries = new Array();
    var countCountries = new Array();

    //使用ajax方法得到服务端数据
    $.get("/solr/countByCountry",function (data) {
        for (var i = 0; i < data.length; i++){
            countries[i] = data[i].country;
            countCountries[i] = data[i].countCountry;

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
                text:"豆瓣电影Top250制片国家/地区分布表"
            },
            xAxis:{
                //指定x轴分类
                categories:countries
            },
            yAxis:{
                //设置最小值为0
                min:0,
                title:{
                    text:"数量"
                }
            },
            //数据数列
            series:[{
                name:"国家",
                //指定国家的数组
                data:countCountries
            }]
        };

        //绑定到div对象上
        $("#containerCountByCountry").highcharts(options);
    });



    //创建两个数组  数组长度可变
    var languages = new Array();
    var countLanguages = new Array();

    //使用ajax方法得到服务端数据
    $.get("/solr/countByLanguage",function (data) {
        for (var i = 0; i < data.length; i++){
            languages[i] = data[i].language;
            countLanguages[i] = data[i].countLanguage;

            //alert(data[i].name);
            //console.log(data[i].name)
        }
        // alert(names);
        // alert(scores);

        //创建图表
        var options = {
            //图表类型
            chart:{
                type:"bar" //柱形图
            },
            title:{
                text:"豆瓣电影Top250语言分布表"
            },
            xAxis:{
                //指定x轴分类
                categories:languages
            },
            yAxis:{
                //设置最小值为0
                min:0,
                title:{
                    text:"数量"
                }
            },
            //数据数列
            series:[{
                name:"语言",
                //指定语言的数组
                data:countLanguages
            }]
        };

        //绑定到div对象上
        $("#containerCountByLanguage").highcharts(options);
    });


    //折线图
    //创建两个数组  数组长度可变
    var years = new Array();
    var countYears = new Array();

    //使用ajax方法得到服务端数据
    $.get("/solr/countByYear",function (data) {
        for (var i = 0; i < data.length; i++){
            years[i] = data[i].year;
            countYears[i] = data[i].countYear;
        }

        //创建图表
        var chart = {
            chart: {
                type: 'line'
            },
            title: {
                text: '豆瓣电影Top250历年产量图'
            },
            xAxis: {
                categories: years
            },
            yAxis: {
                title: {
                    text: '产量(部)'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        // 开启数据标签
                        enabled: true
                    },
                    // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                    //enableMouseTracking: false
                }
            },
            series: [{
                name: '年份',
                data: countYears
            }
            //如果是多个数据列时，每个数据列用{}括住，逗号隔开
                // {
            //     name: '伦敦',
            //     data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
            // }
                ]
        };

        //绑定到div对象上
        $("#containerCountByYear").highcharts(chart);
    });


    //可变宽度环形图
    //创建两个数组  数组长度可变
    var years = new Array();
    var countYears = new Array();

    //使用ajax方法得到服务端数据
    $.get("/solr/countByYear",function (data) {
        for (var i = 0; i < data.length; i++){
            years[i] = data[i].year;
            countYears[i] = data[i].countYear;
        }

        //创建图表
        var chart1 = {
            title: {
                text: '豆瓣Top<br>电影类型占比',
                // align: 'center',
                //  verticalAlign: 'middle',
                 //y: 500
            },
            tooltip: {
                headerFormat: '{series.name}<br>',
                pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    dataLabels: {
                        enabled: true,
                        distance: -50,
                        style: {
                            fontWeight: 'bold',
                            color: 'white',
                            textShadow: '0px 1px 2px black'
                        }
                    },
                    startAngle: -90, // 圆环的开始角度
                    endAngle: 90,    // 圆环的结束角度
                    center: ['50%', '75%']
                }
            },
            series: [{
                type: 'pie',
                name: '电影类型占比',
                innerSize: '50%',
                data: [
                    ['剧情', 182],
                    ['犯罪', 163],
                    ['爱情', 23],
                    ['喜剧', 22],
                    ['科幻', 19],
                    ['奇幻', 19],
                    ['动画', 18],
                    ['动作', 14],
                    ['纪录片',5],
                    ['冒险',  5],
                    ['惊悚',  3],
                    ['悬疑',  3],
                    {
                        name: '其他',
                        y: 23,
                        dataLabels: {
                            // 数据比较少，没有空间显示数据标签，所以将其关闭
                            enabled: false
                        }
                    }
                ]
            }]
        };
        //绑定到div对象上
        $("#containerCountByType").highcharts(chart1);
    });


});