<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 09.02.2020
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <title>Koszyk</title>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
</head>
<body>
<fmt:setLocale value="pl_PL"/>
<%@ include file="/WEB-INF/component/header.jsp" %>

<div class="container">
    <c:forEach items="${cart}" var="product">

        <div class="row">
            <div class="col-md-2"><img src="${product.imagePath}" width="67" height="86"/></div>
            <div class="col-md-5"><h3> ${product.brand} ${product.model}</h3></div>
            <div class="col-md-2"> <fmt:formatNumber type="currency"
                                                                                   minFractionDigits="2">
                ${product.price}</fmt:formatNumber></div>
            <div class="col-md-1">
                <form action="/remove-from-cart" method="post">
                    <button type="submit" class="btn btn-primary" name="id" value="${product.id}">Usuń</button>
                </form>
            </div>
            <div class="col-md-2"></div>
        </div>
    </c:forEach>

    <div class="row">
       <h3 align="right">
            <fmt:formatNumber type="currency" minFractionDigits="2">
                ${totalValue}</fmt:formatNumber></h3>
    </div>


</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
