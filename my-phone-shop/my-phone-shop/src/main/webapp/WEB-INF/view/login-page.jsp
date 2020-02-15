<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 15.02.2020
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/component/header.jsp" %>
<div><h1>Formularz logowania</h1></div>
<c:if test="${invalidCredentials}">
    <p style="color: red">Niepoprawny login lub hasło</p>
</c:if>
<form action="/authorization" method="post">
    <label for="login">login</label>
    <input type="text" name="login" id="login">

    <label for="password">hasło</label>
    <input type="password" name="password" id="password">
    <button type="submit" class="btn btn-primary">Zaloguj</button>
</form>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
