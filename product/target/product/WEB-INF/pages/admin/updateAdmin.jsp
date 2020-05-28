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
    <script src="/js/jquery-1.11.3.min.js"></script>
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

            form.on('submit(formDemo)', function(data){
                layer.msg();
                return true;
            });
        });

    </script>
</head>
<body>
<form class="layui-form" action="/admin/updateAdmin" method="post">
    <input style="width: 190px; display: none;" type="text" name="id" id="id"
           required lay-verify="required" autocomplete="off" class="layui-input"
           value="add">
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">管理员</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="admin" name="admin" required
                   lay-verify="required" placeholder="请输入管理员 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="name" name="name" required
                   lay-verify="required" placeholder="请输入登录名 " autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">登录密码</label>
        <div class="layui-input-block" style="width: 190px;margin-left:130px;">
            <input style="width: 190px;" type="text" id="password" name="password" required
                   lay-verify="required" placeholder="请输入登录密码 " autocomplete="off"
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
