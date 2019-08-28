<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/28/19
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <link href ="./js/main.js"  rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Delete Product</title>
</head>
<body>
<div class="container">
    <form action="delete-product" method="post">
        <div class="group">
            <input type="text" required name="productId">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Product Id</label>
        </div>


        <button class="btn btn-outline-danger" type="submit">Delete</button>
        <button class="btn btn-dark" type="reset">Reset</button>

    </form>
</div>
</body>
</html>
