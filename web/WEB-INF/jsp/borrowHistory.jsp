<%-- 
    Document   : borrowHistory
    Created on : May 13, 2016, 5:30:46 PM
    Author     : yongbinchen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <div class="col-lg-10 " style="margin-top: 40px;margin-bottom: 20px">
                    <h4>Borrow History </h4>  
                    <table>
                        <tr>
                        <div class="col-lg-4"><th>Book</th></div>
                        <div class="col-lg-4"><th>Date Borrow</th></div>
                        <div class="col-lg-4" ><th>Date Return</th></div>
                        </tr>

                        <c:forEach var="book" items="${borrowHistoryList}">
                            <tr><td>
                                    <a  href="view.htm?isbn=${book.isbn}">
                                        ${book.title}
                                    </a>
                                </td>

                                <c:forEach var="borrow" items="${borrowHistoryBorrow}">
                                    <c:if test="${book.isbn==borrow.borrowPK.book}">
                                        <td>  ${borrow.borrowPK.dateBorrow} </td>
                                        <td>  ${borrow.dateReturn} </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>



                </div>




            </div>

        </div>

        <c:import url="footer.html"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <style>
            th, td{
                padding: 10px;
            }

        </style>
        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>



