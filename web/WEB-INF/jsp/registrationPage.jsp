
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <c:import url="header.html"/>

    <body>
        <c:import url="nav.jsp"/>
        
        <div class="tab-pane" id="search" >

            <div class="container" style = "margin-top:40px">
                <div class="content-container clearfix">

                    <div class="col-md-12">
                        <div  style="font-size:150%;">
                        <form:form action="registrationSuccessPage.htm" method="POST" commandName = "member" >
                        <div class="modal-body">
                            
                            </br>
                               
                              
                                    <form:input path = "userName" class="form-control" 
                                           placeholder="Username" name= "reg_username" />
                                   <form:errors path = "userName" cssStyle="color:#ff0000;"/>
                                   
                                    <form:input path = "password"
                                        id="register_password" class="form-control" type="password"
                                        placeholder="Password" name= "reg_password" /> 
                                    <form:errors path = "password" cssStyle="color:#ff0000;"/>
                                    
                                    <form:input path = "passwordConf"
                                           name="pub_password_confirm"
                                           id="register_confirm_password" class="form-control"
                                           type="password" placeholder="Confirm Password" />
                                    <form:errors path = "passwordConf" cssStyle="color:#ff0000;"/>
                                    
                                    <form:input path ="email" id="register_email"  name="reg_email" class="form-control" type="text"
                                           placeholder="E-Mail" />
                                    <form:errors path = "email" cssStyle="color:#ff0000;"/>
                                    
                                    
                                    <form:input path = "firstName" id="first_name" name="reg_firstname"
                                                class="form-control"  placeholder="First Name"
                                                /> 

                                    <!--<input type="text" class="form-control" id="reg_ssn" name="reg_ssn" placeholder="SSN"
                                           required>-->

                                    <form:input path = "lastName" id="last_name" class="form-control" name="reg_lastname"
                                                type="text" placeholder="Last Name" />

                                    <form:input path = "street" name="reg_address"
                                                id="address" class="form-control"
                                                placeholder="Address" />
                                    <form:input path = "city" id="city" name="reg_city"
                                                class="form-control" placeholder="City" />
                                    <form:input path = "state" id="state" class="form-control" name="reg_state"
                                                placeholder="State" /> 
                                    <form:input path = "zipCode" id="zipcode" name="reg_zipcode"
                                                class="form-control"  placeholder="Zipcode" />
                                    <form:input path = "telephone" id="telephone" class="form-control" 
                                                placeholder="Telephone" />
                       
                                     <form:input path = "font" id="font" class="form-control" 
                                                placeholder="Telephone" />
                                    <form:input path = "contrast" id="contrast" class="form-control" 
                                                placeholder="contrast" />
                                    <form:input path = "ageContent" id="ageContent" class="form-control" 
                                                placeholder="ageContent" />
                                    <form:input path = "lendingPeriod" id="lendingPeriod" class="form-control" 
                                                placeholder="lendingPeriod" />
                                    
                                     
                                <div  style="font-size:150%;">
                                <label for="subjects">Please select Your role:</label>
                                <form:select path = "level" items = "${level}" style="margin-right: 40%; width: 60%"/>
                                </div>

                           
                                   
                                </div>
                                <div class="modal-footer">

                                    <div>
                                        <button type="submit" value = "Submit" class="btn btn-primary btn-lg btn-block" >Sign up</button>
                                    </div>

                                </div>

                                <!-- End | Register Form -->

                            </div>

                        </form:form>
                    </div>
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

