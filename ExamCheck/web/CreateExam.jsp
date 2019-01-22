

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create An Exam</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom CSS -->
    <link href="dist/css/DCEC.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<script>
        function resizeText(multiplier)
        {
            if (document.body.style.fontSize == "") 
            {
                document.body.style.fontSize = "1.0em";
            }
              document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
        }
        </script>

<body>
 
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Dundee Computing Examination Board</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                 <!-- Accessibility -->
                 <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-universal-access fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-access">
                                <li><a href="#" onclick=resizeText(1)><i class="fa fa-text-height fa-fw"></i>Increase Text Size</a></li>
                                <li><a href="#" onclick=resizeText(-1)><i class="fa fa-text-height fa-fw"></i>Decrease Text Size</a></li>
                                <li><a href="CreateExam.jsp"><i class="fa fa-text-height fa-fw"></i>Normal Text Size</a></li>
                        </ul>
                    </li>
                <!-- Alerts Dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> No New Comments
                                </div>
                            </a>
                        </li>
                    </ul>

                </li>
                <!-- User Dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Accessibilty</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- Top Links -->

            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create a new Exam</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <form>
                Module Code: <br>
                <input type="text" name="moduleCode"><br><br>
                Module Title: <br>
                <input type="text" name="moduleTitle"><br><br>
                Module Coordinator: <br>
                <input type="text" name="moduleCoordinator"><br><br>
                Internal Moderator: <br>
                <input type="text" name="internalModerator"><br><br>
                <br>
                <input type="radio" name="examType" value="online"> Online<br>
                <input type="radio" name="examType" value="written" > Written<br>
                <br>
                <input type="radio" name="examChoice" value="main" > Main Exam<br>
                <input type="radio" name="examChoice" value="resit" > Resit Exam<br>
                <br>
                <input type="radio" name="examLevel" value="undergrad" > Undergrad Exam<br>
                <input type="radio" name="examLevel" value="postgrad" > Postgrad Exam<br>
                <br>
                <br>
            </form>
            <form action="upload.php" method="post" enctype="multipart/form-data">
                Select a file to upload: <br><br>
                <input type="file" name="fileToUpload" id="fileToUpload"><br>
            </form>
            <a href="#" onclick="return confirm('File Uploaded');"><button>Upload Exam</button></a>
            <br>
            <br>
            <a href="index.jsp" onclick="return confirm('Exam Has Been Created');"><button>Create Exam</button></a>
            <br>
            <br>
            <a type="button" href="index.jsp">Return to Homepage</a>

         <!-- jQuery -->
     <script src="vendor/jquery/jquery.min.js"></script>

     <!-- Bootstrap Core JavaScript -->
     <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
 
 
     <!-- Custom Theme JavaScript -->
     <script src="dist/js/DCEC.js"></script>

</body>
</html>
