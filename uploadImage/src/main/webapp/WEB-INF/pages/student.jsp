<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2020/5/29
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
</head>
<body>
    <h1>查询所有学生</h1>
    <c:forEach items="${students}" var="stu">
        ${stu.sName}
    </c:forEach>
</body>
</html>
