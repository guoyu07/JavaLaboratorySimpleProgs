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
            if (session.getAttribute("user") != null) {
                response.sendRedirect("restricted.jsp");
            }

            String errorNotification = "";

            if (request.getParameter("error") != null) {
                errorNotification = "Wrong username or password!";
            }
            
            if (request.getParameter("redirect") != null) {
                errorNotification = "Login first!";
            }
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
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="account-wall">
                        <p class="text-center" style="color: red; margin-top: 10px"><%= errorNotification %></p>
                        <h1 class="text-center login-title">Sign in to continue</h1>
                        <form class="form-signin" action="LoginServlet" method="post">
                            <input type="text" name="userName" class="form-control" placeholder="Nickname" required autofocus>
                            <input type="password" name="password" class="form-control" placeholder="Password" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Sign in
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="/NumeralSystemsCalculatorWeb/resources/js/bootstrap.min.js"></script>
    </body>
</html>
