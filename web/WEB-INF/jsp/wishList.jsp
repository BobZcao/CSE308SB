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
                        <a href="checkout.htm" class="list-group-item">Checked Out</a>
                        <a href="mem_profile.htm" class="list-group-item">Profile</a>
                        <a href="onHold.htm" class="list-group-item">On Hold</a>
                        <a href="wishList.htm" class="list-group-item">Wish List</a>
                        <a href="ratedBooks.htm" class="list-group-item">Rated Books</a>
                        <a href="borrowHistory.htm" class="list-group-item">Borrow History</a>
                         <a href="recommend.htm" class="list-group-item">Recommend</a>
                    </div>
                </div>
                <div class="col-lg-7 " style="margin-top: 40px;margin-bottom: 20px">

                    <h4>Wish Books</h4>
                    <button type="button" onclick="All()" class="btn btn-primary">All</button>

                    <button type="button" onclick="Avail()" class="btn btn-primary">Available</button><br><br><br>
                    <div class="allBook">
                        <c:forEach var="book" items="${wishList}">
                            <div class="col-lg-3 col-md-3 col-xs-6 thumb">
                                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">

                                </a>
                                <button type="submit" value = "Submit"  onclick="location.href = 'removeFromWishListMember.htm?isbn=${book.isbn}'" class="btn btn-primary btn-lg btn-block" >Remove</button>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="availableBook" style="display:none;">
                        <c:forEach var="book" items="${wishAvailableList}">
                            <div class="col-lg-3 col-md-3 col-xs-6 thumb">
                                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">

                                </a>
                                <button type="submit" value = "Submit"  onclick="location.href = 'removeFromWishListMember.htm?isbn=${book.isbn}'" class="btn btn-primary btn-lg btn-block" >Remove</button>
                            </div>
                        </c:forEach>
                    </div>
                </div>




            </div>

        </div>

         <c:import url="footer.jsp"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <script>
                        function All() {
                            $(".allBook").css("display", "inline");
                            $(".availableBook").css("display", "none");
                        }
                        function Avail() {
                            $(".availableBook").css("display", "inline");
                            $(".allBook").css("display", "none");
                        }
        </script>
        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


