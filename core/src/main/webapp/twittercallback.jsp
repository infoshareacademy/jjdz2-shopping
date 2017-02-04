<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages" var="msg" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Twitter callback</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="Shortcut icon"
          href="http://1.bp.blogspot.com/_qxNvBPirDY4/S6SogyHzSYI/AAAAAAAAACI/1LaUy9AAilc/s320/shopping.jpg"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<div align="center">
    <h1><fmt:message bundle="${msg}" key="hey" />${name}</h1>
    <p> <fmt:message bundle="${msg}" key="twitter_logged_in" /></p>
    <p> Rock 'n' Roll !</p>
</div>

<div align="center"><a href="/" class="btn btn-success btn-lg btn-block"><fmt:message bundle="${msg}" key="go_to_main_page" /></a></div>


</div>


</body>
</html>