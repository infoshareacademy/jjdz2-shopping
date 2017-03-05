<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="messages" var="msg" />

<!DOCTYPE html>
<html lang="en">
<head>Panel Administratora</title>
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
                <li class="active"><a href="/login">Login</a></li>
                <li><a href="/"><fmt:message bundle="${msg}" key="home" /></a></li>
                <li><a href="/products"><fmt:message bundle="${msg}" key="products" /></a></li>
                <li><a href="/favourites"><fmt:message bundle="${msg}" key="fav" /></a></li>
                <li><a href="/searchProducts"><fmt:message bundle="${msg}" key="search" /></a></li>
                <li><a href="/webForm"><fmt:message bundle="${msg}" key="webform" /></a></li>
                <li><a href="/report"> Report</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><span class="glyphicon glyphicon-log-in"></span>
                    <form action="/adminPanel" method="post">
                        <button type="submit" name="logout" value="logout" class="btn-link">Log out</button>
                    </form>
                </li>
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

    <div>
        <img height="150" width="150" class="img-circle"
             src="http://imgc.allpostersimages.com/images/P-473-488-90/30/3058/ZK6DF00Z/posters/lantern-press-howdy-podner-smoking-cowboy-greetings.jpg"
             align="right">
        <h1> Hiya! <b>${login}</b></h1>
        <h2><fmt:message bundle="${msg}" key="admin_info_1" /></a></h2>
        <h3><fmt:message bundle="${msg}" key="admin_info_2" /></a></h3>
    </div>


    <div class="alert alert-danger">
        <!-- Ebay -->
        <form action="/adminPanel" method="POST">
            <ul class="list-group" a>
                <c:forEach items="${userlist}" var="users">
                    <li class="list-group-item">
                        <div class="checkbox">
                            <p type="text">
                                <input type="checkbox" value="${users.login}" name="newAdmins">${users.login}</input>
                                / ${users.password}
                                <c:if test="${users.admin}"><span class="badge">Admin</span></c:if>
                            </p>
                        </div>
                        <div>
                            <p type="text" value="${users.cameFrom}" name="cameFrom"> ${users.cameFrom}</p>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <input class="btn btn-primary btn-lg" type="submit" name="action" value="addPrivileges">

            <input class="btn btn-danger btn-lg" type="submit" name="action" value="removePrivileges">

        </form>


    </div>
</div>


    <div align="center">
<p> Send reports to</p>
        <form method="post" action="emailSending">
            e-mail   : <input type="text" name="email" value="${param.email}">
            topic    : <input type="text" name="topic" value="${param.topic}">
            every    : <input type="text" name="every" value="${param.everyXhours}"> hours(s)
            <div align="center">
                <button class="btn-success" type="submit" formmethod="post" formaction="http://localhost:8081/EmailServlet"> Start sending report </button>
            </div>
        </form>
    </div>


</div>

</body>

</html>