<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Routes</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 50px;
    }
    .table-container {
        text-align: center;
        margin: 20px auto;
        width: 60%;
        border: 1px solid #000;
        padding: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        padding: 10px;
        border: 1px solid #000;
    }
    th {
        background-color: #f2f2f2;
    }
    button {
        padding: 10px 15px;
        cursor: pointer;
    }
</style>
</head>
<body>

<div class="table-container">
    <h2>All Routes</h2>
    <br/>
    <table>
            <tr>
                <th>Route Number</th>
                <th>Source Airport Code</th>
                <th>Target Airport Code</th>
                <th>RouteFair</th>
            </tr>
			<c:forEach items="${Acc}" var="route">
 				<tr>
 				<td>${route.routeId}</td>
                <td>${route.sourceAirportCode}</td>
                <td>${route.destinationAirportCode}</td>
                <td>${route.fair}</td>
                </tr>
                </c:forEach>
    </table>
    <br/><br/>
    <a href="/index">Return</a>
</div>

</body>
</html>
