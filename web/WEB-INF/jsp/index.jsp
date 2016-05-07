<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html> 
    <c:import url="header.html"/>

    <body>
        <c:import url="nav.jsp"/>
                <c:choose>

                    <c:when test="${not empty account.userName}">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${account.userName}</a></li>                        
                            <li><a href="logout.htm">Log out</a></li>
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
            </div> /.navbar-collapse 
        </div> /.container-fluid 
    </nav>-->

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
            <c:import url="searchbar.jsp"/>
<!--            <div class="searchbar"></div>-->
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
