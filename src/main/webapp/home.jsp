<%@ page import="company.data.DAO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07-Feb-21
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(session.getAttribute("username") == null){
        response.sendRedirect("index.jsp");
    }
%>
<h1>Welcome,<%=session.getAttribute("first_name")%> <%= session.getAttribute("last_name")%> </h1>
<a href="logout.jsp"> Log out</a>
</body>
</html>
