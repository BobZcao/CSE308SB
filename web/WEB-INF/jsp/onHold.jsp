<%-- 
    Document   : onhold
    Created on : May 13, 2016, 4:03:34 PM
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
                        <a href="checkout.htm" class="list-group-item">Checked Out</a>
                        <a href="mem_profile.htm" class="list-group-item">Profile</a>
                        <a href="onHold.htm" class="list-group-item">On Hold</a>
                        <a href="wishList.htm" class="list-group-item">Wish List</a>
                        <a href="ratedBooks.htm" class="list-group-item">Rated Books</a>
                        <a href="borrowHistory.htm" class="list-group-item">Borrow History</a>
                    </div>
                </div>
                <div class="col-lg-7 " style="margin-top: 40px;margin-bottom: 20px">
                    <h4>Hold Books</h4>  
                     <c:forEach var="book" items="${onHoldList}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="300" height="400">
       
                </a>
                     <button type="submit" value = "Submit"  onclick="location.href ='editHold.htm?isbn=${book.isbn}'" class="btn btn-primary btn-lg btn-block" >Edit</button>
            </div>
         </c:forEach>
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



