<%--
  Created by IntelliJ IDEA.
  User: godfrey
  Date: 9/4/2025 AD
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="quest.css?<%= System.currentTimeMillis() %>">
    <title>Servlet Quest</title>
</head>
<body>
<section>
    <a href="./index.jsp">Start over</a>
    <h3>${question.content}</h3>
    <form action="${question.type == 'LOST' || question.type == 'WON' ? 'index.jsp' : 'quest'}" method="get">
        <c:forEach items="${answers}" var="answer">
            <input type="radio" name="answerId" value="${answer.id}">${answer.content}<br>
        </c:forEach>
        <button type="submit">${question.type == 'LOST' || question.type == 'WON' ? 'Play again' : 'Answer'}</button>
    </form>
</section>
<br>
<hr>
<br>
<table>
    <tr>
        <th>Statistics:</th>
    </tr>
    <tr>
        <td>IP address:</td>
        <td><i>${ip}</i></td>
    </tr>
    <tr>
        <td>Name in game:</td>
        <td><i>${name}</i></td>
    </tr>
    <tr>
        <td>Attempts:</td>
        <td><i>${attempt}</i></td>
    </tr>
</table>
</body>
</html>
