<!DOCTYPE html>
<html>
<head>

    <title>Order</title>

    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Bulat Kayumov">

    <link rel="shortcut icon" href="assets/images/gt_favicon.png">


    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css">

    <link rel="stylesheet" href="/assets/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="/assets/css/main.css">

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>

</head>

<script>
    function submit(productId) {
        $.ajax({
            type: 'post',
            url: '/settings'
            data: {
                productId : productId;
            }
        }).done(function (data) {

        }).fail(function (jqXHR, exception) {
            var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            alert(msg)
        })
    }
</script>
<script>
    function showProducts() {
        $.ajax({
            type: 'post',
            url: '/showSettings',
            data: {

            }
        }).done(function (data) {

            var contentTableHTML = "<div>";
            var j;
            for (var i = 0; i < data.length; i++) {
                contentTableHTML += '<form  name="orderForm" id="form'+ i +'" method="post" action="/signin">';
                    contentTableHTML += '<div class=\"container jumbotron\" style=\"border:1px solid #cecece;\">';
                        contentTableHTML += '<div class=\"row\">';
                            contentTableHTML += '<div class=\"col-lg-2\"><img src="assets/images/' + data[i].photo + '" height="150" width="200" class="rounded"></div>';
                            contentTableHTML += '<div class=\"col-lg-3\">';
                                    contentTableHTML += '<div><h3>' + data[i].name + '</h3></div>';
                                    contentTableHTML += '<br>';
                                    contentTableHTML += '<div><input name="theme" id="theme' + i + '" type="text" placeholder="Theme" class="form-control" required></div>';
                                    contentTableHTML += '<br>';
                            contentTableHTML += '</div>';
                            contentTableHTML += '<div class=\"col-lg-4\">';
                                contentTableHTML += '<div class=\"container\">';
                                    contentTableHTML += '<div><h4>period_of_execution:</h4></div>';
                                    contentTableHTML += '<div>';
                                    contentTableHTML += '<input name = "period_of_execution" id="poe' + i + '" type="number" class="form-control" min="5" required>';
                                    contentTableHTML += '</div>';
                                    contentTableHTML += '<br>';
                                    contentTableHTML += '<div><h4>Count of pages:</h4></div>';
                                    contentTableHTML += '<div class="row">';
                                        contentTableHTML += '<div class="col-md-2">From</div>';
                                        contentTableHTML += '<div class="col-lg-4">';
                                            contentTableHTML += '<select class="form-control" name="min_pages_count' + i + '" id="min">';
                                                for (j = 5; j < 105; j+=5) {
                                                    contentTableHTML += '<option value=\"' + j + '\">' + j + '</option>';
                                                }
                                            contentTableHTML += '</select>';
                                        contentTableHTML += '</div>';
                                        contentTableHTML += '<div class="col-md-1">to</div>';
                                        contentTableHTML += '<div class="col-lg-4">';
                                            contentTableHTML += '<select class="form-control" name="max_pages_count' + i + '" id="max">';
                                                for (j = 5; j < 105; j+=5) {
                                                    contentTableHTML += '<option value=\"' + j + '\">' + j + '</option>';
                                                }
                                            contentTableHTML += '</select>';
                                        contentTableHTML += '</div>';
                                    contentTableHTML += '</div>';
                                contentTableHTML += '</div>';
                            contentTableHTML += '</div>';
                            contentTableHTML += '<div class=\"col-lg-3\">';
                                contentTableHTML += '<div class=\"container\">';
                                    //contentTableHTML += '<div><h4>cost = <a id="cost' + i + '"></a></h4></div>';
                                    contentTableHTML += '<div class="row">';
                                        contentTableHTML += '<div class=><a class="btn btn-success" role="button" type="submit" onclick="submit(' + i + ')">Order</a></div>';
                                    contentTableHTML += '</div>';
                                contentTableHTML += '</div>';
                            contentTableHTML += '</div>';
                        contentTableHTML += '</div>';
                        contentTableHTML += '<br>';
                        contentTableHTML += '<div class=\"col-lg\"><input name="coment" id="comment' + i + '" type="text" placeholder="Comment" class="form-control input-lg"></div>';
                        contentTableHTML += '</div>';
                contentTableHTML += '</form>';
            }
            contentTableHTML += "</div>";
            var contentTableDiv = document.getElementById("table");
            contentTableDiv.innerHTML = contentTableHTML;
        }).fail(function (jqXHR, exception) {
            var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            alert(msg)
        })
    }
</script>


<body onload="showProducts();">
<div class="col-md-8 maincontent">
    <div class="navbar navbar-inverse navbar-fixed-top headroom" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand" href="/home"><img src="assets/images/logo.png" alt="HTML5 template"></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav pull-right">
                    <li><a>Current User: ${user}</a></li>
                    <li class="active"><a href="/home">Home</a></li>
                    <li><a href="/order">Order</a></li>
                    <li><a href="/allorders">My Orders</a></li>
                    <li class="dropdown">
                    <li><a class="btn" href="/signin">sign in / sign up</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<header id="head" class="secondary"></header>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/home">Home</a></li>
        <li class="active">Order</li>
    </ol>

    <div class="container">
        <h1>SETTINGS</h1>
        <br>
        <div id="table">
        </div>
    </div>
</div>


<footer id="footer" class="top-space">
    <div class="footer2">
        <div class="container">
            <div class="row">

            </div>
        </div>
    </div>
</footer>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="assets/js/headroom.min.js"></script>
<script src="assets/js/jQuery.headroom.min.js"></script>
<script src="assets/js/template.js"></script>
</body>
</html>