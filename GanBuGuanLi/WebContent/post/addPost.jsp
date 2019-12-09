<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加职位</title>
   <script type="text/javascript" src="../js/jquery-2.1.0.min.js" charset="utf-8"></script>
   <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
   <script src="../layui/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="../ks.do?opt=add">
    
             <input style="width: 190px;display: none" type="text" name="opt" required  lay-verify="required" autocomplete="off" class="layui-input" value="add" >
 
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">科室</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="ks_no"  required  lay-verify="required" placeholder="请输入科室编号" autocomplete="off" class="layui-input" lay-verify="email">
        </div>
    </div>
 <div class="layui-form-item">
        <label class="layui-form-label">职位编号</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_no"  required  lay-verify="required" placeholder="请输入职位编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">职位名称</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_title"  required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
  
<div class="layui-form-item">
        <label class="layui-form-label">职位描述</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_description"  required  lay-verify="required" placeholder="请描述描述" autocomplete="off" class="layui-input">
        </div>
    </div>
  
<div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">职位应有人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_duenum"  required  lay-verify="required" placeholder="请输入该职位应有人数" autocomplete="off" class="layui-input" lay-verify="email">
        </div>
    </div>
    
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">职位现在有人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_realitynum"  required  lay-verify="required" placeholder="请输入改职位现有人数" autocomplete="off" class="layui-input" lay-verify="email">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">职位短缺人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="shortage_num"  required  lay-verify="required" placeholder="请输入该职位短缺人数" autocomplete="off" class="layui-input" lay-verify="email">
        </div>
    </div>
    <div class="layui-form-item" style="margin-top: 10px">
        <label class="layui-form-label">职位编制</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_prepartion"  required  lay-verify="required" placeholder="职位编制" autocomplete="off" class="layui-input" lay-verify="email">
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