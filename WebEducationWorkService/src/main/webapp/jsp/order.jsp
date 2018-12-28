<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            var contentTableHTML = "<table>";

            for (var i = 0; i < data.length; i++) {

                contentTableHTML += "<tr>";
                contentTableHTML += "<td>Added to cart: " + data[i].name + "</td>";
                contentTableHTML += "<td> " + data[i].count + "</td>";

                contentTableHTML += "<table>";
                contentTableHTML += "<tr>";
                contentTableHTML += '<td><button onclick="deleteProduct(' + data[i].id + ')" ">Delete </button></td>'
                contentTableHTML += "</tr>";
                contentTableHTML += "</table>";
            }
            contentTableHTML += "</table>";
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
            var contentTableHTML = "<table>";

            for (var i = 0; i < data.length; i++) {
                contentTableHTML += "<tr>";
                contentTableHTML += "<td>Added to cart: " + data[i].name + "</td>";
                contentTableHTML += "<td> " + data[i].count + "</td>";

                contentTableHTML += '<table id="delete">';
                contentTableHTML += "<tr>";
                contentTableHTML += '<td><button onclick="deleteProduct(' + data[i].id + ')" ">Delete </button></td>'
                contentTableHTML += "</tr>";
                contentTableHTML += "</table>";
            }
            contentTableHTML += "</table>";
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
            var tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'id' +
                '</th>' +
                '<th>' +
                'name' +
                '</th>' +
                '</tr>';
            for (var i = 0; i < data.length; i++) {
                tableHtml += '<tr>' +
                    '<td>' + '<img src="assets/images/' + data[i].photo + '" height="150" width="200">' + '</td>' +
                    '<td>' + data[i].name + '</td>' +
                    '<td>' + data[i].cost + '</td>' +
                    '<td>' + '<button onclick="sendProductId(' + data[i].id + ')">Buy</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#products_table").html(tableHtml);
        }).fail(function () {
            alert('ALL BAD')
        });
    }
</script>

<body onload    = "search(''); sendProductId(0)">
<div class="col-md-8 maincontent">
    <div class="navbar navbar-inverse navbar-fixed-top headroom" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand" href="/home"><img src="assets/images/logo.png" alt="HTML5 template"></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active"><a href="/home">home</a></li>
                    <li><a href="/order">order</a></li>
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
                <input id="q" type="text" onkeyup="search(document.getElementById('q').value)">
                <br>
                <div id="products_table">
                </div>
            </div>
        </div>

        <aside class="col-md-4 sidebar sidebar-right">
            <div class="row widget">
                <div id="table" class="col-xs-12">
                </div>
            </div>
        </aside>
    </div>
</div>


<footer id="footer" class="top-space">
    <div class="footer2">
        <div class="container">
            <div class="row">
                <div class="col-md-1 widget">
                    <h1><a href="/order?lang=ru">RU</a></h1>
                </div>
                <div class="col-md-1 widget">
                    <h1><a href="/order?lang=en">EN</a></h1>
                </div>
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