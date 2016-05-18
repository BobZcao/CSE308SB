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
                            <button type="button" class="btn btn-default" onclick = "location.href='registrationPage.htm'">Create New User</button>
                        </form>
                    </div>  
                </div>
                <ul class="list-group">
                    <c:forEach var="user" items="${resultUserList}">
                        <c:choose>
                            <c:when test="${user.levels == 1}">
                                <li class="list-group-item">${user.userName} (member)<button type="button" class="btn btn-danger pull-right" onclick="location.href = 'delete.htm?userName=${user.userName}';">Delete</button><button type="button" class="btn btn-warning pull-right" onclick="location.href = 'promote.htm?userName=${user.userName}';">Promote</button><button type="button" class="btn btn-primary pull-right" onclick = "location.href = 'updateUserInfo.htm?userName=${user.userName}';">Update</button></li>
                            </c:when>
                            <c:when test="${user.levels == 2}">                 
                                <li class="list-group-item">${user.userName} (admin)<button type="button" class="btn btn-danger pull-right" onclick="location.href = 'delete.htm?userName=${user.userName}';">Delete</button><button type="button" class="btn btn-warning pull-right" onclick="location.href = 'demote.htm?userName=${user.userName}';">Demote</button><button type="button" class="btn btn-primary pull-right" onclick = "location.href = 'updateUserInfo.htm?userName=${user.userName}';">Update</button></li>
                            </c:when>
                        </c:choose>
                        
                    </c:forEach>
                </ul>
            </div>
        </div>

         <c:import url="footer.jsp"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


