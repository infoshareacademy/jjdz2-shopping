<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>
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
<img src="http://imgc.allpostersimages.com/images/P-473-488-90/30/3058/ZK6DF00Z/posters/lantern-press-howdy-podner-smoking-cowboy-greetings.jpg"
     align="right">
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="/">Home</a></li>
    <li role="presentation"><form action="/adminPanel" method="post">
        <button type="submit" name="logout" value="logout" class="btn-link">Log out</button>
    </form></li>
    <li role="presentation"><a href="#">Remove Admins privileges </a></li>
</ul>
<div>
    <h1> Hiya! ${login}</h1>
    <h2> I guess you're an admin so here's the list of all users with their password and all</h2>
    <h3> How cool is that?! </h3>
</div>

<div>
    <div>
        <p>

        </p>
    </div>
</div>

<div class="alert alert-danger">
    <!-- Ebay -->
    <form action="/adminPanel" method="POST">
        <ul class="list-group" a>
            <c:forEach items="${userlist}" var="users">
                <li class="list-group-item">
                    <c:if test="${users.admin}">
                        <span class="badge">Admin</span>
                    </c:if>
                    <div class="checkbox">
                        <input type="checkbox" value="${users.login}" name="newAdmins">${users.login}</input>
                    </div>
                    <div>
                        <p type="text" value="${users.password}" name="passwdlist"> ${users.password}</p>
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


</body>
</html>

