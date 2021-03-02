<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="resources/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<%
    if(session.getAttribute("username") != null){
        response.sendRedirect("home.jsp");
    }
%>
<h2>Anti Covid-19</h2>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="company.controller.auth.Register" method="post">
            <h1>Create Account</h1>
            <input type="text" required placeholder="First name" name="first_name" />
            <input type="text"required placeholder="Last name" name="last_name" />
            <input type="text"required placeholder="Username" name="username" />
            <input type="password"required placeholder="Password" name="password" />
            <a href="index.jsp"><button>Sign Up</button> </a>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and get new information</p>
                <a href="index.jsp"> <button class="ghost" id="signUp">Sign In</button></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>