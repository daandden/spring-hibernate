<%--
  Created by IntelliJ IDEA.
  User: anhvu
  Date: 3/15/2022
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Confirmation</title>
</head>
<body>
    The student is confirmed: ${student.firstName} ${student.lastName}

    <br><br>

    Country: ${student.country}

    <br><br>

    Favorite Language: ${student.favoriteLanguage}

    <br><br>

    Operating Systems:

    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">

            <li> ${temp}</li>

        </c:forEach>
    </ul>

</html>
</body>
