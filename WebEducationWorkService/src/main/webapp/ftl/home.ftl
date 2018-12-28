<!DOCTYPE html>
<html>
<head>

    <title>Education Work Service</title>

    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Bulat Kayumov">

    <link rel="shortcut icon" href="assets/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="assets/css/main.css">
</head>

<body class="home">

<div class="navbar navbar-inverse navbar-fixed-top headroom" >
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="/home"><img src="assets/images/logo.png" alt="HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li><a>Current User: ${user.getName()}</a></li>
                <li class="active"><a href="/home">Home</a></li>
                <li><a href="/order">Order</a></li>
                <li><a href="/allorders">My Orders</a></li>
                <li><a class="btn" href="/signin">Sign in / Sign up</a></li>
            </ul>
    </div>
</div>

<header id="head">
    <div class="container">
        <div class="row">
            <h1 class="lead">Order</h1>
            <p><a class="btn btn-default btn-lg" role="button">MORE INFO</a> <a class="btn btn-action btn-lg" role="button" href = "/order">ORDER NOW</a></p>
        </div>
    </div>
</header>
</body>

<footer id="footer" class="top-space">
    <div class="footer2">
        <div class="container">
            <div class="row">

            </div> <!-- /row of widgets -->
        </div>
    </div>
</footer>

</html>