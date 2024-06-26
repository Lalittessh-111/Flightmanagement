<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airport</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 400px;
    }
    h2 {
        margin-bottom: 20px;
        text-align: center;
    }
    .form-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"] {
        width: calc(100% - 16px); /* Adjust for padding */
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .buttons {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
    }
    button {
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
        font-size: 16px;
    }
    button[type="button"] {
        background-color: #6c757d;
    }
    button:hover {
        opacity: 0.9;
    }
    .success-message {
        color: green;
        text-align: center;
        margin-top: 10px;
        display: none;
    }
</style>
</head>
<body align="center"> 
 <div class="container"> 
 <h2><b>Enter New Airport</b></h2>
<form:form action="/airport" method="post" modelAttribute="airportRecord">
<table>
<tr> 
 <td>Enter AirportCode:</td><td><form:input path="airportCode" required="required"/></td></tr>  
 
 <tr><td>Enter AirportLocation:</td><td><form:input path="airportLocation" required="required"/></td></tr> 
  
 </table>
 <button type="submit">Add</button>
</form:form>
 
<a href="index">Return</a>
  </div>
 </body>
</html>
