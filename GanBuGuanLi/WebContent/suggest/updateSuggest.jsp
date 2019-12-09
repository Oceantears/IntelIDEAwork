<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
   <link rel="stylesheet" href="../jquery-easyui-1.4.2/themes/default/easyui.css"/>
    <link rel="stylesheet" href="../jquery-easyui-1.4.2/themes/icon.css"/>
    <script type="text/javascript" src="../js/jquery-2.1.0.min.js" charset="utf-8"></script>
    <script src="../jquery-easyui-1.4.2/jquery.easyui.min.js" charset="UTF-8"></script>
    <script src="../jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
    <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
    <script src="../layui/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="SuggestServlet">
    <input style="width: 190px;display: none" type="text" name="opt" required  lay-verify="required" autocomplete="off" class="layui-input" value="upd" >
    <div class="layui-form-item">
        <label class="layui-form-label">干部ID</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="employee_id" value="${suggest2.employee_id}" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
        </div>
    </div>
 <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="name" value="${suggest2.name}" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
<div class="layui-form-item">
        <label class="layui-form-label">当前职位</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="work_exper" value="${suggest2.work_exper}" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">候补职位</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="reserveposition" value="${suggest2.reserveposition}" required  lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
        </div>
    </div>
    
   
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-top: 20px;">
            <button class="layui-btn layui-btn-warm" lay-submit lay-filter="formDemo">立即提交</button>
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
</body>
</html>