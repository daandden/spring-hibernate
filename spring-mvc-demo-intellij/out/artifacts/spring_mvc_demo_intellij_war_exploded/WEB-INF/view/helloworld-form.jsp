<%--
  Created by IntelliJ IDEA.
  User: anhvu
  Date: 3/15/2022
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello World - Input Form</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/processFormVersionThree" method="get">
        <input type="text" name="studentName" placeholder="What's your name?"/>
        <input type="submit">
    </form>
</body>
</html>
