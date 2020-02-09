<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">

    <title>SDA shop</title>
</head>
<body>
<%@include file="/WEB-INF/component/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">Tutaj będzie filtr</div>
        <div class="col-md-10 offset-md-2 content">
            <c:forEach items="${productsList}" var="product">
                <div class="row">
                    <div class="col-md-2"><img src="${product.imagePath}" width="134" height="192"/></div>
                    <div class="col-md-5">
                        <h3><a href="/show-product?id=${product.id}" style="color: #b6b8b6">${product.brand} ${product.model}</a></h3>
                        <h6>System operacyjny: ${product.operatingSystem}</h6>
                        <h6>Przednia kamera: ${product.primaryCameraMp}</h6>
                        <h6>Tylna kamera: ${product.secondaryCameraMp}</h6>
                    </div>
                    <fmt:setLocale value="pl_PL"/>
                    <div class="col-md-3"><fmt:formatNumber type="currency" minFractionDigits="2">
                        ${product.price}</fmt:formatNumber>
                        <form action="/add-to-cart" method="post">
                            <button type="submit" class="btn btn-primary" name="id" value="${product.id}">Do koszyka</button>
                        </form>
                        <form action="" method="post">
                            <button type="button" class="btn btn-primary">Kup teraz</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
