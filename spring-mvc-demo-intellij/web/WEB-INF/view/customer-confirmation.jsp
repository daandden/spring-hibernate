<%--
  Created by IntelliJ IDEA.
  User: anhvu
  Date: 3/17/2022
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Confirmation</title>
</head>
<body>
    The customer is confirmed: ${customer.firstName} ${customer.lastName}

    <br><br>

    Free passes: ${customer.freePasses}

    <br><br>

    Postal Code: ${customer.postalCode}

    <br><br>

    Course Code: ${customer.courseCode}

</body>
</html>
