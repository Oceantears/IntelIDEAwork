<%--
  Created by IntelliJ IDEA.
  User: 13636
  Date: 2020/3/8
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有的账户</h3>

<c:forEach items="${list}" var="queryAllAdmin">
  ${admin.admin}
    ${admin.name}
    ${admin.password}
</c:forEach>
</body>
</html>
