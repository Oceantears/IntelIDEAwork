<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2019/11/1
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <head>
      <title>时间展示</title>
      <script language="JavaScript">
        function time() {
          window.location.reload();
        }
        setTimeout("time()",1000);
      </script>
  </head>
  <body>
  现在时刻：<%=new Date().toLocaleString()%>
  </body>
</html>
