<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <c:import url="header.html"/>

    <body>
        <c:import url="nav.jsp"/>
        <div class="row" style="padding-top: 100px">
            <h4 style="padding-left: 50px">You have promoted the user "${user}" from member to admin.</h4>
        </div>
    </body>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

    <!-- Customized js files -->
    <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    <c:import url="footer.html"/>
</html>
