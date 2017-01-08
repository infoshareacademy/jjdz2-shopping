<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>SearchProducts</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="Shortcut icon" href="http://1.bp.blogspot.com/_qxNvBPirDY4/S6SogyHzSYI/AAAAAAAAACI/1LaUy9AAilc/s320/shopping.jpg" />
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
            <a class="navbar-brand" href="/">Home</a>
            <a class="navbar-brand" href="/products">Products</a>
            <a class="navbar-brand" href="/favourites">Favourite</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/webForm">Questionnaire</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<form method="post" action="/searchProducts">
    <table class="item-table">
        <div class="container-fluid bg-2 text-center">
        <div class="col-sm-6">
    <div>
    <select id="serviceId" name="serviceId">
        <option value="1">Ebay</option>
        <option value="2">Allegro</option>
    </select>
    <input id="list" name="list" type="text"/>

    </div>

<script>
    $(function () {
        $("#list").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "/productList",
                    data: {
                        term: request.term,
                        serviceId: $("#serviceId").val()
                    },
                    success: function( data ) {
                        response( data );
                    }
                });
            },
            select: function(e, ui) {
                console.log(e);
                console.log(ui);
            },
            minLength: 3

        });
    });
</script>

            <%--<script>--%>
                <%--$(document).ready(function () {--%>
                    <%--$('#list').on('autocompletechange change', function () {--%>
                        <%--$('#list').html('You selected: ' + this.value);--%>
                    <%--}).change();--%>
                <%--});--%>
            <%--</script>--%>
        </div>
        </div>
    </table>
</form>

</body>
</html>
