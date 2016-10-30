<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Logowanie do systemu</title>
</head>
<body>

<div>
    <h1> Log in </h1>
</div>

<div>
    <div>Jakas tam lista:</div>
    <div>
        <ul>
            <c:forEach items="${lista}" var="item">
                <li> ${item}: </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>

