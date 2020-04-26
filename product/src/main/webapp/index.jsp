<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>


<body>
<%--<a href="/admin/findAll">测试SpringMVC查询</a>--%>
    <div>
        <button type="button" class="layui-btn layui-btn-primary" >原始按钮</button>
        <button type="button" class="layui-btn">默认按钮</button>
        <button type="button" class="layui-btn layui-btn-normal"><a href="/admin/tologin">去登录</a></button>
        <button type="button" class="layui-btn layui-btn-warm">暖色按钮</button>
        <button type="button" class="layui-btn layui-btn-danger">警告按钮</button>
        <button type="button" class="layui-btn layui-btn-disabled">禁用按钮</button>
    </div>
<%--<a href="/admin/tologin">去登陆</a>--%>
</body>
</html>