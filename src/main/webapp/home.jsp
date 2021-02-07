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

<h1>Welcome, ${cookie['first_name'].value} ${cookie['last_name'].value} </h1>
<a href="logout.jsp"> Log out</a>
</body>
</html>
