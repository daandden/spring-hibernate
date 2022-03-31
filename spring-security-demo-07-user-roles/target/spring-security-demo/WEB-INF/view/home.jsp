<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>luv2code Company Home Page</title>
</head>
<body>
    <h2>luv2code Company Home Page - Yoohooasdfasd!!!</h2>
    <hr>
    <p>
        Welcome to the luv2code company
    </p>

    <%--display user name and role--%>

    <hr>
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <hr>
    <security:authorize access="hasRole('MANAGER')">
        <%--Add a link to point to /leaders ... this is fore the managers--%>

        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for Manager peeps)
        </p>

    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <%--Add a link to point to /systems ... this is for the admins--%>
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Systems meeting</a>
            (Only for Admin peeps)
        </p>
    </security:authorize>

    <hr>

    <%--Add a logout button--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout"/>
    </form:form>
</body>
</html>
