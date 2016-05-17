<%-- 
    Document   : manage_users
    Created on : May 13, 2016, 5:02:17 PM
    Author     : Joey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <c:import url="header.html"/>

    <body>

        <c:import url="nav.jsp"/>



        <div class="container" style="margin-top:40px">
            <c:import url="admin_panel.jsp"/>

            <div class="col-lg-10 admin_panel" style="margin-top: 80px">
                <div class="row">
                    <div class="col-md-6">
                        <form class="navbar-form page-header" role="search">
                            <div class="form-group" style="width: 50%">
                                <input type="text" class="form-control" placeholder="Search" style="width:100%">
                            </div>
                            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button> 
                        </form>
                    </div>  
                </div>
                <ul class="list-group">                   
                    <c:forEach var="bookName" items="${recommendationList}">
                    <li class="list-group-item">${bookName}<button type="button" class="btn btn-warning pull-right">Ignore</button><button type="button" class="btn btn-primary pull-right">Purchase</button></li>
                    </c:forEach>
                    </ul>
            </div>






        </div>

        <div class="footer"></div>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


