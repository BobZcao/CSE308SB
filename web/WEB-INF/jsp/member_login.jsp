<%-- 
    Document   : member_login
    Created on : May 8, 2016, 9:09:01 PM
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
                        <a href="recommend.htm" class="list-group-item">Recommend</a>
                        
                    </div>
                </div>
                <div class="col-lg-10 " style="margin-top: 40px;margin-bottom: 20px">
                    <h4>Checked Out</h4>  
                    <table>
                        <tr>
                        <div class="col-lg-3"><th>Book</th></div>
                        <div class="col-lg-3"><th>Borrow Date</th>
                            <div class="col-lg-3" >  <th>Due</th></div>
                            <div class="col-lg-3" >  <th></th></div>

                            </tr>

                            <c:forEach var="book" items="${checkedOutBookList}">
                                <tr><td>

                                        <a  href="view.htm?isbn=${book.isbn}">
                                            ${book.title}
           <!--                                <img class="img-responsive" src="${book.imageUrl}" alt="" width="110" height="150">-->

                                        </a>

                                    </td>

                                    <c:forEach var="borrow" items="${borrowList}">
                                       <jsp:useBean id="now" class="java.util.Date"/>
                    
                                        <c:if test="${book.isbn==borrow.borrowPK.book && borrow.dateReturn gt now}">
                                 
                                            <td>  <fmt:formatDate type="both"  value="${borrow.borrowPK.dateBorrow}"/>  </td>
                                            <td>  <fmt:formatDate type="both"  value="${borrow.dateReturn}"/>  </td>
                                            <td>   
                                                <button type="submit" value = "Submit"  onclick="location.href = 'return.htm?isbn=${book.isbn}'" class="btn btn-primary  btn-block" >Return</button>
                                            </td>
                                            <td>   
                                                <button  type="submit" value = "Submit"  onclick="location.href = 'renew.htm?isbn=${book.isbn}'" class="btn btn-primary  btn-block" >Renew</button>
                                            </td>
                                            <td>   
                                                <button id = "readButton" type="submit" value = "Submit" onclick="location.href = 'read.htm?isbn=${book.isbn}'" class="btn btn-primary  btn-block" >read</button>
                                            </td>
                                            
                                            
                                        </c:if>
                                    </c:forEach>
                                            
                                            
                                </tr>
                                
                                
                                
                            </c:forEach>
                                
                            <c:if test ="${not empty readBook}">
                                    <tr><embed src=${readBook} width="800" height="500" type='application/pdf' id = "read" ></tr>
                                </c:if>    
                    </table>
                </div>




            </div>

        </div>

        <c:import url="footer.jsp"/>
         


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <style>
            th, td{
                padding: 10px;
            }

        </style>
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


