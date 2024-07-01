<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Flight Record</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    h3 {
        color: #333;
    }

    table {
        margin: 20px auto;
        border-collapse: collapse;
    }

    td {
        padding: 10px;
        text-align: left;
    }

    input[type="text"], input[type="number"], input[type="datetime-local"], form:input {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    button {
        margin: 10px 5px;
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button[type="reset"] {
        background-color: #dc3545;
    }

    button:hover {
        opacity: 0.8;
    }

    a {
        display: inline-block;
        margin: 20px auto;
        padding: 10px 20px;
        text-decoration: none;
        color: #fff;
        background-color: #28a745;
        border-radius: 5px;
    }

    a:hover {
        background-color: #218838;
    }
</style>
</head>
<body>

<div align="center">
<h3>
<form:form action="/flight" method="post" modelAttribute="FlightRecord">
<table>
<tr>
<td>Enter Flight ID :</td>
<td><input path="flightNumber" type="text" /></td>
</tr>

<tr>
<td>Enter Airlines Name :</td>
<td><input  type="text" /></td>
</tr>

<tr>
<td>Select Route ID :</td>
<td><input path="routeId" list="routes" type="text" /></td>
</tr>

<datalist id="routes">
<c:forEach items="${routeList}" var="route">
<option value="${route}"></option>
</c:forEach>
</datalist>

<tr>
<td>Enter Seat Capacity :</td>
<td><input  type="text" /></td>
</tr>

<tr>
<td>Enter Departure Time :</td>
<td><input type="text" /></td>
</tr>

<tr>
<td>Enter Arrival Time :</td>
<td><input type="text" name="Arrival" /></td>
</tr>

<tr>
<td>Enter Return Flight Departure Time:</td>
<td><input type="text" name="dtime" /></td>
</tr>

<tr>
<td>Enter Return Flight Arrival Time:</td>
<td><input type="text" name="atime" /></td>
</tr>

</table>   
<div class="button-container">
<button type="submit">Submit</button>
<button type="reset">Reset</button>
</div>
</form:form>
</h3>
<a href="index">Back to Home</a>
</div>

</body>
</html>
