<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Старт обработки форм для сервлетов</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootsnip-grey-menu.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>

<body>
<form action="search/" method="GET" class="form-horizontal">

 <div class="navbar-wrapper">
     <div class="container-fluid">
         <nav class="navbar navbar-fixed-top">
             <div class="container">
             <div id="navbar" class="navbar-collapse collapse">
                                 <ul class="nav navbar-nav">
                                     <li><a href="login.html" class="">Log in</a></li>
                                     <li><a href="register.jsp">Register</a></li>
                                     <li><a href="search.html" class="">Search</a></li>
                                 </ul>
             </div>
             </div>
         </nav>
     </div>
 </div>



<div class="container">

  <div class="row" >
<h1></h1>
<h1></h1>
<h1></h1>
<h1></h1>
    <div class="col-md-4 col-md-push-4">
      <div class="alert alert-danger">B</div>
      <img class="img-responsive img-circle" src="https://farm1.staticflickr.com/1/2759520_6dea8b9007.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

    <div class="col-md-4 col-md-pull-4 ">
      <div class="alert alert-info">A</div>
      <img class="img-responsive img-circle" src="https://farm2.staticflickr.com/1109/809710325_4289dc484e.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

    <div class="col-md-4">
      <div class="alert alert-success">C</div>
      <img class="img-responsive img-circle" src="https://farm3.staticflickr.com/2353/2216602404_679d01cd4b.jpg" alt="Greece-1173 - Temple of Athena by Dennis Jarvis, on Flickr">
    </div>

  </div>



        <fieldset>

            <!-- Form Name -->
            <legend>Search city</legend>

            <!-- Search input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="city"></label>
                <div class="col-md-5">
                    <input id="city" name="city" type="text" placeholder="Enter the city you wanna stay" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for=""></label>
                <div class="col-md-4">
                    <button id="" name="" class="btn btn-primary">Search</button>
                </div>
            </div>

        </fieldset>

</form>

</body>
</html>