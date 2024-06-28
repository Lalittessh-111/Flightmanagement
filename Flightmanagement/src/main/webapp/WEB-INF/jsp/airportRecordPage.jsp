<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Airports</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    .container {
        background-color: #fff;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        margin-bottom: 20px;
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #ccc;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f4f4f4;
    }
    a {
        text-decoration: none;
        display: block;
        text-align: center;
        margin-top: 10px;
        color: #007bff;
    }
</style>
</head>
<body>
<div align="center">
<h1><u><i>All Airports</i></u></h1>
<br/>
<table>
<tr>
<th>Airport Code</th>
<th>Airport Location</th>
<th>Enquire</th>
</tr>
<c:forEach items="${abc}" var="airport">
<tr>
<td>${airport.airportCode}</td>
<td>${airport.airportLocation}</td>
<td><a href="/airport/${airport.airportCode}">Enquire</a></td>
</tr>
</c:forEach>

</table>
<br/><br/>
<a href="/index">Return</a>
</h3>
</div>
</body>
</html>
