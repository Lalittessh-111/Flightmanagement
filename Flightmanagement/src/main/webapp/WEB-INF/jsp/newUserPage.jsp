<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image:linear-gradient(45deg, red, blue);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        text-align: center;
        color: black;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 20px 20px 10px rgba(0, 0, 0, 0.3), -3px -3px 5px rgba(255, 255, 255, 0.5);
        
        
    }
    header {
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 20px;
    }
    label {
        font-size: 18px;
        margin-bottom: 5px;
        display: block;
    }
    input[type="text"], input[type="password"]{
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
       
    }
   input::placeholder{
       text-align:center;
   }
    button {
        padding: 10px 20px;
        font-size: 15px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
    footer {
        margin-top: 20px;
        font-size: 14px;
    }
    #reg {
         background-image: url("https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExeXpjNnEyeHp6d283Y3BxcjdhOGxhcXBqNGFqYmpyODRlangwNDR2cCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/xuvvmV1xza1YMCnzlG/giphy.webp");
         
         background-repeat:no-repeat;
         background-position: center;
         background-size:cover;
    }
    #email{
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    #user_type{
        width: 80%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        text-align:center;
    }
    a:hover{
    color:red;
    }  
</style>
</head>

<body>

<div class="container" id="reg">
    <header>Flight Reservation System</header>

    <h2>Create New Account</h2>

<form:form action="/register" method="post">
  <label for="username"> </label>
  <input type="text" id="username" name="username" required placeholder="Enter Username">

  <label for="email"> </label>
  <input type="email" id="email" name="email" required placeholder="Enter Email">

  <label for="password"> </label>
  <input type="password" id="password" name="password" required placeholder="Enter Password">

  <label for="confirm_password"> </label>
  <input type="password" id="confirm_password" name="confirm_password" required placeholder="Confirm password">
  
<div id="usertype">
<select id="user_type" name="user_type" required>
  <option value="" disabled selected>USER TYPE</option>
  <option value="customer">Customer</option>
  <option value="admin">Admin</option>
</select>
</div>
  <button type="submit">Register</button>
  <button type="submit">Login</button>
   <p>Already had an account? <a href="/loginPage" id="sign">SignIn</a></p>
  
</form:form>

    <footer>Flight Reservation System 2024</footer>
</div>
</body>
</html>
