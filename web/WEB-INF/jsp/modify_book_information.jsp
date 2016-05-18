<%-- 
    Document   : manage_users
    Created on : May 13, 2016, 5:02:17 PM
    Author     : Joey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <c:import url="header.html"/>

    <body>

        <c:import url="nav.jsp"/>
        <div class="container" style="margin-top:40px">
            <c:import url="admin_panel.jsp"/>

            <div class="col-lg-10 admin_panel" style="margin-top: 60px">
                <div class="row">
                    <form:form action="fileSelection.htm" method="POST" id="fileSelectionForm" commandName="pathBean" >             
                        <label for="exampleInputFile">XML File</label>
                        <form:input type="text" id="exampleInputFile" path = "filePath"/>
                        <p class="help-block">Please enter the path of your updated xml file here.</p>
                        <button type="submit" value = "Submit" class="btn btn-default">Upload</button>
                    </form:form> 
                    
                    
                </div>
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


