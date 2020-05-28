<%--
  Created by IntelliJ IDEA.
  User: 13636
  Date: 2020/1/8
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
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
            laydate.render({
                elem: '#addtime'
                ,type: 'date'
                /* ,position:'abolute'
                ,zindex:9999 */
            });
            //监听提交
            var form = layui.form;

            form.on('submit(formDemo)', function(data){

                return true;
            });
        });

    </script>
</head>
<body>
<form class="layui-form" action="/farmers/updateFarmers" method="post">
    <input style="width: 190px; display: none;" type="text" name="farmers_id" id="farmers_id"
           required lay-verify="required" autocomplete="off" class="layui-input"
           value="add">
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">县域</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="county" name="county" required
                   lay-verify="required" placeholder="请输入县域 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">添加时间</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="addtime" name="addtime" required
                   lay-verify="required" placeholder="请选择时间 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">农户姓名</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="farmers_name" name="farmers_name" required
                   lay-verify="required" placeholder="请输入农户姓名 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="farmers_tel" name="farmers_tel" required
                   lay-verify="required" placeholder="请输入电话 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="farmers_addr" name="farmers_addr" required
                   lay-verify="required" placeholder="请输入地址 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">二维码</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="qrcode" name="qrcode" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">贫困线</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="low_income_level" name="low_income_level" required
                   lay-verify="required" placeholder="请输入贫困线 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">是否过贫困线？</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="is_cross_level" name="is_cross_level" required
                   lay-verify="required" placeholder="" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-top: 20px;">
            <button class="layui-btn layui-btn-warm" lay-submit
                    lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
