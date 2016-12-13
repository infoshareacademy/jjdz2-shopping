<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lista Produktów</title>
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
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li> <a href="#">Home</a></li>
                <li class="active"><a href="#">Products</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<%--Just text container--%>
<div class="container text-center">
    <h3>Wygeneruj listę produktów</h3><br>

    <div>
        <form method="post" action="products">
            Link do Allegro: <input type="text" name="allegroauction"  value="">
            <br />
            <input type="submit" class="btn btn-default btn-lg" value="GO!">
        </form>
    </div>

    <div>
        <form method="post" action="products">
            Link do Ebay: <input type="text" name="ebayauction"  value="">
            <br />
            <input type="submit" class="btn btn-default btn-lg" value="GO!">
        </form>
    </div>

    <!-- lista wygenerowanych produktów -->
    <div>
        <div>Produkty:</div>
        <div>
            <!-- Ebay -->
            <form  method="post" action="products">
                <ul class="list-group">
                    <c:forEach items="${translatedWordsEbay}" var="eb">
                    <li>
                   <div class="checkbox">
                        <label>
                            <input type="checkbox" value="${eb.product}" name="listofebayprod[]">${eb.product}</input>
                        </label>
                    </div>
                    </li>
                    </c:forEach>
                <ul>
                    <!-- Allegro -->
                    <ul class="list-group">
                        <c:forEach items="${translatedWordsAllegro}" var="al">
                        <li>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="${al.product}" name="listofallegroprod[]">${al.product}</input>
                                </label>
                            </div>
                        </li>
                        </c:forEach>
                    <ul>
                <input type="submit" class="btn btn-default btn-lg" value="Start >>">
            </form>


        </div>
    </div>


    <!-- list z bazy danych -->
    </HR>
    <div>
        <c:forEach items="${fullListFromDB}" var="flfDB" varStatus="i">
            <li>
                <div>
                    <label>
                      <!--  ${i.index} -->
                        ${flfDB.id} - ${flfDB.product}

                    </label>
                </div>
            </li>
        </c:forEach>

    </div>


<!--
    ->Cycling
    ->Winter Sports
    ->Board & Traditional Games
    ->Puzzles
    Lista kategorii PL
    ->Rowery i akcesoria
    ->Sprzęt narciarski
    ->Szachy i inne gry planszowe
    ->Krzyżówki, gry i zabawy logiczne

    Link  allegro numer 1 http://allegro.pl/some-cat-16414
    Link  allegro numer 2 http://allegro.pl/some-cat-250626
    Link  allegro numer 3 http://allegro.pl/some-cat-91102
    Link  allegro numer 4 http://allegro.pl/some-cat-91103

    Link ebay numer 1 http://www.ebay.com/sch/Cycling
    Link ebay numer 2 http://www.ebay.com/sch/Winter-Sports
    Link ebay numer 3 http://www.ebay.com/sch/Board-&-Traditional-Games
    Link ebay numer 4 http://www.ebay.com/sch/Puzzles
-->
</div>


</body>

</html>