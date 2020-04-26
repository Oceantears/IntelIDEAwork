
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加农户</title>

    <script type="text/javascript" src="/js/jquery-3.4.1.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="/js/xcity.js" charset="utf-8"></script>--%>

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
                    if (res.code > 0) {
                        return layer.msg('上传失败');
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
    <%--<script>
        layui.use(['form','code'], function(){
            form = layui.form;

            layui.code();

            $('#start').xcity();


        });
    </script>--%>
</head>
<body>


<form class="layui-form" id="saveFarmers" action="/farmers/saveFarmers" method="post">

        <%--<div class="layui-form-item">
            <label class="layui-form-label">上传头像</label>
            <div class="layui-input-inline uploadHeadImage">
                <div class="layui-upload-drag" id="headImg">
                    <i class="layui-icon"></i>
                    <p>点击上传图片，或将图片拖拽到此处</p>
                </div>
            </div>
            <div class="layui-input-inline">
                <div class="layui-upload-list">
                    <img class="layui-upload-img headImage" src="http://t.cn/RCzsdCq" id="demo1">
                    <p id="demoText"></p>
                </div>
            </div>
        </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">农户名称</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="farmers_name"  required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">添加时间</label>
        <div class="layui-input-block">
             <input id="test1" type="text" style="width: 190px;" name="addtime"  required  lay-verify="required" placeholder="请选择时间" autocomplete="off" class="layui-input" >
       </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">县域</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="county"  required  lay-verify="required" placeholder="请输入县域" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="farmers_tel"  required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="farmers_addr"  required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">二维码</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="qrcode"  required  lay-verify="required" placeholder="请输入二维码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">贫困线</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="low_income_level"  required  lay-verify="required" placeholder="请输入贫困线" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">是否过贫困线？</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="is_cross_level"  required  lay-verify="required" placeholder="0为没过，1为过了" autocomplete="off" class="layui-input">
        </div>
    </div>


    <%--<div class="layui-form-item x-city" id="start">
        <div class="layui-input-inline">
            <select name="su_province" lay-filter="province">
                <option value="">用户所在省份</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="su_city" lay-filter="city">
                <option value="">用户所在城市</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="su_district" lay-filter="area">
                <option value="">用户所在地区</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">用户所属部门</label>
        <select id="su_dept_id" name="su_dept_id">
              <option value="0">请选择</option>
        </select>
    </div>--%>

    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-top: 20px;">
            <button class="layui-btn layui-btn-warm" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script>

    /*layui.use('form', function(){
        var form = layui.form;


    });*/


    layui.use(['form', 'layedit', 'laydate','jquery'], function() {
        $=layui.jquery;
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;

        laydate.render({
            elem: '#test1', //指定元素
            /*trigger: 'click',
            type:'datetime', // 可选择：年、月、日、时、分、秒*/
            format: 'yyyy-MM-dd HH:mm:ss', //指定时间格式
            value: new Date(), // 指定值
        });


        /*$.ajax({
            type:"POST",
            data:{pui_su_id:''},
            url:'/dept/queryAlldept2',
            dataType: 'json',
            contentType: 'application/x-www-from-urlencoded;charset=UTF-8',
            async:false,
            cache:false,
            success:function (data) {
                var node="";
                $.each(data,function(index,item){
                    node+="<option value='"+item.dept_id+"'>"+item.dept_name+"</option>";
                });
                $("#su_dept_id").append(node);
                form.render('select');

            }
        })*/


    })


</script>
</body>
</html>
