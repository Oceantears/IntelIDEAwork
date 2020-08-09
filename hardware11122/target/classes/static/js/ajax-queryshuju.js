function company() {
    var KEYID = $("#shebei").val();
    //alert(company_id);yibuShipin
    //标题
    $.ajax({
        type: "post",
        url: "/yibnbiaoti" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            $("#sp1").html(data.company_name + '(' + data.place_title + ')')
        }
    });

    $.ajax({
        type: "post",
        url: "/yibuShipin" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (Hls.isSupported()) {
                if (data.GETLIVEINFO == null) {
                    var video = document.getElementById('video');
                    var hls = new Hls();
                    hls.loadSource(data.liveAddress);
                    hls.attachMedia(video);
                    hls.on(Hls.Events.MANIFEST_PARSED, function () {
                        video.play();
                    });
                } else {
                    var video = document.getElementById('video');
                    var hls = new Hls();
                    hls.loadSource(data.GETLIVEINFO);
                    hls.attachMedia(video);
                    hls.on(Hls.Events.MANIFEST_PARSED, function () {
                        video.play();
                    });
                }
            }
        },
        error: function () {
            //请求失败时执行该函数
            if (Hls.isSupported()) {
                var video = document.getElementById('video');
                var hls = new Hls();
                hls.loadSource(null);
                hls.attachMedia(video);
                hls.on(Hls.Events.MANIFEST_PARSED, function () {
                    video.play();
                });
            }
        }
    });

    //图片
    $.ajax({
        type: "post",
        url: "/yibutupian" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            var div22 = $("#div2");
            div22.empty();
            //json格式的城市对象数组
            var imgs = eval(data);
            //var cname = imgs[0];
            /* $("#imageId1").attr("src",imgs[0]);
             $("#imageId2").attr("src",imgs[1]);
             $("#imageId3").attr("src",imgs[2]);
             $("#imageId4").attr("src",imgs[3]);
             $("#imageId5").attr("src",imgs[4]);
             $("#imageId6").attr("src",imgs[5]);
             $("#imageId7").attr("src",imgs[6]);
             $("#imageId8").attr("src",imgs[7]);
             $("#imageId9").attr("src",imgs[8]);
             $("#imageId10").attr("src",imgs[9]);
             $("#imageId11").attr("src",imgs[10]);
             $("#imageId12").attr("src",imgs[11]);*/
            $.each(imgs, function (index, item) {
                var cname = imgs[index];
                div22.append("<img src='" + cname + "'/>");
            });
        }
    });

    //统计图
    $.ajax({
        type: "post",
        url: "/yibutongji" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            //var citys = eval(data.selectwendu);
            //alert(citys);
            var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
            var lineoption = {
                title: {
                    text: '今日环境数据走势'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['温度', '湿度', '风速', 'PM2.5', '降雨']
                },
                grid: {
                    x: 40,
                    x2: 40,
                    y2: 24
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: ['0:00', '2:00', '4:00', '6:00', '8:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00', '24:00']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        name: '温度',
                        type: 'line',
                        data: data.selectwendu,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name: '湿度',
                        type: 'line',
                        data: data.selectshidu,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name: '风速',
                        type: 'line',
                        data: data.selectfengsu,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    /*{
                        name: '光照',
                        type: 'line',
                        data: data.selectguangzhao ,
                        markPoint: {
                            data: [
                                { type: 'max', name: '最大值' },
                                { type: 'min', name: '最小值' }
                            ]
                        },
                        markLine: {
                            data: [
                                { type: 'average', name: '平均值' }
                            ]
                        }
                    },*/
                    {
                        name: 'PM2.5',
                        type: 'line',
                        data: data.selectpm,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name: '降雨',
                        type: 'line',
                        data: data.selectyuliang,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };
            lineChart.setOption(lineoption);
            $(window).resize(lineChart.resize);
        }

    });
    //温度
    $.ajax({
        type: "post",
        url: "/yibnwendu" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.TEMPERATURE == 0) {
                $("#d1").html(data.TEMPERATURE);
            } else {
                $("#d1").html(data.TEMPERATURE + '°C');
            }
        }
    });
    //大气湿度
    $.ajax({
        type: "post",
        url: "/yibnshidu" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.ATMOSPHERICHUMIDTY == 0) {
                $("#d2").html(data.ATMOSPHERICHUMIDTY);
            } else {
                $("#d2").html(data.ATMOSPHERICHUMIDTY + '%RH');
            }
        }
    });
    //风向
    $.ajax({
        type: "post",
        url: "/yibnfengxiang" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.WINDDIRECTION == 0) {
                $("#d3").html(data.WINDDIRECTION);
            } else {
                $("#d3").html(data.WINDDIRECTION + '°');
            }
        }
    });

    //风速
    $.ajax({
        type: "post",
        url: "/yibnfengsu" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.WINDSPEED == 0) {
                $("#d4").html(data.WINDSPEED);
            } else {
                $("#d4").html(data.WINDSPEED + 'm/s');
            }
        }
    });
    //光照
    $.ajax({
        type: "post",
        url: "/yibnguangzhao" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.LIGHTLNTENSITY == 0) {
                $("#d5").html(data.LIGHTLNTENSITY);
            } else {
                $("#d5").html(data.LIGHTLNTENSITY + 'lux');
            }
        }
    });
    //PM2.5
    $.ajax({
        type: "post",
        url: "/yibnpm" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.PM2DOT5 == 0) {
                $("#d6").html(data.PM2DOT5);
            } else {
                $("#d6").html(data.PM2DOT5 + 'μg/m3');
            }
        }
    });

    //降雨量
    $.ajax({
        type: "post",
        url: "/yibnyuliang" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            //获取容器
            // var d7=$("#d7");
            //清除记录
            /* d7.empty();
              d7.append(" <div style=\" font-size:20px; font-weight:bold;margin-top:40px;\">"+data.PRECIPITATION+"pH</div>");
              d7.append("<div style=\" font-size:16px; margin-top:10px; color:#969696;\">降雨量</div>");*/
            if (data.PRECIPITATION == 0) {
                $("#d7").html(data.PRECIPITATION);
            } else {
                $("#d7").html(data.PRECIPITATION + 'mm');
            }
        }
    });

    //土壤PH
    $.ajax({
        type: "post",
        url: "/yibnturangPH" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.SOILPH == 0) {
                $("#d8").html(data.SOILPH);
            } else {
                $("#d8").html(data.SOILPH + 'PH');
            }
        }
    });

    //海拔
    $.ajax({
        type: "post",
        url: "/yibnhaiba" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.ALTITUDE == 0) {
                $("#d9").html(data.ALTITUDE);
            } else {
                $("#d9").html(data.ALTITUDE + 'm');
            }
        }
    });

    //气压
    $.ajax({
        type: "post",
        url: "/yibnqiya" + "?" + KEYID,
        data: {"KEYID": KEYID},
        dataType: "json",
        success: function (data) {
            if (data.AIRPRESSURE == 0) {
                $("#d10").html(data.AIRPRESSURE);
            } else {
                $("#d10").html(data.AIRPRESSURE + 'hpa');
            }
        }
    });
}