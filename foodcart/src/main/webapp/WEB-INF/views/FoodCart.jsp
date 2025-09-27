<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Cart</title>
</head>
<body>
    <h2>Food Items:</h2>
    <ul>
        <c:forEach var="item" items="${foodItems}">
            <li>${item}</li>
        </c:forEach>
    </ul>
    <p><a href="${pageContext.request.contextPath}/">Back to Home</a></p>
</body>
</html>
