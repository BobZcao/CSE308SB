

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
                
                <ul class="list-group">
                    <c:forEach var="bookName" items="${resultBestSellers}">
                        <li class="list-group-item">${bookName}</li>
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


