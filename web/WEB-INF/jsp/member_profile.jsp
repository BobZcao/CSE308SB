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
                         <a href="recommend.htm" class="list-group-item">Recommend</a>
                    </div>
                </div>

                <div class="col-lg-7 " style="margin-top: 80px;margin-bottom: 20px">
                    <form:form action="member_profile.htm" method="POST" commandName = "member" >

                        <table>      
                            <tr>
                                <td><form:label path="userName">User Name: </form:label></td>
                                <td> <form:input path = "userName" class="form-control" value="${account.userName}"
                                            name= "reg_username" readOnly="true"/></td>
                            </tr>
                            <tr> <form:errors  path = "userName" cssStyle="color:#ff0000;"/></tr>
                            <tr>
                                <td><form:label path="password">Password: </form:label></td>
                                <td><form:input path = "password" value="${account.passwords}"
                                            id="register_password" class="form-control" type="password"
                                            name= "reg_password" /> </td>
                            </tr>

                            <form:errors path = "password" id="1" cssStyle="color:#ff0000;"/>
                            <tr>
                                <td><form:label path="passwordConf">Confirm Password: </form:label></td>
                                <td><form:input path = "passwordConf"
                                            name="pub_password_confirm"
                                            id="register_confirm_password" class="form-control"
                                            type="password" value="${account.passwords}"/></td>
                            </tr>
                            <tr><td> <form:errors path = "passwordConf" id="2" cssStyle="color:#ff0000;"/></td></tr>
                            <tr>
                                <td><form:label path="email">Email: </form:label></td>
                                <td><form:input path ="email" id="register_email"  name="reg_email" class="form-control" type="text"
                                            value="${account.email}" /></td>
                            </tr>
                            <tr><td><form:errors path = "email" cssStyle="color:#ff0000;"/></td></tr>
                            <tr>
                                <td><form:label path="firstName">First Name: </form:label></td>
                                <td><form:input path = "firstName" id="first_name" name="reg_firstname"
                                            value="${account.firstName}" class="form-control"  
                                            /> </td>
                            </tr>
                            <tr>
                                <td><form:label path="lastName">Last Name: </form:label></td>
                                <td> <form:input path = "lastName" id="last_name" class="form-control" name="reg_lastname"
                                            type="text" value="${account.lastName}" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="street">Street: </form:label></td>

                                    <td><form:input path = "street" name="reg_address"
                                            id="address" class="form-control"
                                            value="${account.street}" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="city">City: </form:label></td>
                                <td><form:input path = "city" id="city" name="reg_city"
                                            class="form-control" value="${account.city}" /> </td>
                            </tr>
                            <td><form:label path="state">State: </form:label></td>
                            <td><form:input path = "state" id="state" class="form-control" name="reg_state"
                                        value="${account.state}" /> </td>
                            </tr>
                            <tr>
                                <td><form:label path="zipCode">Zip Code: </form:label></td>
                                <td><form:input path = "zipCode" id="zipcode" name="reg_zipcode"
                                            class="form-control"  value="${account.zipCode}" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="telephone">Telephone: </form:label></td> 
                                <td><form:input path = "telephone" id="telephone" class="form-control" 
                                            value="${account.telephone}" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="font">Font: </form:label></td>
                                <td><form:input path = "font" id="font" class="form-control" 
                                            value="${account.font}" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="contrast">Contrast: </form:label></td>
                                <td><form:input path = "contrast" id="contrast" class="form-control" 
                                            value="${account.contrast}" /></td>
                            </tr>

                            <tr>
                                <td><form:label path="ageContent">Age Content: </form:label></td>
                                <td><form:select path="ageContent">
                                        <form:option value="All Age" label="All Age" />
                                         <form:option value="Teen" label="Teen" />
                                        <form:option value="Child" label="Child" />
                                    </form:select></td>
                            </tr>
                            <tr>
                                <td><form:label path="lendingPeriod">Lending Period: </form:label></td>
                                 <td><form:select path="lendingPeriod">
                                        <form:option value="3" label="3" />
                                        <form:option value="7" label="7" />
                                        <form:option value="15" label="15" />
                                    </form:select></td>
                            </tr>
                        </table>             

                        <div>
                            <button type="submit" value = "Submit" onclick="updateCheck()" class="btn btn-primary btn-lg btn-block" >Update</button>
                        </div> 


                    </form:form>
                </div>
            </div>



        </div>



        <c:import url="footer.jsp"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
        <script>
            function updateCheck(){
                var a1=$("#1").val();
                 var a2=$("#2").val();
                if (a1== null && a2==null){
                    alert("Update Account Successfully");
            }
           
        }
            </script>
        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


