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
                <li class="active"><a href="/home">Home</a></li>
                <li><a href="/order">Order</a></li>
                <li><a href="/allorders">My Orders</a></li>
                <li class="dropdown">
                <li><a class="btn" href="/signin">sign in / sign up</a></li>
            </ul>
        </div>
    </div>
</div>

<header id="head" class="secondary"></header>

<div class="container">

    <ol class="breadcrumb">
        <li><a href="/home">Home</a></li>
        <li class="active">User access</li>
    </ol>

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Sign in</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Sign in to your account</h3>
                        <hr>
                        <form name="signInForm" id="sif" method="post" action="/signin">
                            <div class="top-margin">
                                <label>Username <span class="text-danger">*</span></label>
                                <input name="name" placeholder="Your name" class="form-control">
                            </div>
                            <div class="top-margin">
                                <label>Password <span class="text-danger">*</span></label>
                                <input type="password" name="password" placeholder="Your Password" class="form-control">
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" type="submit">Sign In</button>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <a class="btn btn-success" role="button" href = "/signup">Register</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
</div>	<!-- /container -->

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