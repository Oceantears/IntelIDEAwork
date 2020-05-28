
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
    <style type="text/css">
        .layui-form-label{
            width:100px;
        }
        .layui-input-block{
            magin-left:130px;
        }
    </style>
    <script>

        layui.use(['form', 'upload', 'layer','laydate'], function () {
            var laydate = layui.laydate;

            //执行一个laydate实例
            /*laydate.render({
                elem: '#su_birth_dt'
                ,type: 'date'
                /!* ,position:'abolute'
                ,zindex:9999 *!/
            });*/
            //监听提交
            var form = layui.form;

            form.on('submit(formDemo2)', function(data){
                var data1 = {
                    farmers_name:data.farmers_name,
                    product_name:data.product_name,
                    unit:data.unit,
                    unit_price:data.unit_price,
                    introduce:data.introduce,
                    image_path:data.image_path,
                    product_gross:data.product_gross,
                    specification:data.specification
                }

                $.ajax({
                    url: '/product/toupdateProduct'
                    , type: 'post'
                    , contentType: "application/json; charset=utf-8"
                    , data: JSON.stringify(data1.field)
                    , success: function (data) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn').attr({
                            href: '/product/queryAllProduct'
                            , target: '_blank'
                        });
                    }
                    , error: function (data) {
                        //location.href="../error.jsp";
                        layer.msg("error")
                    }
                })
                layer.msg();
                return true;
            });
        });

    </script>
</head>
<body>
<form class="layui-form" action="/product/updateProduct" method="post">
    <input style="width: 190px; display: none;" type="text" name="product_id" id="product_id"
           required lay-verify="required" autocomplete="off" class="layui-input"
           value="add">
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">贫困户</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="farmers_name" name="farmers_name" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">产品名称</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="product_name" name="product_name" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">计量单位</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="unit" name="unit" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">销售价</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="unit_price" name="unit_price" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">图片路径</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="image_path" name="image_path" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">产品总数</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="product_gross" name="product_gross" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">产品规格</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="specification" name="specification" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">产品介绍</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="introduce" name="introduce" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-top: 20px;">
            <button class="layui-btn layui-btn-warm" lay-submit
                    lay-filter="formDemo2" id="formDemo2">修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
