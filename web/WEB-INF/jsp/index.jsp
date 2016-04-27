<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html> 
    <c:import url="header.html"/>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.htm">Silly Bee Library</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav">
                    <li class="dropdown mega-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <span class="glyphicon glyphicon-chevron-down"></span></a>
                        <ul class="dropdown-menu mega-dropdown-menu row">
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Subject</li>

                                    <li><a href="display_page.html">Business</a></li>
                                    <li><a href="#">Fiction</a></li>
                                    <li><a href="#">Nonfiction</a></li>
                                    <li><a href="#">History</a></li>
                                    <li><a href="#">Religion</a></li>
                                    <li><a href="#">Education</a></li>
                                    <li><a href="#">Science</a></li>
                                    <li><a href="#">Medic</a></li>
                                    <li><a href="#">More...</a></li>

                                </ul>
                            </li>
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Genre</li>
                                    <li><a href="#">Novel</a></li>
                                    <li><a href="#">Drama</a></li>
                                    <li><a href="#">Poetry</a></li>
                                    <li><a href="#">Comedy</a></li>
                                    <li><a href="#">Tragedy</a></li>
                                    <li><a href="#">Short story</a></li>
                                    <li><a href="#">Epic</a></li>
                                    <li><a href="#">More...</a></li>
                                </ul>
                            </li>
                        </ul>

                    </li>
                    <li class="active"><a href="about.html">About<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">FAQ</a></li>
                </ul>
                <c:choose>

                    <c:when test=" ${not empty account.userName}">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>                        
                            <li><a href="logOut">Log out</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" onclick = "location.href='loginPage.htm'"><span class="glyphicon glyphicon-user login"></span>Log in</a></li>                        
                    <li>
                        <a href="#"  onclick = "location.href='registrationPage.htm'" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-user login"></span> Sign up</a>
                    </li>
                </ul>
                    </c:otherwise>
                </c:choose>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <!-- BEGIN # MODAL LOGIN -->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true"
         style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Begin # DIV Form -->
                <div id="div-forms">

                    <!-- Begin # Login Form -->
                    <form id="login-form" action="login" method="post">
                        <div class="modal-body">

                            <input id="login_username" class="form-control" type="text"
                                   name="lg_username" placeholder="Username" required> <input
                                   id="login_password" class="form-control" type="password"
                                   name="lg_password" placeholder="Password" required>
                        </div>
                        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                            </div>

                        </div>
                    </form>
                    <!-- End # Login Form -->
                </div>
                <!-- End # DIV Form -->

            </div>
        </div>
    </div>

        <div class="banner"></div>

        <div class="container" style="margin-top:40px">
            <div class="searchbar"></div>
            <c:import url="gallery.jsp"/>
        </div>

        <c:import url="footer.html"/>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <!-- Customized js files -->

        <script src="bootstrap-3.3.6-dist/js/script.js"></script>

    </body>
</html>
