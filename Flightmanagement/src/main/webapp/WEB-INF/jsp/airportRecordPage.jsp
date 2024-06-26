<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Booking</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .form-container div {
            margin-bottom: 15px;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-container input[type="text"],
        .form-container input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button[type="submit"] {
            background-color: #4CAF50;
            color: white;
        }
        .form-container button[type="button"] {
            background-color: #f44336;
            color: white;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Flight Booking Form</h2>
    <form:form action="/airports" method="post" modelAttribute="flight">
        <div>
            <label for="flightNumber">Flight Number:</label>
            <form:input type="text" id="flightNumber" path="flightNumber" />
        </div>
        <div>
            <label for="airline">Airline:</label>
            <form:input type="text" id="airline" path="airline" />
        </div>
        <div>
            <label for="seatCapacity">Seat Capacity:</label>
            <form:input type="number" id="seatCapacity" path="seatCapacity" />
        </div>
        <div>
            <button type="submit">Submit</button>
            <a href="/index">Return</a>
        </div>
    </form:form>
</div>

</body>
</html>
