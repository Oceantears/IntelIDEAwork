<%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2019/11/12
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部商品</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/zh_CN.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <script>

        function loadXML() {
            var xmlhttp;
            if(window.XMLHttpRequest){
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=window.XMLHttpRequest
            }else {
                // code for IE6, IE5
                xmlhttp=window.ActiveXObject("Microsoft.XMLHTTP");
            }

        }
    </script>
</head>
<body onload="loadXML()">
    <div class="container">
        <h1>
            <marquee>
                欢迎进入本网站！！
            </marquee>
        </h1>
        <table>
            <tr>
                <th id="goods_id">商品编号</th>
                <th id="goods_name">商品名称</th>
                <th id="goods_count">商品数量</th>
                <th id="goods_price">商品单价</th>
                <th id="total">商品总价</th>
            </tr>
            <%
                //获取servlet共享过来的集合
            %>
        </table>
    </div>
</body>
</html>
