<%@ page import="company.model.data.DAO" %>
<%@ page import="company.model.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Play:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/front.css">

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#button').click(function() {
                $.ajax({
                    type : 'GET',
                    headers : {
                        Accept : "application/json; charset=utf-8",
                        "Content-Type" : "application/json; charset=utf-8"
                    },
                    url : 'finder',
                    data: {
                        "name": document.getElementById('name').value
                    },


                    success : function (responseText) {
                    $("#nickname").text(responseText[0].nickname);
                    $("#avatar").attr('src', responseText[1].avatarURL);
                    $("#country").text(responseText[2].country);
                    $("#skill").text(responseText);
                    $("#elo").text(responseText);
                    $("#playername").text(responseText);
                    $("#language").text(responseText);
                }
                });
            });
        });
    </script>

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
        <li><a class="active" href ="find.jsp">Find player</a></li>
        <li><a href="leader.jsp">Leaderboard</a></li>
        <li><a href="champion.jsp">Championships</a></li>
        <li style="float:right">
            <div class="dropbtn">
                <a href="logout.jsp"><%=userBean%> (Log out)</a>
            </div>
        </li>
    </ul>
</header>
<center>
    <form action="company.controller.routes.Finder" method="get">
    <h1 style="color:white;">Find player</h1>
    <p style="color:white; font-size: 20px">Input player name</p>
    <p style="color:white; font-size: 20px"><input type="text" name="name" placeholder="username"></p>
        <p><input type="submit" id="button" value="Get user"/></p>
    </form>
    <h1 style="color:white;" id="nickname"></h1>
    <img src="" id="avatar"/>
    <p style="color:white; font-size: 20px" id="country"></p>
    <p style="color:white; font-size: 20px" id="skill"></p>
    <p style="color:white; font-size: 20px" id="elo"></p>
    <p style="color:white; font-size: 20px" id="playername"></p>
    <p style="color:white; font-size: 20px"id="language"></p>

</center>
</body>
</html>