<%--
  Created by IntelliJ IDEA.
  User: Marcin
  Date: 16.02.2020
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">

    <title>Title</title>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Category</th>
        <th scope="col">Creation Date</th>
        <th scope="col">Deadline</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="counter" value="1"/>
    <c:forEach items="${tasks}" var="task">
        <tr ${task.done?'style="background-color: lightgreen"':""}>
            <th scope="row">${counter}</th>
            <td> ${task.title}</td>
            <td> ${task.category}</td>
            <td> ${task.creationDate}</td>
            <td> ${task.deadline}</td>
            <td> ${task.description}</td>
        </tr>
        <c:set var="counter" value="${counter+1}"/>
    </c:forEach>
    </tbody>
</table>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
