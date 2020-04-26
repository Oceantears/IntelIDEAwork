<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/html" id="xuhao">
        {{d.LAY_TABLE_INDEX+1}}
    </script>
    <script type="javascript">
        //显示大图片
        function show_img(t) {
            var t = $(t).find("img");
            //页面层
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['80%', '80%'], //宽高
                shadeClose: true, //开启遮罩关闭
                end: function (index, layero) {
                    return false;
                },
                content: '<div style="text-align:center"><img src="' + $(t).attr('src') + '" /></div>'
            });
        }
    </script>
    <script type="text/javascript">
        layui.use('table', function () {
            var table = layui.table;
            //渲染数据表格
            table.render({
                elem: '#farmersTab'  //渲染目标对象
                , url: '/farmers/queryAllFarmers' //数据接口
                , title: '农户信息' //数据导出的标题
                , toolbar: '#toolbarFarmers' //表格的工具条
                , cellMinWidth: 40
                /*,done:function (res,curr,count) {
                    alert(res);//后台url返回的json串
                    alert(curr);//当前页
                    alert(count);//数据总条数
                }*/
                /*,totalRow:true //开启合并行*/
                /*,page:true //是否开启分页*/
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {title: 'ID', width: 80, templet: '#xuhao', fixed: 'left', unresize: true, sort: true}
                    , {field: 'farmers_name', title: '姓名', align: 'center'}
                    , {field: 'addtime', title: '添加日期', align: 'center'}
                    , {field: 'county', title: '县域', align: 'center'}
                    , {field: 'farmers_tel', title: '电话', align: 'center'}
                    , {field: 'farmers_addr', title: '地址', align: 'center'}
                    , {field: 'qrcode', title: '二维码',sort:true, align: 'center',templet: function(d){
                            return '<div οnclick="show_img(this)" ><img src="'+d.qrcode+'" alt="" width="20px" height="20px"></a></div>';
                        }
                        }
                    , {field: 'low_income_level', title: '贫困线', align: 'center'}
                    , {
                        field: 'is_cross_level', title: '是否过贫困线', align: 'center', templet: function (d) {
                            return d.is_cross_level == '0' ? '过了' : '没过'
                        }
                    }
                    , {field: 'right', title: '操作', width: 200, toolbar: '#barFarmers', align: 'center'}
                ]]
                , page: {layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']}
                , id: 'testReload'
            });
            //头工具栏事件
            table.on('toolbar(farmersTab)', function (obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'getCheckData':
                        active.getCheckData();
                        break;
                    case 'getCheckLength':
                        active.reload();
                        break;
                    case 'isAll':
                        active.notice();
                        break;
                }
                ;
            });
            //添加事件
            //触发事件
            active = {
                //页面重新加载
                reload: function () {
                    var farmers_name = $("#farmers_name").val();
                    table.reload('testReload', {
                        where: {farmers_name: farmers_name}
                    });
                },
                getCheckData: function () {
                    //获取选中数据
                    var checkStatus = table.checkStatus('testReload'),
                        data = checkStatus.data;
                    if (data == "") {
                        layer.msg('至少也得选一个吧', {icon: 2});
                        return;
                    }

                    var delArray = [];
                    //获取单元格选中的行
                    if (data.length > 0) {
                        for (var i = 0; i < data.length; i++) {
                            delArray.push(data[i].farmers_id);

                        }
                    }
                    var ids = delArray.join(",");


                    layer.confirm('确认要删除嘛？' + delArray, function (index) {
                        $.ajax({
                            type: 'POST',
                            url: 'farmers/farmersDelete',
                            data: {'delArray': ids},
                            /* success:function (result) {
                                 //alert(result).rs;
                             }*/
                        });
                        layer.msg('删除成功！', {icon: 1});
                        location.reload();
                    });

                },
                //添加
                notice: function () {
                    //示范一个公告层
                    layer.open({
                        type: 2
                        , title: '添加农户'//false //不显示标题栏
                        , closeBtn: false
                        , area: ['400px', '550px'] //控制弹窗大小
                        , offset: ['10px', '300px'] //具体位置 顶部，左侧
                        /*,id: 'LAY_layuipro'*/ //设定一个id，防止重复弹出
                        , btn: ['退出']
                        , btnAlign: 'c'
                        , moveType: 1 //拖拽模式，0或者1
                        /*,content: '../addStudent.jsp'*/
                        , content: 'tosaveFarmers'
                        , end: function () {
                            location.reload();
                        }
                        /*,success: function(layero){
                            var btn = layero.find('.layui-layer-btn');
                            btn.find('.layui-layer-btn').attr({
                                href: '/farmers/queryAllFarmers'
                                ,target: '_blank'

                            });
                        }*/
                    });
                    layui.use(['form'], function () {
                        var form = layui.form;

                        //监听提交
                        form.on('submit(formDemo)', function (data) {
                            var data1 = {
                                county: data.county,
                                farmers_name: data.farmers_name,
                                farmers_tel: data.farmers_tel,
                                farmers_addr: data.farmers_addr,
                                qrcode: data.qrcode,
                                addtime: data.addtime,
                                low_income_level: data.low_income_level,
                                is_cross_level: data.is_cross_level
                            }

                            $.ajax({
                                url: '/farmers/tosaveFarmers'
                                , type: 'post'
                                , contentType: "application/json; charset=utf-8"
                                , data: JSON.stringify(data1.field)
                                , success: function (data) {
                                    var btn = layero.find('.layui-layer-btn');
                                    btn.find('.layui-layer-btn').attr({
                                        href: '/farmers/queryAllFarmers'
                                        , target: '_blank'
                                    });
                                }
                                , error: function (data) {
                                    //location.href="../error.jsp";
                                    layer.msg("error")
                                }
                            })
                            return true;
                        });
                    })
                }

            };

            //监听行工具事件
            table.on('tool(farmersTab)', function (obj) {
                var datas = obj.data;
                //console.log(obj)
                switch (obj.event) {
                    case 'del':
                        layer.confirm("确除认要删除吗，删后不能恢复", function (index) {

                            //alert(data.user_id);
                            delFarmers(datas.farmers_id);
                            layer.close(index);
                            location.reload();
                        });
                        break;
                    case 'edit':
                        updateFarmers(datas);
                        break;
                    case 'saveProduct':
                        saveProduct(datas);
                        //  detGroup(data.user_id);
                        break;
                }
                ;
            });


        });

        function delFarmers(id) {
            //alert(id);
            $.ajax({
                type: 'POST',
                url: 'deleteFarmers?farmers_id=' + id,
                success: function (msg) {
                    alert("Data Saved: " + msg);
                }
            });
        }

        //修改
        function updateFarmers(datas) {
            layer.open({
                type: 2
                , title: '修改农户信息'//false //不显示标题栏
                , closeBtn: false
                , area: ['400px', '500px'] //控制弹窗大小
                , offset: ['20px', '300px'] //具体位置 顶部，左侧
                , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                , btn: ['退出']
                , btnAlign: 'c'
                , moveType: 1 //拖拽模式，0或者1
                , content: 'toupdateFarmers'
                , end: function () {
                    location.reload();
                }
                , success: function (layero, index2) {

                    var body = layer.getChildFrame('body', index2);

                    var iframeWin = window[layero.find('iframe')[0]['name']];

                    //body.find("#farmers_id").val(datas.farmers_id);
                    body.find("#county").val(datas.county);
                    body.find("#farmers_name").val(datas.farmers_name);
                    body.find("#farmers_tel").val(datas.farmers_tel);
                    body.find("#farmers_addr").val(datas.farmers_addr);
                    body.find("#qrcode").val(datas.qrcode);
                    body.find("#addtime").val(datas.addtime);
                    body.find("#low_income_level").val(datas.low_income_level);
                    body.find("#is_cross_level").val(datas.is_cross_level);
                    iframeWin.layui.form.render();
                }
            })

            layui.use(['form'], function () {
                var form = layui.form;

                //监听提交
                form.on('submit(formDemo)', function (data) {
                    var data1 = {
                        county: data.county,
                        farmers_name: data.farmers_name,
                        farmers_tel: data.farmers_tel,
                        farmers_addr: data.farmers_addr,
                        qrcode: data.qrcode,
                        addtime: data.addtime,
                        low_income_level: data.low_income_level,
                        is_cross_level: data.is_cross_level
                    }

                    $.ajax({
                        url: '/farmers/toupdateFarmers'
                        , type: 'post'
                        , contentType: "application/json; charset=utf-8"
                        , data: JSON.stringify(data1.field)
                        , success: function (data) {
                            var btn = layero.find('.layui-layer-btn');
                            btn.find('.layui-layer-btn').attr({
                                href: '/farmers/queryAllFarmers'
                                , target: '_blank'
                            });
                        }
                        , error: function (data) {
                            //location.href="../error.jsp";
                            layer.msg("error")
                        }
                    })
                    return true;
                });
            })

        }

        /**
         * 添加产品
         */
        function saveProduct(datas) {
            layer.open({
                type: 2,
                title: '添加产品',
                skin: 'layui-layer-rim', //加上边框
                closeBtn: false,
                area: ['400px', '500px'] //宽高
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                btn: ['退出'],
                btnAlign: 'c',
                offset: '10px',
                moveType: 1 //拖拽模式，0或者1
                ,
                content: '/product/tosaveProduct',
                end: function () {
                    location.reload();
                },
                success: function (layero, index2) {

                    var body = layer.getChildFrame('body', index2);

                    var iframeWin = window[layero.find('iframe')[0]['name']];


                    body.find("#farmers_name").val(datas.farmers_name);
                    iframeWin.layui.form.render();
                }
            });

            layui.use(['form'], function () {
                var form = layui.form;

                //监听提交
                form.on('submit(formDemo1)', function (data) {
                    var data1 = {
                        farmers_id:data.farmers_id,
                        product_name:data.product_name,
                        unit:data.unit,
                        unit_price:data.unit_price,
                        introduce:data.introduce,
                        image_path:data.image_path,
                        product_gross:data.product_gross,
                        specification:data.specification
                    }

                    $.ajax({
                        url: '/product/tosaveProduct'
                        , type: 'post'
                        , contentType: "application/json; charset=utf-8"
                        , data: JSON.stringify(data1.field)
                        , success: function (data) {
                            var btn = layero.find('.layui-layer-btn');
                            btn.find('.layui-layer-btn').attr({
                                href: '/farmers/queryAllFarmers'
                                , target: '_blank'
                            });
                        }
                        , error: function (data) {
                            //location.href="../error.jsp";
                            layer.msg("error")
                        }
                    })
                    return true;
                });
            })

        }
    </script>

</head>
<body>
<table class="layui-hide" id="farmersTab" lay-filter="farmersTab"></table>
<script type="text/html" id="toolbarFarmers">
    <div class="layui-input-block" style="width: 200px;float: left;margin-left:0px">
        <input id="farmers_name" style="width: 200px" type="text" name="farmers_name" required lay-verify="required"
               placeholder="请输入用户名称" autocomplete="off" class="layui-input">

    </div>
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-warm" lay-event="getCheckLength">搜索</button>
        <button class="layui-btn layui-btn-danger" lay-event="getCheckData" data-type="getCheckData">批量删除</button>
        <button class="layui-btn layui-btn" lay-event="isAll">添加用户</button>
    </div>
</script>

<script type="text/html" id="barFarmers">
    <a class="layui-btn layui-btn-xs" lay-event="saveProduct">添加产品</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>