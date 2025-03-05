<%@ page import="JavaBean.Person" %>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body>
<h2>Hello World!</h2>
<p>The local time is <%=request.getAttribute("time")%>
</p>

<!--- Expression language --->
<p>Name: <c:out value="${person.name}"/><br></p>
<p>Age: <c:out value="${person.age}"/><br></p>
<p>Gender: <c:out value="${person.gender}"/><br></p>
<p>Address: <c:out value="${person.address}"/><br></p>
<p>Phone: <c:out value="${person.phone}"/><br></p>
<p>Email: <c:out value="${person.email}"/><br></p>
<p>
    <c:choose>
        <c:when test="${person.gender == 'Male'}">
            <c:out value="He is a man"/>
        </c:when>
        <c:when test="${person.gender == 'female'}">
            <c:out value="She is a woman"/>
        </c:when>
        <c:otherwise>
            <c:out value="He is a man"/>
        </c:otherwise>
    </c:choose>
</p>
<p>
    <c:import url="https://www.citefast.com/?s=APA7#_Webpage" var="cite"/>
    <c:out value="${cite}"/>
</p>
</body>
</html>
