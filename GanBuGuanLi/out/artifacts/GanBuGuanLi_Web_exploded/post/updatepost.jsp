<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
   <link rel="stylesheet" href="../jquery-easyui-1.4.2/themes/default/easyui.css"/>
    <link rel="stylesheet" href="../jquery-easyui-1.4.2/themes/icon.css"/>
    <script type="../text/javascript" src="js/jquery-2.1.0.min.js" charset="utf-8"></script>
    <script src="../jquery-easyui-1.4.2/jquery.easyui.min.js" charset="UTF-8"></script>
    <script src="../jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
    <link rel="../stylesheet" href="layui/css/layui.css"  media="all">
    <script src="../layui/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="post.do">
    <div class="layui-form-item" style="margin-top: 10px;">
        <label class="layui-form-label">职位编号</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_no" required  lay-verify="required" autocomplete="off" class="layui-input" value="${post2.job_no}" readonly="readonly">
            <input style="width: 190px;display: none" type="text" name="opt" required  lay-verify="required" autocomplete="off" class="layui-input" value="upd" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">科室编号</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="ks_no" value="${post2.ks_no}" required  lay-verify="required" placeholder="请输入职位编号" autocomplete="off" class="layui-input">
        </div>
    </div>
 <div class="layui-form-item">
        <label class="layui-form-label">职位名称</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_title" value="${post2.job_title}" required  lay-verify="required" placeholder="请描述名称" autocomplete="off" class="layui-input">
        </div>
    </div>
     <div class="layui-form-item">
        <label class="layui-form-label">职位描述</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_description" value="${post2.job_description}" required  lay-verify="required" placeholder="请描述职位" autocomplete="off" class="layui-input">
        </div>
    </div>
<div class="layui-form-item">
        <label class="layui-form-label">职位应有人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_duenum" value="${post2.job_duenum}" required  lay-verify="required" placeholder="请输入应有人数 "autocomplete="off" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">职位现有人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_realitynum" value="${post2.job_realitynum}" required  lay-verify="required" placeholder="请输入现有人数 "autocomplete="off" class="layui-input">
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">职位短缺人数</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="shortage_num" value="${post2.shortage_num}" required  lay-verify="required" placeholder="请输入短缺人数 "autocomplete="off" class="layui-input">
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">职位编制</label>
        <div class="layui-input-block">
            <input style="width: 190px;" type="text" name="job_preparation" value="${post2.job_preparation}" required  lay-verify="required" placeholder="职位编制"autocomplete="off" class="layui-input">
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