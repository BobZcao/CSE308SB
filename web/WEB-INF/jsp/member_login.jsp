<%-- 
    Document   : member_login
    Created on : May 8, 2016, 9:09:01 PM
    Author     : yongbinchen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>

   <c:import url="header.html"/>

    <body>

       <c:import url="nav.jsp"/>
              


        <div class="container" style="margin-top:40px">
            <div class="row">
                <div class="col-lg-2" style="margin-top: 40px">
                    <div class="list-group">
                        <h4>My Account</h4>
                        <a href="#" class="list-group-item">Checked Out</a>
                        <a href="mem_profile.htm" class="list-group-item">Profile</a>
                        <a href="#" class="list-group-item">On Hold</a>
                        <a href="#" class="list-group-item">Wish List</a>
                        <a href="#" class="list-group-item">Rated books</a>
                    </div>
                </div>


          
               

            </div>

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


