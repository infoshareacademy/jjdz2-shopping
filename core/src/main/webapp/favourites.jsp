<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/products">Products</a></li>
                <li class="active"><a href="/favourites">Favourites</a></li>
                <li><a href="/searchProducts">Search Products</a></li>
                <li><a href="/webForm"> Web Form</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span class="glyphicon glyphicon-log-in"></span><form action="/adminPanel" method="post">
                    <button type="submit" name="logout" value="logout" class="btn-link">Log out</button>
                </form></li>
            </ul>
        </div>
    </div>
</nav>

<%--Just text container--%>
<div class="container text-center">
    <h3>Ulubione produkty </h3><br>

    <!-- list z bazy danych -->
    </HR>
    <form method="post" action="favourites">
        <ul class="list-group">
            <div>
                <c:forEach items="${fullListFromDB}" var="flfDB" varStatus="i">
                    <li>

                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="${flfDB.url}" name="listofurls">${flfDB.id}</br>
                                - ${flfDB.product} - ${flfDB.url} - ${flfDB.user}</input>
                            </label>
                        </div>

                    </li>
                </c:forEach>

            </div>
        </ul>
        <input type="submit" class="btn btn-default btn-lg" value="Usun >>">
    </form>
</div>

</body>

</html>