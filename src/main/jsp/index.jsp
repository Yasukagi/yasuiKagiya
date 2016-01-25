<%@ page contentType="text/html; charset=windows-31j" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.*" %>
<%@ page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION" %>
<html>
<head>
    <title>yasukagi</title>
</head>
<body>
<p>yasukagi.com</p>
<%
    Date date = new Date();
    out.println("Œ»ÝŽžF" + date.toString());
%>
<br>
<a href="/Test">Goto testServlet.class</a>
</body>
</html>