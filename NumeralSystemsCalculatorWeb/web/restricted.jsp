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

        <title>Numeral Systems Calculator</title>

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
        <%
            String userName = (String)session.getAttribute("user");
            
            if(userName == null)
                response.sendRedirect("index.jsp?redirect=1");
        %>
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
                        <li class="active"><a href="index.jsp">Login</a></li>
                        <li class="active"><a href="restricted.jsp">Restricted</a></li>
                    </ul>

                    <form class="navbar-form navbar-right" action="LogoutServlet" method="post">
                        <button type="submit" class="btn btn-default">Logout</button>
                    </form>
                    <div class="navbar-right navbar-text">
                        Hi, <%= userName%>
                    </div>
                </div><!--/.nav-collapse -->

            </div>
        </nav>

        <div class="container">
            <div class="row account-wall">
                <h1 class="text-center login-title">Convert number</h1>
                <div class="col-md-6 col-md-offset-3" style="margin-bottom: 10px">
                    <div class="input-group">
                        <input type="text" id="inputNumberText" class="form-control" 
                               placeholder="Input number" aria-label="...">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" 
                                    data-toggle="dropdown" aria-expanded="false" id="inputNumeralSystem">
                                Input numeral system 
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                <li><a href="#">bin</a></li>
                                <li><a href="#">dec</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                    </div><!-- /input-group -->
                </div>
                <div class="col-md-6 col-md-offset-3">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Output number" 
                               aria-label="..." disabled="true" id="outputNumberText">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" 
                                    data-toggle="dropdown" aria-expanded="false" id="outputNumeralSystem">
                                Output numeral system 
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                <li><a href="#">bin</a></li>
                                <li><a href="#">dec</a></li>
                            </ul>
                        </div><!-- /btn-group -->
                    </div><!-- /input-group -->
                </div>
                <div class="text-center col-md-6 col-md-offset-3" style="margin-top:8px">
                    <button id="saveResultButton" type="submit" class="btn btn-default">Save result</button>
                </div>
                <div class="text-center col-md-6 col-md-offset-3" 
                     style="color: red; margin-top: 10px" id="errorMessage"></div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="/NumeralSystemsCalculatorWeb/resources/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            $(function () {
                
                $("#saveResultButton").click(function() {
                    
                    var postData = {
                        fromNumeralSystem: $("#inputNumeralSystem").val(),
                        toNumeralSystem: $("#outputNumeralSystem").val(),
                        numberToConvert: $("#inputNumberText").val(),
                        convertedNumber: $("#outputNumberText").val()
                    };
                    
                    var postDataSerialized = {
                        content: JSON.stringify(postData)
                    };
                    
                    // Checking if input data is correct and ready to be sent to the servlet
                    if (postData.fromNumeralSystem.trim() &&
                        postData.toNumeralSystem.trim() && 
                        postData.numberToConvert.trim() &&
                        postData.convertedNumber.trim()) {

                        // Invoking post method if everything is fine
                        $.post("/NumeralSystemsCalculatorWeb/api?action=saveResult", postDataSerialized)
                        .done(function () {
                            alert("Successfully saved!");
                        })
                        .fail(function (xhr, status, error) {
                            // Invoked when any error occured
                            $("#errorMessage").html(error);
                        });
                    }
                });
                
                // Handle selecting items on both dropwown menus.
                $(".dropdown-menu li a").click(function () {
                    $(this).parents(".input-group-btn").find('.btn').text($(this).text());
                    $(this).parents(".input-group-btn").find('.btn').val($(this).text());
                    computeNumber(); // Try to invoke computing every time dropdown changes
                });

                $("#inputNumberText").on("input", function () {
                    computeNumber(); // Try to invoke computing every time input number changes
                });
            });

            function computeNumber() {

                var postData = {
                    from: $("#inputNumeralSystem").val(),
                    to: $("#outputNumeralSystem").val(),
                    number: $("#inputNumberText").val()
                }

                // Checking if input data is correct and ready to be sent to the servlet
                if (postData.from.trim() && postData.to.trim() && postData.number.trim()) {
                    
                    // Invoking post method if everything is fine
                    $.post("/NumeralSystemsCalculatorWeb/api?action=computeNumber", postData)
                    .done(function (data) {
                        // Invoked when request was correct and computation succeeded
                        $("#outputNumberText").val(data);
                        $("#errorMessage").empty();
                    })
                    .fail(function (xhr, status, error) {
                        // Invoked when any error occured
                        $("#errorMessage").html(error);
                        $("#outputNumberText").val("");
                    });
                } else {
                    // Clearing output number textBox if input data is incorrect
                    $("#outputNumberText").val(""); 
                }
            }
        </script>
    </body>
</html>

