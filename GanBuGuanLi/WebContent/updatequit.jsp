<%@page import="com.quit.bean.Quit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<script type="text/javascript" src="js/jquery-2.1.0.min.js"
	charset="utf-8"></script>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script src="layui/layui.js" charset="utf-8"></script>
<script>
		layui.use('form', function() {
			var form = layui.form;
			form.on('submit(formDemo)', function(data) {
				layer.msg();
				return true;
			});
		});
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem : '#test1' 
			});
		});
	</script>
</head>
<body>
	<% Quit quit = (Quit)request.getAttribute("quit2");%>	
	<form class="layui-form" action="QuitServlet">
		<div class="layui-form-item" style="margin-top: 10px;">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="employee_id" required
					lay-verify="required" autocomplete="off" class="layui-input"
					value="<%=quit.getEmployee_id()%>"> 
			<input
					style="width: 190px; display: none" type="text" name="opt" required
					lay-verify="required" autocomplete="off" class="layui-input"
					value="update">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="name" value="<%=quit.getName()%>" required lay-verify="required"
					placeholder="请输入姓名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="sex" value="<%=quit.getSex()%>" required
					lay-verify="required" placeholder="请输入性别" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="age" value="<%=quit.getAge()%>" required
					lay-verify="required" placeholder="请输入年龄" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!-- 2 -->
		<div class="layui-form-item">
			<label class="layui-form-label">科室号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="ks_id" value="<%=quit.getKs_id()%>" required
					lay-verify="required" placeholder="请输入科室号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<!--7  -->
		<div class="layui-form-item">
			<label class="layui-form-label">职位编号</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="admin_id" value="<%=quit.getAdmin_id()%>" required
					lay-verify="required" placeholder="请输入职位编号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">离职原因</label>
			<div class="layui-input-block">
				<input style="width: 190px;" type="text" name="cause" value="<%=quit.getCause()%>" required
					lay-verify="required" placeholder="请输入离职原因" autocomplete="off"
					class="layui-input">
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