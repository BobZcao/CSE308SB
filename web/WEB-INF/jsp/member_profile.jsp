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
                        <a href="#"  class="list-group-item">Profile</a>
                        <a href="#" class="list-group-item">Checked Out</a>
                        <a href="#" class="list-group-item">On Hold</a>
                        <a href="#" class="list-group-item">Wish List</a>
                        <a href="#" class="list-group-item">Rated books</a>
                    </div>
                </div>
            
                <div class="col-lg-7 " style="margin-top: 80px;margin-bottom: 20px">
                    <form:form action="member_profile.htm" method="POST" commandName = "member" >
     
                           
                              
                                <form:input path = "userName" class="form-control" value="${account.userName}"
                                            name= "reg_username" disabled="true"/>
                                   <form:errors path = "userName" cssStyle="color:#ff0000;"/>
                                   
                                    <form:input path = "password" value="${account.passwords}"
                                        id="register_password" class="form-control" type="password"
                                         name= "reg_password" /> 
                                    <form:errors path = "password" cssStyle="color:#ff0000;"/>
                                    
                                    <form:input path = "passwordConf"
                                           name="pub_password_confirm"
                                           id="register_confirm_password" class="form-control"
                                           type="password" value="${account.passwords}"/>
                                    <form:errors path = "passwordConf" cssStyle="color:#ff0000;"/>
                                    
                                    <form:input path ="email" id="register_email"  name="reg_email" class="form-control" type="text"
                                           value="${account.email}" />
                                    <form:errors path = "email" cssStyle="color:#ff0000;"/>
                                                                    
                                    <form:input path = "firstName" id="first_name" name="reg_firstname"
                                                value="${account.firstName}" class="form-control"  
                                                /> 
                                    <form:input path = "lastName" id="last_name" class="form-control" name="reg_lastname"
                                                type="text" value="${account.lastName}" />

                                    <form:input path = "street" name="reg_address"
                                                id="address" class="form-control"
                                                value="${account.street}" />
                                    <form:input path = "city" id="city" name="reg_city"
                                                class="form-control" value="${account.city}" />
                                    <form:input path = "state" id="state" class="form-control" name="reg_state"
                                                value="${account.state}" /> 
                                    <form:input path = "zipCode" id="zipcode" name="reg_zipcode"
                                                class="form-control"  value="${account.zipCode}" />
                                    <form:input path = "telephone" id="telephone" class="form-control" 
                                                value="${account.telephone}" />
                                    <form:input path = "font" id="font" class="form-control" 
                                                value="${account.font}" />
                                    <form:input path = "contrast" id="contrast" class="form-control" 
                                                placeholder="contrast" />
                                    <table><tr>
                                         <td><form:label path="ageContent">Age Content: </form:label></td>
                                     <td><form:select path="ageContent">
                  <form:option value="All Age" label="All Age" />
                  <form:option value="Adult" label="Adult" />
                  <form:option value="Child" label="Child" />
                                         </form:select></td>
                                        </tr>                    
        </table>
                                    <form:input path = "lendingPeriod" id="lendingPeriod" class="form-control" 
                                                placeholder="lendingPeriod" />
                     
                                    

                                    <div>
                                        <button type="submit" value = "Submit" class="btn btn-primary btn-lg btn-block" >Update</button>
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

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>


