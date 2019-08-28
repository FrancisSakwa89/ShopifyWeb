<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/28/19
  Time: 7:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <link href ="./js/main.js"  rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <title>Update Customer</title>
</head>
<body>
<div class="container">
<form action="update-customer" method="post">
    <div class="group">
        <input type="text" required name="userId">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Customer UserId</label>
    </div>

    <div class="group">
        <input type="text" required name="name">
        <span class="highlight"></span>
        <span class="bar"></span>
        <label>Name</label>
    </div>


    <button class="btn btn-outline-dark" type="submit">Update</button>
    <button class="btn btn-dark" type="reset">Reset</button>

</form>
</div>
</body>
</html>
