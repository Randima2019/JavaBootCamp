<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: randi
  Date: 4/15/2020
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">


    <style>


        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 75%;
            margin: 50px auto 0px;
        }

        #customers td, #customers th {
            margin-top: 5px;
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {

            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color:#bb8fce;
            color: white;
        }


    </style>
</head>



<body>
<div class="header">
    <h2>Home Page</h2>
</div>
<%
    String id = request.getParameter("id");
    String driverName= "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName= "location";
    String userId= "root";
    String password= "";

    try{
        Class.forName(driverName);

    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet =  null;
%>


<% String username = request.getParameter("name"); %>
<center> <a> Welcome  <% out.println(username); %> User!!!! You have logged in.</a></center>
<center><a href="login.jsp"><b>Logout</b></a></center><br><br>


<table id="customers">
    <tr>
        <th>id</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Name</th>
    </tr>

    <%
        try{
            connection= DriverManager.getConnection(connectionUrl+dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM registration";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
    %>
    <tr>

        <td><%=resultSet.getString("id")%></td>
        <td><%=resultSet.getString("latitude")%></td>
        <td><%=resultSet.getString("longitude")%></td>
        <td><%=resultSet.getString("name")%></td>

    </tr>
    <%
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    %>
</table>
<br>

<div class="header">
    <h2>Calculate Distance</h2>
</div>
<form action="/home" method="post">

    <div class="input-group1">
        <label>Enter Your Location</label>
        <input type="Float" name="latitude1"  placeholder= "latitude">
    </div>

    <div class="input-group1">
        <input type="Float" name="longitude1"  placeholder= "longitude">
    </div>


    <div class="input-group1">
        <label>Enter another Location</label>
        <input type="Float" name="latitude2"  placeholder= "latitude">
    </div>

    <div class="input-group1">
        <input type="Float" name="longitude2"  placeholder= "longitude">
    </div>


    <div class="input-group1">
        <input type="submit" class="btn" value="calculate">
    </div>

</form>



</body>
</html>
