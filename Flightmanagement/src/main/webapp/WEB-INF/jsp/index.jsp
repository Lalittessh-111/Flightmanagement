<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Management System</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-image: url('https://assets.telegraphindia.com/telegraph/2020/Jul/1595972233_1594320268_shutterstock_699697081.jpg');
        background-size: cover;
        background-repeat: no-repeat;
    }
    .header {
        background-color: #333;
        color: #fff;
        padding: 15px;
        text-align: left;
    }
    .nav {
        display: flex;
        justify-content: flex-start;
        background-color: #444;
        padding: 10px 15px;
    }
    .nav a {
        color: white;
        padding: 10px;
        text-decoration: none;
        text-align: center;
    }
    .nav a:hover {
        background-color: #555;
    }
    .dropdown {
        position: relative;
        display: inline-block;
        margin-top: 10px;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #444;
        min-width: 160px;
        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
        z-index: 1;
    }
    .dropdown-content a {
        color: white;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }
    .dropdown-content a:hover {
        background-color: red;
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
    .dropdown:hover .dropbtn {
        background-color: red;
    }
    .content {
        padding: 20px;
        text-align: center;
    }
    #h11 {
        text-align: center;
        color: #fff;
        text-shadow: 2px 2px 4px #000000;
    }
</style>
</head>
<body>
    <div class="content">
        <h1 id="h11">Welcome to the Flight Management System</h1>
    </div>
   
    <div class="nav">
        <div class="dropdown">
            <a href="#" class="dropbtn">Airport</a>
            <div class="dropdown-content">
                <a href="/airport">Add Airport</a>
                <a href="/airportShow">View Airports</a>
            </div>
        </div>
        
        <div class="dropdown">
            <a href="#" class="dropbtn">Flight</a>
            <div class="dropdown-content">
                <a href="/addFlight">Add Flight</a>
                <a href="/viewFlights">View Flights</a>
            </div>
        </div>
        
        <div class="dropdown">
            <a href="#" class="dropbtn">Route</a>
            <div class="dropdown-content">
                <a href="/addRoute">Add Route</a>
                <a href="/viewRoutes">View Routes</a>
            </div>
        </div>
        
        <a href="/loginPage">Logout</a>
    </div>

</body>
</html>

