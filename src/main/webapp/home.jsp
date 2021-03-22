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
            <li><a class="active" href="home.jsp">Home</a></li>
            <li><a href="find.jsp">Find player</a></li>
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
        <h1 style="color:white;">PGL Major 2021</h1>
        <p style="color:white; font-size: 20px">Prize pool: $2,000,00</p>
        <p style="color:white; font-size: 20px">Teams: TBA</p>
        <p style="color:white; font-size: 20px">Location: <img src="resources/sweden.png"/> Stockholm, Sweden</p>
        <p id="demo" style="color:white; font-size: 40px"></p>
        <iframe width="900" height="600" src="https://www.youtube.com/embed/QwtpTJzGnFY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        <!-- Optional: some overlay text to describe the video -->

        <!-- slideshow
        <div class="slideshow-container">


            <div class="mySlides fade">
                <div class="numbertext">1 / 3</div>
                <img src="resources/img1.png" style="width:30%">
                <div class="text">CS:GO fans on PGL Major 2021</div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">2 / 3</div>
                <img src="resources/img2.jpg" style="width:30%">
                <div class="text">Team Fnatic plays on PGL Major 2020</div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">3 / 3</div>
                <img src="resources/img3.jpg" style="width:30%">
                <div class="text">The best csgo event in 2021</div>
            </div>


            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
        </div>
        <br>


        <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
        </div>-->




        <script>
            var countDownDate = new Date("Oct 23, 2021 00:00:00").getTime();
            var x = setInterval(function() {
                var now = new Date().getTime();
                var distance = countDownDate - now;
                var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);
                document.getElementById("demo").innerHTML = days + "d " + hours + "h "
                    + minutes + "m " + seconds + "s ";
                if (distance < 0) {
                    clearInterval(x);
                    document.getElementById("demo").innerHTML = "EXPIRED";
                }
            }, 1000);
        </script>
        <script>
            var slideIndex = 1;
            showSlides(slideIndex);

            // Next/previous controls
            function plusSlides(n) {
                showSlides(slideIndex += n);
            }

            // Thumbnail image controls
            function currentSlide(n) {
                showSlides(slideIndex = n);
            }

            function showSlides(n) {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("dot");
                if (n > slides.length) {slideIndex = 1}
                if (n < 1) {slideIndex = slides.length}
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex-1].style.display = "block";
                dots[slideIndex-1].className += " active";
            }
        </script>
        <script>
            var slideIndex = 0;
            showSlides();

            function showSlides() {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                slideIndex++;
                if (slideIndex > slides.length) {slideIndex = 1}
                slides[slideIndex-1].style.display = "block";
                setTimeout(showSlides, 2000); // Change image every 2 seconds
            }
        </script>

    </center>
<footer>
    <center>
    <p style="color:white; font-size: 18px">Author: Yevhenii Chykalov <a href="mailto:info@tahometer.top" style="color:white; font-size: 18px">info@tahometer.top</a> <img src="resources/faceit.png" alt="faceit logo"width="60" height="40"></p>
    </center>
</footer>
</body>
</html>