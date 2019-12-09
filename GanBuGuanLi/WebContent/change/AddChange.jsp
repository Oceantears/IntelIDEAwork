<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>变更表添加</title>
</head>
<body>


	<form  action="../ChangetableServlet?opt=add" method="post" style="margin-left: 600px;margin-top: 100px">
		<input style="width: 190px; display: none" type="text" name="opt"
			value="add"> 

		<div>
		    干&nbsp;部&nbsp;&nbsp;ID: <input style="width: 190px;" type="text" name="employee_id"
				value="<%=request.getParameter("employee_id") %>" />
		</div>
		<br>
		<div>
			当前职位: <input style="width: 190px;" type="text" name="work_exper"
				value="<%=request.getParameter("work_exper") %>" />
		</div>
		<br>
		<div>
			候补职位: <input style="width: 190px;" type="text" name="reserveposition"
				value="<%=request.getParameter("reserveposition") %>" />
		</div> 
		<br>
		<div>
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名: <input style="width: 190px;" type="text" name="name"
				value="<%=request.getParameter("name")%>" />
		</div>
		<br>
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style="width: 100px;" type="submit" value="提交 ">
		
		</div>
	</form>
	
</body>
</html>