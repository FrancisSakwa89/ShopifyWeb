<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/29/19
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
<%--    <link rel="stylesheet" href="./css/styles.css">--%>
<%--    <link rel="stylesheet" href="./css/homejsp.css">--%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body>
<%
if (session.getAttribute("username") == null){
    response.sendRedirect("index.jsp");
}

%>

<nav class="navbar navbar-expand-lg fixed-top" id="up" style="background: white">
    <a class="navbar-brand" href="#"><img src="https://systechafrica.com/wp-content/uploads/2017/12/logo-1.png"></a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <ul class="navbar-nav">
                <li class="nav-item dropdown"  >
                    <a class="nav-link " data-toggle="dropdown" href="/shopify.web/home.jsp">Home</a>
                    <ul class="dropdown-menu">
                        <%--                        <li><a href="login.html">Login</a></li>--%>
                        <%--                        <li><a href="#">Register</a></li>--%>

                    </ul>
                </li>

<%--                <li class="nav-item dropdown"  >--%>
<%--                    <a class="nav-link " data-toggle="dropdown" href="#">Products</a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="add-product">Add Product</a></li>--%>
<%--                        <li><a href="#">View Products</a></li>--%>
<%--                        <li><a href="update-product">Update Products</a></li>--%>
<%--                        <li><a href="delete-product">Delete Product</a></li>--%>

<%--                    </ul>--%>
<%--                </li>--%>

                <li class="nav-item dropdown"  >
                    <a class="nav-link " data-toggle="dropdown" href="all-products">Products</a>

                </li>

                <li class="nav-item dropdown"  >
                    <a class="nav-link " data-toggle="dropdown" href="all-customers">Customers</a>
                    <ul class="dropdown-menu">
<%--                        <li><a href="add-customer">Add Customers</a></li>--%>
<%--                        <li><a href="#">View Customers</a></li>--%>
<%--                        <li><a href="update-customer">Update Customer</a></li>--%>
<%--                        <li><a href="delete-customer">Delete Customer</a></li>--%>

                    </ul>
                </li>

                <li class="nav-item dropdown"  >
                    <a class="nav-link " data-toggle="dropdown" href="all-recievings">Receivings</a>
                    <ul class="dropdown-menu">
<%--                        <li><a href="add-recieving">Add Receivings</a></li>--%>
<%--                        <li><a href="all-recievings">View Recievings</a></li>--%>
<%--                        <li><a href="#">Delete Recievings</a></li>--%>

                    </ul>
                </li>

                <li class="nav-item dropdown"  >
                    <a class="nav-link " data-toggle="dropdown" href="all-sales">Sales</a>
                    <ul class="dropdown-menu">
<%--                        <li><a href="add-sale">Add Sales</a></li>--%>
<%--                        <li><a href="all-sales">View Sales</a></li>--%>
<%--                        <li><a href="#">Delete Sales</a></li>--%>

                    </ul>
                </li>

            </ul>
        </ul>

    </div>
</nav>

<section class="wrapper fixed-top">
    <div class="overlays"></div><!--Mascara de imagen-->
    <div class="container h-100">
        <div class="row h-100 justify-content-between align-items-center">
            <div class="col-lg-12">
                <div class="text-center">
                    <h1 class="mt-5">SHOPIFY APPLICATION</h1>
                    <p>Welcome...
                    <h1>${username} </h1>
                    </p>

                    <form action="logout">
                    <button class="btn btn-outline-warning  mt-5">Logout</button>
                    </form>

                </div>


            </div>
        </div>
    </div>
</section>

<footer class="page-footer font-small blue pt-4">

    <br><br><br><br><br><br><br><br>

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <a href="https://francissakwa89.github.io/"> Sakwa Francis</a>
    </div>
    <!-- Copyright -->

</footer>

<script>
    $(window).scroll(function(){
        if( $(this).scrollTop()>50){

            // $('.navbar').css('background','#263238');

        }
    });
</script>


<style>
    body{
        height:100vh;
        font-family: 'Roboto Condensed', sans-serif;
    }
    #up{
        border-bottom:0px solid transparent;
        box-shadow: 0 0 transparent;
        background:transparent;
    }
    #navbarSupportedContent li {
        margin:0px 10px;
    }
    #navbarSupportedContent li a{
        color:#11998e;
        /*background-color: black;*/
    }
    #up h2{
        color:#00c851!important;
        font-size:1.3rem;
        cursor: pointer;

    }
    .wrapper{
        background:url('https://www.tuexperto.com/wp-content/uploads/2017/10/fondo-de-pantalla-paisaje.jpg');
        background-position:center;
        background-size:cover;
        background-repeat:no-repeat;
        width:100%;
        height:100vh;
        position:static;
        color:white;


    }
    .overlays{
        position:absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        opacity: .8;
        background: rgb(13, 13, 14);
    }

    ul.dropdown-menu{
        width: 11vw;
        border-radius: 0px;
        font-weight: 400;
        font-size: 0.9em;
        line-height: 16px;
        text-decoration: none;
        padding: 0px;
        list-style-type: none;
        -webkit-animation: mymove 1.0s;
        animation: mymove 1.0s;
        /*background-color: #fff;*/
        /*-webkit-box-shadow: 4px 9px 25px -6px rgba(77,77,77,0.61);*/
        /*-moz-box-shadow: 4px 9px 25px -6px rgba(77,77,77,0.61);*/
        /*box-shadow: 4px 9px 25px -6px rgba(77,77,77,0.61);*/
    }
    li.dropdown:hover ul.dropdown-menu{
        display: block;
    }

    /*.dropdown-menu li:hover a{*/
    /*    color: #ec5626;*/
    /*}*/

    .dropdown-menu li{
        border-bottom: 1px;
        padding: 20px;
        display:block;
    }
    .dropdown-menu li a{
        text-decoration: none;
        text-transform: capitalize;
    }
    @keyframes mymove {
        from {
            left:  100px;
            height: 0px;
            opacity: 0;
            border-bottom:0px;
        }
        to {
            height: auto;

        }
    }

    .navbar-nav a.nav-link{
        font-family: 'Roboto', sans-serif;
        text-transform: uppercase;
        padding: 0px !important;
    }
    ul.navbar-nav li.nav-item{
        margin: 0 20px;
    }
    ul.navbar-nav .nav-item:after {
        content: '';
        display: block;
        height: 3px;
        width: 0;

    }
    .navbar-nav .nav-item:hover:after {
        width: 100%;
        /*background:#eb3719;*/
    }




</style>

</body>
</html>
