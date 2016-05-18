<%-- 
    Document   : manage_users
    Created on : May 13, 2016, 5:02:17 PM
    Author     : Joey
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
            <c:import url="admin_panel.jsp"/>

            <div class="col-lg-10 admin_panel" style="margin-top: 80px">
                <div class="row">
                    <div class="col-md-6">
                   <form:form action="manage_books_search.htm" method="POST" class="navbar-form page-header" role="search" id="search" commandName= "searchBean">
                    <div class="form-group" style="width: 50%">
                    
                    <form:input path = "keywords" type="text"
                                name = "keywords" class="form-control" 
                                placeholder="Search" style="width:100%" required="required"/>
                    
                </div>
                <button type="submit" value="Submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button> 
                </form:form>
                    </div>  
                </div>

                <ul class="list-group">
                    <c:forEach var="book" items="${resultBookList}">
                        <li class="list-group-item">${book.title}<button type="button" class="btn btn-danger pull-right" onclick="location.href = 'ban.htm?isbn=${book.isbn}';">Ban</button><button type="button" class="btn btn-warning pull-right" onclick="location.href = 'unban.htm?isbn=${book.isbn}';">Unban</button><button type="button" class="btn btn-primary pull-right" onclick="location.href = 'buyMoreLicenses.htm?isbn=${book.isbn}';">Buy More Licenses</button></li>
                    </c:forEach>
                </ul>
                
                
            </div>
            
            <div>
            <ul class="pager" style="margin-top:20px">
                <li><a href="manage_books_next.htm">Next</a></li>
                <li><a href="manage_books_previous.htm">Previous</a></li>
                <li><a href="manage_books_last.htm">Last</a></li>
                <li><a href="manage_books_first.htm">First</a></li>
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


