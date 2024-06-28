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
<div align ="center">
 <i><h1>Airport Details</h1></i>
    <table>
        <tr>
        <h1>
            <td>Airport Code:</td>
            <td>${airport.airportCode}</td>
        </tr>
        <tr>
            <td>Airport Location:</td>
            <td>${airport.airportLocation}</td>
        </tr>
        </h1>
    </table>
    <br/><br/>
   <a href="index">Back to Home</a>
</body>
</html>
