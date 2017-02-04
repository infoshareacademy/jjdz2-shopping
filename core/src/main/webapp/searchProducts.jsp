<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setBundle basename="messages" var="msg" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>SearchProducts</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="Shortcut icon"
          href="http://1.bp.blogspot.com/_qxNvBPirDY4/S6SogyHzSYI/AAAAAAAAACI/1LaUy9AAilc/s320/shopping.jpg"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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

<%--Navbar--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/"><fmt:message bundle="${msg}" key="home" /></a></li>
                <li><a href="/products"><fmt:message bundle="${msg}" key="products" /></a></li>
                <li><a href="/favourites"><fmt:message bundle="${msg}" key="fav" /></a></li>
                <li class="active"><a href="/searchProducts"><fmt:message bundle="${msg}" key="search" /></a></li>
                <li><a href="/webForm"><fmt:message bundle="${msg}" key="webform" /></li>
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

<div class="container text-center">
    <h3><fmt:message bundle="${msg}" key="step" /></h3><br>
</div>

<form method="post" action="/searchProducts">
    <table class="item-table">
        <div class="container-fluid bg-2 text-center">
            <div class="col-sm-6">
                <div>
                    <select id="serviceId" name="serviceId">
                        <option value="ebay">Ebay</option>
                        <option value="allegro">Allegro</option>
                    </select>
                    <input id="list" name="list" type="text"/>

                </div>
            </div>
        </div>
    </table>
</form>

<div class="container-fluid bg-2 text-center">
    <div id="link" class="col-sm-6">
        AAAAAAAaaaaaaaaaaaaaaaa
    </div>
</div>

<script>
    $(function () {
        var serviceSelect = $("#serviceId");
        $("#list").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "/productList",
                    data: {
                        term: request.term,
                        serviceId: serviceSelect.val()
                    },
                    success: function( data ) {
                        response( data );
                    }
                });
            },
            select: function(e, ui) {
                $.ajax({
                    url: '/UrlOutputServlet',
                    data: {
                        productName: ui.item.value,
                        serviceId: serviceSelect.val()
                    },
                    success: function(data) {
                        console.log(data);
                        $("#link").html("Item link: <a href=" + data + ">" + data + "</a>");
                    }
                });
            },
            minLength: 3
        });
    });
</script>

</body>
</html>
