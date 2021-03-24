<%@ page import="company.model.data.DAO" %>
<%@ page import="company.model.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Leaderboard</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Play:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/front.css">
</head>
<body>
<style>
    body {
        background-image: url('resources/background.svg');
    }
</style>
<%
    String firstName = "",lastName = "";

    if(session.getAttribute("username") == null){
        response.sendRedirect("index.jsp");
    }else{
        firstName = DAO.getInstance().getFirstName(session.getAttribute("username").toString(),"users");
        lastName = DAO.getInstance().getLastName(session.getAttribute("username").toString(),"users");
    }
%>
<jsp:useBean id="userBean" class="company.model.beans.UserBean" scope="session">
    <jsp:setProperty name="userBean" property="firstName" value="<%=firstName%>"/>
    <jsp:setProperty name="userBean" property="lastName" value="<%=lastName%>"/>
</jsp:useBean>
<header>
    <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a  href ="find.jsp">Find player</a></li>
        <li><a class="active" href="leader.jsp">Leaderboard</a></li>
        <li><a  href="champion.jsp">Championships</a></li>
        <li style="float:right">
            <div class="dropbtn">
                <a href="logout.jsp"><%=userBean%> (Log out)</a>
            </div>
        </li>
    </ul>
</header>



<footer>
    <center>
        <p style="color:white; font-size: 18px">Author: Yevhenii Chykalov <a href="mailto:info@tahometer.top" style="color:white; font-size: 18px">info@tahometer.top</a> <img src="resources/faceit.png" alt="faceit logo"width="60" height="40"></p>
    </center>
</footer>
</body>
</html>
