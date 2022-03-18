<%--
  Created by IntelliJ IDEA.
  User: anhvu
  Date: 3/15/2022
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName"/>

        <br><br>

        Last name: <form:input path="lastName"/>

        <br><br>

        Country:

        <form:select path="country">

            <%-- <form:options items="${student.countryOptions}"/> --%>
            <form:options items="${theCountryOptions}"/>
        </form:select>

        <br><br>

        Favorite Language:

        <%--Java <form:radiobutton path="favoriteLanguage" value="Java" />--%>
        <%--C# <form:radiobutton path="favoriteLanguage" value="C#" />--%>
        <%--PHP <form:radiobutton path="favoriteLanguage" value="PHP" />--%>
        <%--Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />--%>
        <form:radiobuttons path="favoriteLanguageOptions" items="${student.favoriteLanguageOptions}"/>

        <br><br>

        Operating Systems:
        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
        MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>

        <br><br>


        <input type="submit" value="Submit">

    </form:form>
</body>
</html>
