<%@ page import="java.util.Date" %>

<body>
<p>yasukagi.com</p>
<%
    Date date = new Date();
    out.println("現在時刻：" + date.toString());
%>
<br>
<a href="./Test">Goto testServlet</a>
</body>
