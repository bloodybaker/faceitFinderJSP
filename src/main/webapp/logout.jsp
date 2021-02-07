<%--
  Created by IntelliJ IDEA.
  User: 38095
  Date: 08.02.2021
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("index.jsp");
%>
