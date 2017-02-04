<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages" var="msg" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Szukaj ulubione produkty</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            min-height: 200px;
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
                <li class="active"><a href="/"><fmt:message bundle="${msg}" key="home" /></a></li>
                <li><a href="/products"><fmt:message bundle="${msg}" key="products" /></a></li>
                <li><a href="/favourites"><fmt:message bundle="${msg}" key="fav" /></a></li>
                <li><a href="/searchProducts"><fmt:message bundle="${msg}" key="search" /></a></li>
                <li><a href="/webForm"><fmt:message bundle="${msg}" key="webform" /></a></li>
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

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1><fmt:message bundle="${msg}" key="hello" /></h1>
        <p><fmt:message bundle="${msg}" key="jars_presents" /></p>
        <p><fmt:message bundle="${msg}" key="main_page_info" /></p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button"><fmt:message bundle="${msg}" key="learn_more" /></a></p>
      </div>
    </div>

</body>

</html>