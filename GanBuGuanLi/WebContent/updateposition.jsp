<%@page import="com.lx.bean.Reserve"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>改变职位</title>
</head>
<body>


	<form  action="cadre.do?opt=upd2" method="post">
		<input style="width: 190px; display: none" type="text" name="opt"
			value="add"> 


		<%-- <div>
			候补编号: <input style="width: 190px;" type="text" name="reserve_id"
				value="<%=reserve2.getReserve_id() %>" />
		</div> --%>
		<div>
			员工ID: <input style="width: 190px;" type="text" name="employee_id"
				value="<%=request.getParameter("employee_id") %>" />
		</div>
		<div>
			当前职位: <input style="width: 190px;" type="text" name="work_exper"
				value="<%=request.getParameter("reserveposition") %>" />
		</div>
		<div>
			候补职位: <input style="width: 190px;" type="text" name="reserveposition"
				value="null" />
		</div> 
		<%-- <div>
			姓名: <input style="width: 190px;" type="text" name="name"
				value="<%=request.getParameter("name")%>" />
		</div> --%>
		<div>
			<input style="width: 190px;" type="submit" value="提交 ">
		</div>
	</form>
</body>
</html>