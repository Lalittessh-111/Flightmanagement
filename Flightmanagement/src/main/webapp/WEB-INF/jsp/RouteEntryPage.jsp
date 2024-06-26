<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 50px;
    }
    form {
        width: 300px;
        margin: 0 auto;
    }
    div {
        margin-bottom: 10px;
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }
    input[type="submit"], button {
        padding: 10px 15px;
        margin-top: 10px;
    }
</style>
</head>
<body>

<h2>Travel Form</h2>

<form:form action="/Route" modelAttribute="travelForm">
    <div>
        <label for="sourceCity">Enter Source City:</label>
        <form:input path="sourceCity" id="sourceCity" />
    </div>
    <div>
        <label for="destinationCity">Enter Destination City:</label>
        <form:input path="destinationCity" id="destinationCity" />
    </div>
    <div>
        <input type="submit" value="Submit" />
        <button type="button" onclick="/index">Return</button>
    </div>
</form:form>

</body>
</html>
