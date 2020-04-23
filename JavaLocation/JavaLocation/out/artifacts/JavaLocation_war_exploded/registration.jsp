<%--
  Created by IntelliJ IDEA.
  User: randi
  Date: 4/8/2020
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<p align="center">Get Your Location</p>

<div class="input-group">
    <center><button onclick="getLocation()" class ="btn3" >Location</button></center>
</div>

<p id="demo"></p>

<script>

    var x = document.getElementById("demo");

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            x.innerHTML = "Geolocation is not supported by this browser.";
        }
    }

    function showPosition(position) {
        x.innerHTML = "Latitude: " + position.coords.latitude +
            "<br>Longitude: " + position.coords.longitude;
    }
</script>




<div class="header">
    <h2>Register</h2>
</div>

    <form action="/registration" method="post">

        <div class="input-group">
            <label>Location</label>
            <input type="text" name="latitude" placeholder= "Enter your latitude" required="required">

            <div class="input-group">
                <input type="text" name="longitude" placeholder= "Enter your longitude" required="required">

                <div class="input-group">
                    <label>Username</label>
                    <input type="text" name="name"  placeholder= "Enter your Name" required="required">
                </div>

            </div>
            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password"  placeholder= "Enter your Password" required="required">
            </div>

            <div class="input-group">
                <input type="submit" class="btn" value="Register">
            </div>
        </div>
        </div>

        <p>
            Already you have a member? <a href="login.jsp">Sign in</a>
        </p>
    </form>

</body>
</html>
