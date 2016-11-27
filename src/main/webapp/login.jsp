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

    <form method="post" action="createUser">
        login   : <input type="text" name="username">
        password: <input type="password" name="password">
        <input type="submit" value="login">
        <input type="submit" value="createUser">
    </form>

    <a href = "/twitter"> TWITTER</a>
    <a href = "/facebook">FACEBOOK</a>
</div>


</body>
</html>

