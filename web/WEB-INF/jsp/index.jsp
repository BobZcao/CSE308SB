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
                    <li><a href="#" onclick = "location.href = 'loginPage.htm'"><span class="glyphicon glyphicon-user login"></span>Log in</a></li>                        
                    <li>
                        <a href="#"  onclick = "location.href = 'registrationPage.htm'" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-user login"></span> Sign up</a>
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

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="img-responsive" src="http://g-ecx.images-amazon.com/images/G/01/kindle/merch/2016/DASH/gw/DashButton-Gateway_3000x600-4_99._CB294171934_.jpg" alt="">
        </div>

        <div class="item">
            <img class="img-responsive" src="http://g-ecx.images-amazon.com/images/G/01/pantry/gateway/propensity-test/pantry-propensity-test-GWlaundryx2._CB273808279_.jpg" alt="">
        </div>

        <div class="item">
            <img class="img-responsive" src="http://www.gonzalonoales.com/wp-content/themes/reverie/images/bg.jpg" alt="" >
            <div class="carousel-caption">
                <c:forEach var="b" items="${subjectsList}">
                    <a href="display_subject.htm?subject=${b}">${b}&nbsp&nbsp&nbsp&nbsp</a>
                </c:forEach>

            </div>
        </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

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
