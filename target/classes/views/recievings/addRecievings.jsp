<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Recieving</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/models.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<br><br><br>
<%
    if (session.getAttribute("username") == null){
        response.sendRedirect("index.jsp");
    }

%>

<div class="container">

    <form action="add-recieving" method="post">

        <div class="group">
            <input type="text" required name="batch_no">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Batch No</label>
        </div>

        <div class="group">
            <input type="text" required name="productId">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>ProductId</label>
        </div>

        <div class="group">
            <input type="text" required name="selling_price">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Selling Price</label>
        </div>

        <div class="group">
            <input type="text" required name="buying_price">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Buying Price</label>
        </div>

        <div class="group">
            <input type="text" required name="quantity">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Quantity</label>
        </div>

        <div class="group">
            <input type="text" required name="supplier">
            <span class="highlight"></span>
            <span class="bar"></span>
            <label>Supplier Name</label>
        </div>

        <button class="btn btn-outline-success" type="submit">Add</button>
        <button class="btn btn-outline-dark" type="reset">Reset</button>
    </form>



</div>
<style>
    * { box-sizing:border-box; }

    /* basic stylings ------------------------------------------ */
    body 				 { background:url(https://scotch.io/wp-content/uploads/2014/07/61.jpg); }
    .container 		{
        font-family:'Roboto';
        width:600px;
        margin:30px auto 0;
        display:block;
        background:#FFF;
        padding:10px 50px 50px;
    }
    h2 		 {
        text-align:center;
        margin-bottom:50px;
    }
    h2 small {
        font-weight:normal;
        color:#888;
        display:block;
    }
    .footer 	{ text-align:center; }
    .footer a  { color:#53B2C8; }

    /* form starting stylings ------------------------------- */
    .group 			  {
        position:relative;
        margin-bottom:45px;
    }
    input 				{
        font-size:18px;
        padding:10px 10px 10px 5px;
        display:block;
        width:300px;
        border:none;
        border-bottom:1px solid #757575;
    }
    input:focus 		{ outline:none; }

    /* LABEL ======================================= */
    label 				 {
        color:#999;
        font-size:18px;
        font-weight:normal;
        position:absolute;
        pointer-events:none;
        left:5px;
        top:10px;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }

    /* active state */
    input:focus ~ label, input:valid ~ label 		{
        top:-20px;
        font-size:14px;
        color:#5264AE;
    }

    /* BOTTOM BARS ================================= */
    .bar 	{ position:relative; display:block; width:300px; }
    .bar:before, .bar:after 	{
        content:'';
        height:2px;
        width:0;
        bottom:1px;
        position:absolute;
        background:#5264AE;
        transition:0.2s ease all;
        -moz-transition:0.2s ease all;
        -webkit-transition:0.2s ease all;
    }
    .bar:before {
        left:50%;
    }
    .bar:after {
        right:50%;
    }

    /* active state */
    input:focus ~ .bar:before, input:focus ~ .bar:after {
        width:50%;
    }

    /* HIGHLIGHTER ================================== */
    .highlight {
        position:absolute;
        height:60%;
        width:100px;
        top:25%;
        left:0;
        pointer-events:none;
        opacity:0.5;
    }

    /* active state */
    input:focus ~ .highlight {
        -webkit-animation:inputHighlighter 0.3s ease;
        -moz-animation:inputHighlighter 0.3s ease;
        animation:inputHighlighter 0.3s ease;
    }

    /* ANIMATIONS ================ */
    @-webkit-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @-moz-keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
    @keyframes inputHighlighter {
        from { background:#5264AE; }
        to 	{ width:0; background:transparent; }
    }
</style>

</body>
</html>