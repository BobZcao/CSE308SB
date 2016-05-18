
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Most popular <span class="glyphicon glyphicon-chevron-down"></span></a>
                        <ul class="dropdown-menu mega-dropdown-menu row">
                            <c:forEach var="book" items="${mostPopular}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>
                        </ul>

                    </li>
                    <li class="active"><a href="about.html">About<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a class="dropdown-toggle" data-toggle="dropdown">Library Services</a>
                        <ul class="dropdown-menu row">
                            
                            <li><a href="http://help.overdrive.com/customer/en/portal/articles/1529341">View OverDrive Help</a></li>
                            <li><a href="lendingPolicies.htm">View Lending Policies</a></li>
                            <li><a href="howToRecommend.htm">How to Recommend Book</a></li>
                            <li><a href="copyright.htm">View Copyright Policy</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <c:choose>

                    <c:when test="${not empty account.userName && account.levels==1}">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="checkout.htm"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>                        
                            <li><a href="logout.htm">Log out</a></li>
                        </ul>
                    </c:when>
                    <c:when test="${not empty account.userName && account.levels==2}">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="manage_users.htm"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>                        
                            <li><a href="logout.htm">Log out</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" onclick = "location.href='loginPage.htm'"><span class="glyphicon glyphicon-user login"></span> Login</a></li>                        
                    <li>
                        <a href="#"  onclick = "location.href='registrationPage.htm'"><span class="glyphicon glyphicon-user login"></span> Sign up</a>
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



    <script>
        function selectSignIn() {
            var result = document.getElementById("selectSign").value;
            if (result == "Member") {
                $(".member").css("display", "inline");
                $("#ssn").css("display", "none");
                $(".publisher").css("display", "none");
            }
            if (result == "Faculty") {
                $(".member").css("display", "inline");
                $("#ssn").css("display", "inline");
                $(".publisher").css("display", "none");
            }
            if (result == "Publisher") {
                $(".member").css("display", "none");
                $("#ssn").css("display", "none");
                $(".publisher").css("display", "inline");
            }
        }
    </script>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Customized JS -->
    <script src="js/popup.js"></script>

</html>
