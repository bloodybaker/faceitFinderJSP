<%@ page import="company.model.data.DAO" %>
<%@ page import="company.model.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Find player</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Play:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/front.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('input[type="button"]').click(function() {
                console.log("Executed")
                $.ajax({
                    type : 'GET',
                    headers : {
                        Accept : "application/json; charset=utf-8",
                        "Content-Type" : "application/json; charset=utf-8"
                    },
                    url : '${pageContext.request.contextPath}/finder',
                    data: {
                        "name": document.getElementById('name').value
                    },

                    success : function (responseText) {
                    $("#nickname").text("Nickname: " + responseText[0]);
                    $("#avatar").attr('src', responseText[1]);
                    $("#avatar").removeAttr('hidden');
                    $("#country").text("Country: " + responseText[2]);
                    $("#skill").text("Skill lvl: " + responseText[3]);
                    $("#elo").text("ELO: " +responseText[4]);
                    $("#playername").text("Player name: " +responseText[5]);
                    $("#language").text("Language: " + responseText[6]);
                    $("#steam").attr('href',"http://steamcommunity.com/profiles/" + responseText[7]);
                    $("#steam").removeAttr('hidden');
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
<style>
    input[type=text] {
        border: 4px solid #8842d5;
        border-radius: 5px;
    }
    input[type=button] {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 16px 32px;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
    }
    .circular--square {
        margin: 30px;
        border-radius: 50%;
        box-shadow: 0px 0px 9px 4px #747DE8;
        animation: glow 1.5s linear infinite alternate;
    }
    @keyframes glow{
        to {
            box-shadow: 0px 0px 30px 20px #535FED;
        }
    }
</style>
<center>
    <form>
        <h1 style="color:white;">Find player</h1>
        <p><input type="text" size="40" id ="name" name="name" height="20" placeholder="Username" required/></p>
        <p><input type="button" value="Submit" size="24"/></p>
    </form>
    <img class="circular--square" src="" id="avatar" hidden/>
    <p style="color:white; font-size: 20px" id="nickname"></p>
    <p style="color:white; font-size: 20px" id="country"></p>
    <p style="color:white; font-size: 20px" id="skill"></p>
    <p style="color:white; font-size: 20px" id="elo"></p>
    <p style="color:white; font-size: 20px" id="playername"></p>
    <p style="color:white; font-size: 20px" id="language"></p>
    <p style="color:white; font-size: 20px"><a href="" hidden id="steam">Steam account</a></p>

</center>
<footer>
    <center>
        <p style="color:white; font-size: 18px">Author: Yevhenii Chykalov <a href="mailto:info@tahometer.top" style="color:white; font-size: 18px">info@tahometer.top</a> <img src="resources/faceit.png" alt="faceit logo"width="60" height="40"></p>
    </center>
</footer>
</body>
</html>