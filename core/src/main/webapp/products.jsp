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
                <li><a href="/"><fmt:message bundle="${msg}" key="home" /></a></li>
                <li class="active"><a href="/products"><fmt:message bundle="${msg}" key="products" /></a></li>
                <li><a href="/favourites"><fmt:message bundle="${msg}" key="fav" /></a></li>
                <li><a href="/searchProducts"><fmt:message bundle="${msg}" key="search" /></a></li>
                <li><a href="/webForm"><fmt:message bundle="${msg}" key="webform" /></a></li>
                <li><a href="/report"> Report</a></li>
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
    <h3><fmt:message bundle="${msg}" key="find_products" /></h3><br>

    <div>
        <form method="post" action="products">
            <fmt:message bundle="${msg}" key="allegro_categories" /> <input type="text" name="allegroauction"  value="">
            <br />
            <input type="submit" class="btn btn-default btn-lg" value=<fmt:message bundle="${msg}" key="search_button" />>
        </form>
    </div>
    </br> </br>
    <div>
        <form method="post" action="products">
            <fmt:message bundle="${msg}" key="ebay_categories" /> <input type="text" name="ebayauction"  value="">
            <br />
            <input type="submit" class="btn btn-default btn-lg" value=<fmt:message bundle="${msg}" key="search_button" />>
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
        <div><fmt:message bundle="${msg}" key="fav_products" /></div>
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
                <input type="submit" class="btn btn-default btn-lg" value=<fmt:message bundle="${msg}" key="save" />>
            </form>


        </div>
    </div>


</div>


</body>

</html>