<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC Pattern</title>
</head>
<body>
<h1>MVC Pattern</h1>
<ul>
    <c:forEach items="${items}" var="item">
        <li>${item.representation}</li>
    </c:forEach>
</ul>
</body>
</html>
