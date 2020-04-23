<%--
  Created by IntelliJ IDEA.
  User: randi
  Date: 4/9/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Login</title>
</head>
<body>

<div class="header">
    <h2>Register</h2>
</div>

<form action="/login" method="post">

        <div class="input-group">
            <label>Username</label>
            <input type="text" name="name"  placeholder= "Enter your Name" required="required">
        </div>


        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password"  placeholder= "Enter your Password" required="required">
        </div>

        <div class="input-group">
            <input type="submit" class="btn" value="Login">
        </div>

    <p>
        Not yet a member? <a href="registration.jsp">Sign up</a>
    </p>



</form>

</body>
</html>
