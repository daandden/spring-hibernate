<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Save Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <%--need to associate this data with customer id--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                    <tr>
                        <td><label for="firstName">First name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>

                    <tr>
                        <td><label for="lastName">Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>

                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td><form:input path="email"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>

        </form:form>

        <div style="clear; both;"></div>
        
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>

</body>
</html>