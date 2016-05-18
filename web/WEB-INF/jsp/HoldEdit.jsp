<%-- 
    Document   : member_profile
    Created on : May 8, 2016, 11:57:40 PM
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
            </div>
            <div class="col-lg-7 " style="margin-top: 80px;margin-bottom: 20px">
                <form:form action="onHold_view.htm?isbn=${book.isbn}" method="POST" commandName = "holdBean" >

                    <table>
                        
                        
                        
                        <tr>
                         <label for="suspend">Suspend Option:</label>
                                <form:select path = "suspend" items = "${suspendList}" style="margin-right: 40%; width: 60%"/>
                        </tr>

                        <tr>
                            <td><form:label path="email">Email: </form:label></td>
                            <td><form:input path ="email" class="form-control" type="text"
                                        value="${account.email}" /></td>
                        </tr>


                        <tr>
                            <label for="setting">Setting:</label>
                                <form:select path = "setting" items = "${settingList}" style="margin-right: 40%; width: 60%"/>

                        </tr>
                    </table>
                        <div>
                            <button type="submit" value = "Submit" onclick="updateCheck()" class="btn btn-primary btn-lg btn-block" >Update</button>
                        </div> 
                    </form:form>
            </div>

        </div>

    </div>
      



        <c:import url="footer.html"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <script>
                                function updateCheck() {
                                    var a1 = $("#1").val();
                                    var a2 = $("#2").val();
                                    if (a1 == null && a2 == null) {
                                        alert("Update Hold Successfully");
                                    }

                                }
        </script>
        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


