<%@ page import="company.controller.api.FaceitAPIController" %>
<%@ page import="company.model.beans.FaceitUser" %>
<%@ page import="company.model.parsers.ParserJSON" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="resources/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="company.controller.routes.auth.Login" method="post">
            <h1>Login</h1>
            <input type="text" required placeholder="Username" name="username" />
            <input type="password" required placeholder="Password" name="password" />
            <button>Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>You can create a new account here</p>
                <a href="register.jsp"> <button class="ghost" id="signUp">Sign Up</button></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>