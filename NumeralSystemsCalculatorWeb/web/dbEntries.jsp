<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Numeral Systems Calculator - Db Entries</title>

        <!-- Bootstrap core CSS -->
        <link href="/NumeralSystemsCalculatorWeb/resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="/NumeralSystemsCalculatorWeb/resources/css/starter-template.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" 
                            data-toggle="collapse" data-target="#navbar" 
                            aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="navbar-brand">Numeral Systems Calculator</div>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Login</a></li>
                        <li><a href="restricted.jsp">Restricted</a></li>
                        <li class="active"><a href="dbEntries.jsp">DB Entries</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container col-md-10 col-md-offset-1">
            <div class="row">
                <div class="col-md-6">
                    <h2>Users table</h2>
                    <div>
                        <table class="table table-condensed table-striped" id="usersTable">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                </tr>
                            </thead>
                            <tbody />
                        </table>
                    </div>
                </div>
                <div class="col-md-6">
                    <h2>Results table</h2>
                    <div>
                        <table class="table table-condensed table-striped" id="resultsTable">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>User id</th>
                                    <th>Input numeral system</th>
                                    <th>Input number</th>
                                    <th>Output numeral system</th>
                                    <th>Output number</th>
                                </tr>
                            </thead>
                            <tbody />
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="/NumeralSystemsCalculatorWeb/resources/js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
            $(function () {
                getUsers();
                getResults();
            });
            
            function getResults() {
                
                $.get("/NumeralSystemsCalculatorWeb/DbEntriesServlet?action=resultsTable", function(data){
                    var tbl_body = "";
                    $.each(data, function(i) {
                        var tbl_row = "";
                        $.each(this, function(k , v) {
                            tbl_row += "<td>"+v+"</td>";
                        });
                        tbl_body += "<tr>"+tbl_row+"</tr>";       
                    });
                    $("#resultsTable tbody").html(tbl_body);
                });
            }
            
            function getUsers() {
                
                $.get("/NumeralSystemsCalculatorWeb/DbEntriesServlet?action=usersTable", function(data){
                    var tbl_body = "";
                    $.each(data, function() {
                        var tbl_row = "";
                        $.each(this, function(k , v) {
                            tbl_row += "<td>"+v+"</td>";
                        });
                        tbl_body += "<tr>"+tbl_row+"</tr>";       
                    });
                    $("#usersTable tbody").html(tbl_body);
                });
            }
        </script>
    </body>
</html>
