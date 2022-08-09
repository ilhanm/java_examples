<%--
  Created by IntelliJ IDEA.
  User: ilhan
  Date: 9.08.2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
    First name: <form:input path="firstName" />
    <br><br>
    Last name (*): <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error"/>

    <input type="submit" value="Submit Now" />

</form:form>
</body>
</html>
