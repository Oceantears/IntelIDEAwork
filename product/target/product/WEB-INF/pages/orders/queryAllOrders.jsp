<%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2020/3/19
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/layui/layui.js"></script>
    <script type="text/javascript">
        layui
            .use(
                //方法中页面里需要用到的组件
                ['table',
                'form',
                'element',
                'layedit',
                'layer',
                'laydate'],
                function() {
                    //定义组件
                    var table = layui.table;
                    var form = layui.form;
                    var element= layui.element;
                    var layer = layui.layer;
                    var layedit = layui.layedit;
                    var laydate = layui.laydate;


                    var tab=table.render({
                        elem : '#test',
                        url : '/orders/queryAllOrders',
                        toolbar : '#toolbarDemo',
                        cellMinWidth : 40,
                        method : 'post',
                        title : '订单管理'
                        ,cols : [ [ {
                            type : 'checkbox',

                            fixed : 'left'
                        }
                            ,{field:'order_id', title:'订单号', width:100, fixed: 'left', unresize: true, sort: true}
                            ,{field:'product_name', title:'产品'}
                            ,{field:'cus_name', title:'购买人'}
                            ,{field:'numbers', title:'数量'}
                            ,{field:'pay_time', title:'付款时间'}
                            ,{field:'farmers_name', title:'来源'}
                            ,{field:'order_status', title:'订单状态'}
                            /*,{field:'is_cross_level', title:'是否脱贫',templet:function (d) {
                                    return d.is_cross_level==0?"否":"是"
                                }}
                            ,{field:'su_icon', title:'头像',templet:function (d) {
                                    return '<div><img src='+d.su_icon+'></div>'
                                } }*/
                            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}

                        ] ]
                        /*,page: true
                        ,response: {
                            statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
                        }
                        ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                            return {
                                "code": res.status, //解析接口状态
                                "msg": res.message, //解析提示文本
                                "count": res.total, //解析数据长度
                                "data": res.rows.item //解析数据列表
                            };
                        }*/
                        ,page : {
                            layout : [ 'count', 'prev', 'page', 'next',
                                'limit', 'refresh', 'skip' ]
                        },
                        id : 'testReload'
                    });

                    //头工具栏事件
                    table.on('toolbar(test)', function(obj) {
                        var checkStatus = table.checkStatus(obj.config.id);
                        switch (obj.event) {
                            case 'getCheckLength':
                                active.getCheckData();
                                break;
                            case 'getCheckData':
                                active.reload();
                                break;
                            case 'isAll':
                                active.notice();
                                break;
                        }
                        ;
                    });
                    //添加事件

                    //下拉框查询
                    $(document).ready(function(){
                        // select下拉框选中触发事件
                        form.on("select(farmerFilter)",function (data) {
                            alert(data.value);       //获取选中的值
                            //清空原有select内的数据  只保留第一项
                            $("#custom_id").find("option:not(:first)").remove();
                            form.render('select', 'farmerFilter');//渲染表单

                            $.ajax({
                                url:'/farmers/queryAllFarmers',
                                dataType:'json',
                                type:'post',
                                page : {
                                    layout : [ 'count', 'prev', 'page', 'next',
                                        'limit', 'refresh', 'skip' ]
                                },
                                success:function(data){

                                    // $.each(data,function(index,item){
                                    //     $('#farmer_id').append(new Option(item.name,item.id));//往下拉菜单里添加元素
                                    // })

                                    var list=data.extend();
                                    alert(list)

                                    form.render();//菜单渲染 把内容加载进去
                                }
                            })




                        });
                    });

                    // $.ajax({
                    //     url:'departmentAction_findAllDepartment.action',
                    //     dataType:'json',
                    //     type:'post',
                    //     success:function(data){
                    //
                    //         $.each(data,function(index,item){
                    //             item.name="张三";
                    //             item.id="aaaaa";
                    //
                    //             $('#farmer_id').append(new Option(item.name,item.id));//往下拉菜单里添加元素
                    //         })
                    //
                    //         form.render();//菜单渲染 把内容加载进去
                    //     }
                    // })


                    //触发事件
                    active = {
                        //页面重新加载
                        reload : function() {
                            // var order_id = $("#order_id").val();
                            // tab.reload({
                            //     where : {
                            //         order_id : order_id,
                            //     }
                            // });


                        },
                        getCheckData : function() {
                            //获取选中数据
                            var checkStatus = table
                                .checkStatus('testReload'), data = checkStatus.data;
                            if (data == "") {
                                layer.msg('至少也得选一个吧', {
                                    icon : 2
                                });
                                return;
                            }

                            var delArray = [];
                            //获取单元格选中的行
                            if (data.length > 0) {
                                for (var i = 0; i < data.length; i++) {
                                    delArray.push(data[i].id);

                                }
                            }
                            var ids = delArray.join(",");
                            layer
                                .confirm(
                                    '确认要删除嘛？' + delArray,
                                    function(index) {
                                        $
                                            .ajax({
                                                type : 'POST',
                                                url : '/orders/ordersDelete',
                                                data : {
                                                    'delArray' : ids
                                                },
                                            });
                                        layer.msg('删除成功！', {
                                            icon : 1
                                        });
                                        //location.reload();
                                        tab.reload();//局部刷新
                                    });

                        },

                        notice : function() {
                            //示范一个公告层
                            layer.open({
                                type : 2,
                                title : '添加管理员',
                                skin : 'layui-layer-rim', //加上边框
                                closeBtn : false,
                                area : [ '400px', '380px' ], //宽高
                                /* content: 'html内容' */
                                id : 'LAY_layuiuser',//设定一个id，防止重复弹出
                                btn : [ '退出' ],
                                btnAlign : 'c',
                                offset : '50px',
                                moveType : 1,//拖拽模式，0或者1
                                content : '/orders/tosaveOrders',
                                end : function() {
                                    location.reload();
                                }
                                ,success: function(layero){
                                    var btn = layero.find('.layui-layer-btn');
                                    btn.find('.layui-layer-btn').attr({
                                        href: '/orders/queryAllOrders'
                                        ,target: '_blank'

                                    });
                                }
                            });
                        }

                    };

                    //监听行工具事件
                    table.on('tool(test)', function(obj) {
                        var datas = obj.data;
                        //console.log(obj)
                        switch (obj.event) {
                            case 'del':
                                layer.confirm("确认要删除吗，删除后不能恢复",
                                    function(index) {
                                        deleteAdmin(datas.id);
                                        layer.close(index);
                                        location.reload();
                                    });
                                break;
                            case 'edit':
                                updateUser(datas);
                                break;
                        }
                        ;
                    });



                });
        function deleteOrder(id) {
            //alert(id);
            $.ajax({
                type : 'POST',
                url : '/orders/deleteOrder',
                data:{'id':id},
                success : function(msg) {
                    alert("Data Saved: " + msg);
                }
            });
        }
        //修改
        function updateUser(datas) {
            layer.open({
                type: 2,
                title: '修改人员信息',
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
                content: 'toupdateOrder',
                end: function () {
                    location.reload();
                },
                success: function (layero, index2) {

                    var body = layer.getChildFrame('body', index2);

                    var iframeWin = window[layero.find('iframe')[0]['name']];

                    body.find("#id").val(datas.id);
                    body.find("#admin").val(datas.admin);
                    body.find("#name").val(datas.name);
                    body.find("#password").val(datas.password);
                    iframeWin.layui.form.render();
                }
            })
        }



    </script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <%--<div class="layui-input-block" style="width: 200px;float: left;margin-left:0px">--%>
    <%--    <input id="su_name" style="width: 200px" type="text" name="su_name" required lay-verify="required" placeholder="请输入搜索内容" autocomplete="off" class="layui-input">--%>
    <%--</div>--%>
    <div class="layui-btn-container">

        <button class="layui-btn layui-btn-danger"lay-event="getCheckLength" data-type="getCheckLength">批量删除</button>
        <button class="layui-btn layui-btn" lay-event="isAll">添加</button>
    </div>
    <form class="layui-form" action="" method="post">
        <div class="layui-inline" style="float: left;margin: 15px 15px 15px 0px;">
            <%--<label class="layui-form-label">请选择农户</label>--%>
            <div class="layui-input-block" style="width:200px;float: left;margin: 0px">
                <select name="farmer_id" id="farmer_id" lay-filter="farmerFilter" lay-search="" >
                    <option value="农户">请选择农户</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" style="margin: 15px;">
            <%--<label class="layui-form-label" >请选择产品</label>--%>
            <div class="layui-input-block" style="width:200px;float: left;margin: 0px">
                <select name="product_id" id="product_id" lay-filter="productFilter" lay-search="">
                    <option value="产品">请选择产品</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" style="margin: 15px;">
            <%--<label class="layui-form-label" >订单状态</label>--%>
            <div class="layui-input-block" style="width:200px;float: left;margin: 0px">
                <select name="order_status" id="order_status" lay-filter="orderFilter" lay-search="">
                    <option value="订单">订单状态</option>
                </select>
            </div>
        </div>
        <div class="layui-inline" style="margin: 15px;">
            <div class="layui-input-block" style="width:200px;float: left;margin: 0px">
                <button class="layui-btn layui-btn-warm" lay-event="getCheckData">搜索</button>
            </div>
        </div>
    </form>


</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
