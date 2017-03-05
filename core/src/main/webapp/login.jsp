<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages" var="msg" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>LOGOWANIE</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="Shortcut icon"
          href="http://1.bp.blogspot.com/_qxNvBPirDY4/S6SogyHzSYI/AAAAAAAAACI/1LaUy9AAilc/s320/shopping.jpg"/>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }
        .carousel-inner img {
            width: 100%; /* Set width to 100% */
            margin: auto;
            min-height:200px;
        }
        @media (max-width: 600px) {
            .carousel-caption {
                display: none;
            }
        }
    </style>
</head>
<body>

<%--Navbar--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="\">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/login">Login</a></li>
                <li><a href="/"><fmt:message bundle="${msg}" key="home" /></a></li>
                <li><a href="/products"><fmt:message bundle="${msg}" key="products" /></a></li>
                <li><a href="/favourites"><fmt:message bundle="${msg}" key="fav" /></a></li>
                <li><a href="/searchProducts"><fmt:message bundle="${msg}" key="search" /></a></li>
                <li><a href="/webForm"><fmt:message bundle="${msg}" key="webform" /></a></li>
<<<<<<< .merge_file_nLHuw8
                <li><a href="/report"> Report</a></li>
=======
>>>>>>> .merge_file_AZoVi8
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="?locale=pl"><fmt:message bundle="${msg}" key="PL" /></a></li>
                <li><a href="?locale=en"><fmt:message bundle="${msg}" key="EN" /></a></li>
                <li role="presentation"><span class="glyphicon glyphicon-log-in"></span><form action="/adminPanel" method="post">
                    <button type="submit" name="logout" value="logout" class="btn-link"><fmt:message bundle="${msg}" key="logout" /></button>
                </form></li>
            </ul>
        </div>
    </div>
</nav>

<%--Just text container--%>
<div class="container text-center">

    <div class="container" align="center">
        <h1 class="lead"><fmt:message bundle="${msg}" key="log_in" /></h1>
    </div>



    <div class="container" align="center" >
        <form method="post" action="logUser">
            login: <input type="text" name="username">
            <fmt:message bundle="${msg}" key="password" /> <input type="password" name="password"><br>
            <input type="submit" value=<fmt:message bundle="${msg}" key="log_in_button" /> class="btn btn-primary btn-lg">
        </form>
        <div class="container">
            <a href="/createUser"><img height="150" width="150" class="img-rounded"
                                       src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/New_user_icon-01.svg/2000px-New_user_icon-01.svg.png"></a>
            <a href="/twitter"> <img src="https://g.twimg.com/about/feature-corporate/image/twitterbird_RGB.png"
                                     height="150" width="150" class="img-circle"></a>
            <a href="/facebook"><img src="https://www.facebook.com/images/fb_icon_325x325.png" height="150" width="150"
                                     class="img-circle"></a>

        </div>
    </div>
</div>


</body>

</html>