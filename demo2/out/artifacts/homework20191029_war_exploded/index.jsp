<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2019/10/29
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>当前时间</title>
    <script language="JavaScript">
        function refresh() {
          window.location.reload();
        }
        setTimeout('refresh()',1000);                 //页面每一秒刷新一次
    </script>
  </head>
  <body>
    现在时刻：<%=new Date().toLocaleString()%>
  </body>
</html>
