<%@ page import="java.util.ArrayList" %>
<%@ page import="com.franco.Bean.ProductBean" %>
<%@ page import="com.franco.Bean.RecieveBean" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.franco.models.Product" %>
<%@ page import="com.franco.models.Recievings" %><%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/27/19
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sales</title>
    <link rel="stylesheet" href="../../css/styles.css">
    <link href="./js/main.js" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
<br><br><br>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }

%>

<br><br>
<h1 style="text-align: center">SALES</h1>

<table class="table table-bordered" style="margin-left: 15%;width:70%">
    <thead>
    <tr>
        <th scope="col">Sale Id</th>
        <th scope="col">Date</th>
        <th scope="col">ProductId</th>
        <th scope="col">Product Price</th>
        <th scope="col">Quantity Bought</th>
        <th scope="col">CustomerName</th>
        <th scope="col">Total Amount</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${sales}" var="sale">
    <tr>
<%--        <th scope="row">1</th>--%>
        <td>${sale.saleId}</td>
        <td>${sale.datetime}</td>
        <td>${sale.productId}</td>
        <td>${sale.sellingPrice}</td>
        <td>${sale.quantity}</td>
        <td>${sale.customerName}</td>
        <td>${sale.totalAmount}</td>

    </tr>

</c:forEach>
    </tbody>
</table>

<div style="margin-left: 30%">
<a href="add-sale" ><button class="btn btn-outline-success" type="submit">Add Sale</button></a>
<a href="/shopify.web/home.jsp"><button class="btn btn-outline-info" type="reset">Back</button></a>
</div>
<br><br>

</body>
</html>
