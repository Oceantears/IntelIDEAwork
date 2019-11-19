<%@ page import="com.it.bean.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sunmeng
  Date: 2019/11/14
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Book展示页面</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-1.4.4.min.js.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/zh_CN.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <center>

            <form action="BookServlet?opt=book_queryAll" method="post">
                书名:<input type="text" name="book_name"> &nbsp; &nbsp; 书号:<input
                    type="text" name="book_no"> &nbsp; &nbsp;
                <button type="submit">查询</button>
            </form>
        </center>
        <table align="center" class="table table-hover" border="1px">
            <tr>
                <th>序列号</th>
                <th>书号</th>
                <th>编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>价格</th>
                <th>删除/修改</th>
            </tr>
            <br>
            <br>
            <br>
            <br>
            <br>

            <%
                //获取servlet共享过来的集合booksList
                List<Book> booksList =  (List<Book>)request.getAttribute("booksList");
                String[] colors={"success","warning","danger","info"};        //定义表格颜色数组
                int j=0;
                for(int i = 0;i<booksList.size();i++){
            %>
            <tr class="<%=colors[j]%>">
                <td><%=i+1 %></td>
                <td><%=booksList.get(i).getBook_no() %></td>
                <td><%=booksList.get(i).getType_no() %></td>
                <td><%=booksList.get(i).getBook_name() %></td>
                <td><%=booksList.get(i).getAuthor() %></td>
                <td><%=booksList.get(i).getPublisher() %></td>
                <td><%=booksList.get(i).getPrice() %></td>
                <td><a href="BookServlet?book_no=<%=booksList.get(i).getBook_no()%>&opt=book_del">删除</a>&nbsp;&nbsp;
                    <a href="BookServlet?book_no=<%=booksList.get(i).getBook_no()%>&opt=book_findById">修改</a></td>
            </tr>
            <%
                    j++;
                    if(j==(colors.length)){
                        j=0;
                    }
                }
            %>

        </table>
    </div>
</body>
</html>
