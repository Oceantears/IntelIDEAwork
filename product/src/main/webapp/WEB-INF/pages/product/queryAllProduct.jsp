
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/layui/layui.js"></script>
    <script type="text/html" id="xuhao">
        {{d.LAY_TABLE_INDEX+1}}
    </script>
    <script type="text/javascript">
        layui
            .use(
                'table',
                function() {
                    var table = layui.table;
                    var tab=table.render({
                        elem : '#testProduct',
                        url : '/product/queryAllProduct',
                        toolbar : '#toolbarProduct',
                        cellMinWidth : 40,
                        method : 'post',
                        title : '产品管理'
                        ,cols : [ [ {
                            type : 'checkbox',

                            fixed : 'left'
                        }
                            , {title: 'ID', templet: '#xuhao', width: 80, fixed: 'left', unresize: true, sort: true}
                            ,{field:'product_id', title:'产品编号',hide:true}
                            ,{field:'farmers_id', title:'农户编号',hide:true}
                            ,{field:'product_name', title:'产品名称'}
                            ,{field:'unit_price', title:'价格'}
                            ,{field:'unit', title:'单位',hide:true}
                            ,{field:'introduce', title:'介绍',hide:true}
                            ,{field:'image_path', title:'图片路径',hide:true}
                            ,{field:'product_gross', title:'产品总数',hide:true}
                            ,{field:'specification', title:'产品规格',hide:true}
                            ,{field:'farmers_name', title:'农户'}
                            ,{field:'farmers_addr', title:'地址'}
                            /*,{field:'su_icon', title:'头像',templet:function (d) {
                                    return '<div><img src='+d.su_icon+'></div>'
                                } }*/
                            ,{fixed: 'right', title:'操作', toolbar: '#barProduct', width:250}

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
                        data:[],
                        id : 'testReload'
                    });

                    //头工具栏事件
                    table.on('toolbar(testProduct)', function(obj) {
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
                    //触发事件
                    active = {
                        //页面重新加载
                        reload : function() {
                            var product_id = $("#product_id").val();
                            tab.reload({
                                where : {
                                    product_id : product_id,
                                }
                            });
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
                                    delArray.push(data[i].product_id);

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
                                                url : '/product/productDelete',
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
                            /*layer.open({
                                    type : 2,
                                    title : '添加产品',
                                    skin : 'layui-layer-rim', //加上边框
                                    closeBtn : false,
                                    area : [ '400px', '520px' ], //宽高
                                    /!* content: 'html内容' *!/
                                    id : 'LAY_layuiuser',//设定一个id，防止重复弹出
                                    btn : [ '退出' ],
                                    btnAlign : 'c',
                                    offset : ['5px','400px'],
                                    moveType : 1,//拖拽模式，0或者1
                                    content : 'tosaveProduct',
                                    end : function() {
                                        location.reload();
                                    }
                                ,success: function(layero){
                                            var btn = layero.find('.layui-layer-btn');
                                            btn.find('.layui-layer-btn').attr({
                                                href: '/product/queryAllProduct'
                                                ,target: '_blank'

                                    });
                                }
                                });*/
                        }

                    };

                    //监听行工具事件
                    table.on('tool(testProduct)', function(obj) {
                        var datas = obj.data;
                        //console.log(obj)
                        switch (obj.event) {
                            case 'del':
                                layer.confirm("确认要删除吗，删除后不能恢复",
                                    function(index) {
                                        deleteProduct(datas.product_id);
                                        layer.close(index);
                                        location.reload();
                                    });
                                break;
                            case 'edit':
                                updateProduct(datas);
                                break;
                            case 'compose':

                        }
                        ;
                    });

                });
        function deleteProduct(id) {
            //alert(id);
            $.ajax({
                type : 'POST',
                url : '/product/deleteProduct',
                data:{'product_id':id},
                success : function(msg) {
                    alert("Data Saved: " + msg);
                }
            });
        }
        //查看详情
        function updateProduct(datas) {
            layer.open({
                type: 2,
                title: '查看详情',
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
                content: 'toupdateProduct',
                end: function () {
                    location.reload();
                },
                success: function (layero, index2) {

                    var body = layer.getChildFrame('body', index2);

                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    body.find("#product_name").val(datas.product_name);
                    body.find("#farmers_name").val(datas.farmers_name);
                   // body.find("#farmers_addr").val(datas.farmers_addr);
                    body.find("#unit").val(datas.unit);
                    body.find("#unit_price").val(datas.unit_price);
                    body.find("#introduce").val(datas.introduce);
                    body.find("#image_path").val(datas.image_path);
                    body.find("#product_gross").val(datas.product_gross);
                    body.find("#specification").val(datas.specification);
                    iframeWin.layui.form.render();
                }
            })
        }
    </script>
</head>
<body>
<table class="layui-hide" id="testProduct" lay-filter="testProduct"></table>

<script type="text/html" id="toolbarProduct">
    <form class="layui-form" action="">
        <div class="layui-inline">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-inline">
                <input type="text" id="grade" name="grade" placeholder="请选择年级"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-inline">
                <select name="majorid" id="majorid">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <button class="layui-btn" id="searchBtn" lay-submit
                        lay-filter="formDemo" data-type="reload" style="margin-left: 15px">
                    <i class="layui-icon layui-icon-search"></i> 查询
                </button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <%--<div class="layui-input-block" style="width: 200px;float: left;margin-left:0px">
        <input id="su_name" style="width: 200px" type="text" name="su_name" required lay-verify="required" placeholder="请输入搜索内容" autocomplete="off" class="layui-input">
    </div>--%>
    <div class="layui-btn-container">
        <%--<button class="layui-btn layui-btn-warm" lay-event="getCheckData">搜索</button>--%>
        <button class="layui-btn layui-btn-danger"lay-event="getCheckLength" data-type="getCheckLength">批量删除</button>
        <button class="layui-btn layui-btn" lay-event="isAll">添加</button>
    </div>
</script>
<script type="text/html" id="barProduct">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >查看详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="compose">基本组成</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
