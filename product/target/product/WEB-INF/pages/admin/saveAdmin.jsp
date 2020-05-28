
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/layui/layui.js"></script>
    <script src="/js/xcity.js"></script>
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

            /*laydate.render({
                elem: '#su_birth_dt'
                ,type: 'date'
            });*/
            //监听提交
            var form = layui.form;

            form.on('submit(formDemo)', function(data){
                layer.msg();
                return true;
            });
        });
    </script>
    <%--<script type="text/javascript">
        layui.use(["jquery", "upload", "form", "layer", "element"], function () {
            var $ = layui.$,
                element = layui.element,
                layer = layui.layer,
                upload = layui.upload,
                form = layui.form;
            //拖拽上传
            var uploadInst = upload.render({
                elem: '#headImg'
                , url: '/upload/headImg'
                , size: 500
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result); //图片链接（base64）
                    });
                }
                , done: function (res) {
                    //如果上传失败
                    alert(res.data.src);
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }else {
                        $('#su_icon').val(res.data.src)
                    }
                    //上传成功
                    //打印后台传回的地址: 把地址放入一个隐藏的input中, 和表单一起提交到后台, 此处略..
                    /*   console.log(res.data.src);*/
                    window.parent.uploadHeadImage(res.data.src);
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #8f8f8f;">上传成功!!!</span>');
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });
            element.init();
        });
    </script>--%>
</head>
<body>
<form class="layui-form" action="/admin/saveAdmin" method="post">
    <%--<div class="layui-form-item">
        <label class="layui-form-label">修改头像</label>
        <div class="layui-input-inline uploadHeadImage">
            <div class="layui-upload-drag" id="headImg">
                <i class="layui-icon"></i>
                <p>点击上传图片，或将图片拖拽到此处</p>
            </div>
        </div>
        <input type="hidden" id="su_icon" name="su_icon" value=""/>
        <div class="layui-input-inline">
            <div class="layui-upload-list">
                <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo1">
                <p id="demoText"></p>
            </div>
        </div>
    </div>--%>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">管理员</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="admin" required
                   lay-verify="required" placeholder="请输入管理员" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-block" style="width:190px; margin-left: 130px">
            <input style="width: 190px;" type="text" name="name" required
                   lay-verify="required" placeholder="请输入登录名" autocomplete="off"
                   class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">登陆密码</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="password" required
                   lay-verify="required" placeholder="请输入登陆密码" autocomplete="off"
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
<script>

    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg();
            return true;
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });
</script>
<%--<script>
    layui.use(['form','code'], function(){
        form = layui.form;

        layui.code();

        $('#start').xcity();

    });
</script>--%>
</body>
</html>
