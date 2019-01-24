

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

    <body>
    
        <script>
            function resizeText(multiplier){
                if (document.body.style.fontSize === ""){
                document.body.style.fontSize = "1.0em";
                }
                document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
            }
        </script>
 
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
            

            <form action="FileUpload" method="post" id="examDetails">
                Module Code: <br>
                <input type="text" name="moduleCode" id="modCode"><br><br>
                Module Title: <br>
                <input type="text" name="moduleTitle" id="modTitle"><br><br>
                <br>
                <input type="radio" name="examType" value="0" id="onlineRad"> Online<br> <!-- 0=Online 1=Written -->
                <input type="radio" name="examType" value="1" id="writtenRad"> Written<br>
                <br>
                <input type="radio" name="examChoice" value="0" id="mainRad"> Main Exam<br> <!-- 0=Main Exam 1=Resit Exam -->
                <input type="radio" name="examChoice" value="1" id="resitRad"> Resit Exam<br>
                <br>
                <input type="radio" name="examLevel" value="0" id="UndergradRad"> Undergrad Exam<br> <!-- 0=Undergrad 1=Postgrad -->
                <input type="radio" name="examLevel" value="1" id="PostgradRad"> Postgrad Exam<br>
                <br>
                <br>
                Select a file to upload: <br><br>
                <input type="file" name="fileToUpload" id="fileToUpload" accept="application/pdf, application/msword"><br>
                
            </form>
                <!--<button type="submit" form="examDetails" value="submit">Submit Exam</button>-->
            <br>
            <br>
            <!-- returns values for radio buttons -->
            <script>                
                function submitExam( file, code, level, subject, type , choice){
                    window.alert("start");
                   import BackEnd.Database;
                    Database db = new Database();
                    db.connect();
                       InputStream inputStream = new FileInputStream(new File(file));
                    // boolean test= db.updateQuery("INSERT INTO `18agileteam7db`.`entity_1`(`PK`,`test`)VALUES(9,null);");
                    db.blobin( file, code, level, "34", subject, type, choice, "1");  
                    out.println("end");
                    // out.println(db.blobin(file, code, level, "34", subject, type, choice, "1")); 
                    window.alert(db.blobin(inputStream, code, level, "34", subject, type, choice, "1"));
                } 

                function getModCode(){
                    return document.getElementById("modCode");
                    window.alert;
                }

                function getModTitle(){
                    return document.getElementById("modTitle");
                }

                function getFilePath(){
                    return document.getElementById("fileToUpload");
                }

                function getLevel(){
                    var radios = document.getElementByName("examLevel");
                    for (var i = 0, length = radios.length; i < length; i++){
                        if (radios[i].checked){
                            return (radios[i].value);
                            break;
                        }
                    }
                }

                function getChoice(){
                    var radios = document.getElementByName("examChoice");
                    for (var i = 0, length = radios.length; i < length; i++){
                        if (radios[i].checked){
                            return (radios[i].value);
                            break;
                        }
                    }
                }

                function getType(){
                    var radios = document.getElementByName("examType");
                    for (var i = 0, length = radios.length; i < length; i++){
                        if (radios[i].checked){
                            return (radios[i].value);
                            break;
                        }
                    }
                }
            </script>
            
            
             
                <a href="#" onclick="SubmitExam(getFilePath(), getModCode(),  getLevel(), getModTitle(), getType(), getChoice())"><i ></i>create exam</a>
             
       
                <br>
                <br>
                <a href="index.jsp">Return to Homepage</a>

                <!-- jQuery -->
                <script src="vendor/jquery/jquery.min.js"></script>

                <!-- Bootstrap Core JavaScript -->
                <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
 
 
                <!-- Custom Theme JavaScript -->
                <script src="dist/js/DCEC.js"></script>
            </div>
            </div>
    </body>
</html>