<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Raport z serwera API</title>
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
                <li><a href="/favourites">Favourites</a></li>
                <li><a href="/searchProducts">Search Products</a></li>
                <li><a href="/webForm"> Web Form</a></li>
                <li class="active"><a href="/report"> Report</a></li>
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

    <div>Get report from report server:</div>
    <div>
        <!-- Ebay -->
        <form method="post" action="products">
            <table>
                <tr>
                    <td><p>Set start Date (yyyy-mm-dd)</p>
                        <input type="date" name="startDate"
                               pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"/>
                    </td>


                    <td><p>Set end Date (yyyy-mm-dd)</p>
                        <input type="date" name="endDate"
                               pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"/>
                    </td>
                </tr>
            </table>

            <input type="submit" class="btn btn-default btn-lg" value="Report >>">
        </form>


    </div>


    <!-- list z bazy danych -->
    </HR>
    <form method="post" action="favourites">
        <ul class="list-group">
            <div>
                <c:forEach items="${usersToPrint}" var="usersToP" varStatus="i">
                    <li>

                        <div class="checkbox">
                            <label>
                                    ${usersToP.id} - ${usersToP.username} - ${usersToP.date}
                            </label>
                        </div>

                    </li>
                </c:forEach>

            </div>
        </ul>

    </form>

    <!-- list z bazy danych -->
    </HR>
    <form method="post" action="favourites">
        <ul class="list-group">
            <div>
                <c:forEach items="${userDataForGUIs}" var="userDataGUI" varStatus="i">
                    <li>

                        <div class="checkbox">
                            <label>
                                    ${userDataGUI.id} - ${userDataGUI.username} - ${userDataGUI.date}
                            </label>
                        </div>

                    </li>
                </c:forEach>

            </div>
        </ul>

    </form>

</div>


</body>

</html>