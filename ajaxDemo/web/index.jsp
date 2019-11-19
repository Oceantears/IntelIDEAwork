<%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2019/11/13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax练习-校验数据库中用户</title>
    <script>
      function loadXml() {
        //创建XMLHttpRequest对象
        var xml;
          if(window.XMLHttpRequest){
            // code for IE7+, Firefox, Chrome, Opera, Safari
          xml=new XMLHttpRequest();
        }
        else {
            // code for IE6, IE5
            xml=new ActiveXObject("Microsoft.XMLHTTP");
        }
      }
    </script>
  </head>
  <body onload="loadXml()">

  </body>
</html>
