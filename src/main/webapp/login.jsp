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
    <div>
        <p>
            ${welcome}
        </p>
    </div>
</div>

<div>
    <form method="post" action="translate">
        login: <input type="text" name="login">
    </form>
    <form method="post" action="translate">
        password: <input type="password" name="password">
        <input type="submit" value="login">
    </form>

    <a href = "/twitter"> TWITTER</a>
</div>


</body>
</html>

