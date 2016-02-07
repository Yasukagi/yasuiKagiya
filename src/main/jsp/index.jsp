<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>yasukagi</title>
</head>
<body>
<p>yasukagi.com</p>
<%
    Date date = new Date();
    out.println("現在時刻：" + date.toString());
%>
<br>
<a href="./Test">Goto testServlet</a>
</body>
</html>