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
    function sendProductId(productId) {
        $.ajax({
            type: 'post',
            url: '/products',
            data: {
                productId: productId
            }
        }).done(function (data) {
            var contentTableHTML = '<div class="container col-md-12" style="border:1px solid #cecece;">';
                contentTableHTML += '<div class="row" style="border:1px solid #cecece;">';
                contentTableHTML += '<div class="col-md-4">Added to cart:</div>';
                contentTableHTML += '<div class="col-md-3">Count</div>';
            contentTableHTML += '</div>';
            for (var i = 0; i < data.length; i++) {
                contentTableHTML += '<div class="row  jumbotron" style="border:1px solid #cecece; background:transparent !important" >';
                    contentTableHTML += '<div class="col-md-4">' + data[i].name + '</div>';
                    contentTableHTML += '<div class="col-md-3">' + data[i].count + '</div>';
                    contentTableHTML += '<div class="col-md-3"><a class="btn btn-danger" role="button" onclick="deleteProductId(' + data[i].id + ')">Delete</a></div>';
                contentTableHTML += '</div>';
            }
            contentTableHTML += '<div class="align-items-center justify-content-center"><a class="btn btn-success" role="button" href="/settings" ">Order</a></div>';
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
<script>
    function deleteProduct(productId) {
        $.ajax({
            type: 'post',
            url: '/deletecart',
            data: {
                productId: productId
            }
        }).done(function (data) {
            var contentTableHTML = '<div class="container col-md-12" style="border:1px solid #cecece;">';
                contentTableHTML += '<div class="row" style="border:1px solid #cecece;">';
                    contentTableHTML += '<div class="col-md-4">Added to cart:</div>';
                    contentTableHTML += '<div class="col-md-3">Count</div>';
                contentTableHTML += '</div>';
            for (var i = 0; i < data.length; i++) {
                contentTableHTML += '<div class="row  jumbotron" style="border:1px solid #cecece; background:transparent !important" >';
                    contentTableHTML += '<div class="col-md-4">' + data[i].name + '</div>';
                    contentTableHTML += '<div class="col-md-3">' + data[i].count + '</div>';
                    contentTableHTML += '<div class="col-md-3"><a class="btn btn-danger" role="button" onclick="deleteProductId(' + data[i].id + ')">Delete</a></div>';
                contentTableHTML += '</div>';
            }
            contentTableHTML += '<div class="align-items-center justify-content-center"><a class="btn btn-success" role="button" href="/settings" ">Order</a></div>';
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

<script>
    function search(query) {
        $.ajax({
            type: 'GET',
            url: '/search',
            data: {
                q: query
            }
        }).done(function (data) {
            var tableHTML = '<div class="container col-md-7">';
                tableHTML += '<div class="row">';
                    tableHTML += '<div class="col-lg-5"><h3>id</h3></div>';
                    tableHTML += '<div class="col-lg-3"><h3>Name</h3></div>';
                    tableHTML += '<div class="col-lg-2"><h3>Page cost</h3></div>';
                    tableHTML += '<div class="col-lg-2"></div>';
                tableHTML += '</div>';
            for (var i = 0; i < data.length; i++) {
                tableHTML += '<div class="row jumbotron" style="border:1px solid #cecece;">';
                    tableHTML += '<div class="col-md-5 ">';
                        tableHTML += '<div><img src="assets/images/' + data[i].photo + '" height="150" width="200" class="rounded"></div>';
                    tableHTML += '</div>';
                    tableHTML += '<div class="col-md-3">';
                        tableHTML += '<br>';
                        tableHTML += '<div><h4>' + data[i].name + '</h4></div>';
                    tableHTML += '</div>';
                    tableHTML += '<div class="col-md-2 align-items-center">';
                        tableHTML += '<div><h3>' + data[i].pageCost + '</h3></div>';
                    tableHTML += '</div>';
                    tableHTML += '<div class="col-md-2">';
                        tableHTML += '<div class="align-items-center"><a class="btn btn-success" role="button" onclick="sendProductId(' + data[i].id + ')">Add</a></div>';
                    tableHTML += '</div>';
                tableHTML += '</div>';
            }
            tableHTML += '</div>';
            var tableDiv = document.getElementById("products_table");
            tableDiv.innerHTML = tableHTML;
        }).fail(function () {
            alert('ALL BAD')
        });
    }
</script>

<body onload="search(''); sendProductId(0)">
<div class="col-md-8 maincontent">
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

    <div class="row">
        <div class="col-md-8 maincontent">
            <div class="container">
                <h1>SHOP</h1>
                <br>
                <div class="row">
                    <div class="col-md-4"><input id="q" type="text" class="form-control" onkeyup="search(document.getElementById('q').value)"></div>
                </div>
                <br>
                <div id="products_table">
                </div>
            </div>
        </div>

        <aside class="col-md-4 sidebar sidebar-right">
            <div class="row widget">
                <div id="table">
                </div>
            </div>
        </aside>
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