<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <table>
        <thead>
            <tr>
                <th>Route Number</th>
                <th>Source Airport Code</th>
                <th>Target Airport Code</th>
                <th>Route Fair</th>
            </tr>
        </thead>
        <tbody>
            <!-- Sample data rows, replace with dynamic data as needed -->
            <tr>
                <td>1</td>
                <td>JFK</td>
                <td>LAX</td>
            </tr>
            <tr>
                <td>2</td>
                <td>ATL</td>
                <td>ORD</td>
            </tr>
            <tr>
                <td>3</td>
                <td>SFO</td>
                <td>SEA</td>
            </tr>
        </tbody>
    </table>
    <button type="button" onclick="/index">Return</button>
</div>

</body>
</html>
