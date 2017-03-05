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
                <li class="active"><a href="/products">Products</a></li>
                <li><a href="/favourites">Favourites</a></li>
                <li><a href="/searchProducts">Search Products</a></li>
                <li><a href="/webForm"> Web Form</a></li>
                <li><a href="/report"> Report</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span class="glyphicon glyphicon-log-in"></span>
                    <form action="/adminPanel" method="post">
                        <button type="submit" name="logout" value="logout" class="btn-link">Log out</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--Just text container--%>
<div class="container text-center">
    <h3>Znajdź produkty: </h3><br>

    <div>
        <form method="post" action="products">
            Kategorie dla Allegro: <input type="text" name="allegroauction" value="">
            <br/>
            <input type="submit" class="btn btn-default btn-lg" value="Szukaj">
        </form>
    </div>
    </br> </br>
    <div>
        <form method="post" action="products">
            Kategorie dla Ebay: <input type="text" name="ebayauction" value="">
            <br/>
            <input type="submit" class="btn btn-default btn-lg" value="Szukaj">
        </form>
    </div>
    </br> </br> </br>

    <!-- list z bazy danych -->
    </HR>
    <div>
        <c:forEach items="${fullListFromDB}" var="flfDB" varStatus="i">
            <li>
                <div>
                    <label>
                            ${flfDB.id} - ${flfDB.product} - ${flfDB.url} - ${flfDB.user}

                    </label>
                </div>
            </li>
        </c:forEach>

    </div>
    <!-- lista wygenerowanych produktów -->
    <div>
        <div>Ulubione produkty :</div>
        <div>
            <!-- Ebay -->
            <form method="post" action="products">
                <ul class="list-group">
                    <c:forEach items="${translatedWordsEbay}" var="eb">
                        <li>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="${eb.product}+${eb.url}"
                                           name="listofebayprod">${eb.product}
                                    </br>${eb.url} </input>
                                </label>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <!-- Allegro -->
                <ul class="list-group">
                    <c:forEach items="${translatedWordsAllegro}" var="al">
                        <li>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="${al.product}+${al.url}"
                                           name="listofallegroprod">${al.product}
                                    </br>${al.url} </input>
                                </label>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <input type="submit" class="btn btn-default btn-lg" value="Zapisz >>">
            </form>


        </div>
    </div>


</div>


</body>

</html>