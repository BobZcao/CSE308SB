
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
                                    <!-- div style="font-size:20px;">
                                        <Span><Strong>Sign up as:</Strong></Span>
                                        <select style="margin-right: 40%" id="selectSign" onchange="selectSignIn();">
                                            <option value="Member">Member</option>
                                            <option value="Faculty">Faculty</option>
                                            <option value="Publisher">Publisher</option>
                                        </select>
                                        </div> -->
                                    </br>


                                    <form:input path = "userName" class="form-control" 
                                                placeholder="Username" name= "reg_username" />

                                    <form:input path = "password"
                                                id="register_password" class="form-control" type="password"
                                                placeholder="Password" name= "reg_password" /> 



                                    <form:input path ="email" id="register_email"  name="reg_email" class="form-control" type="text"
                                                placeholder="E-Mail" />

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
                                    <!-- <input
                                             id="credit_card_number" class="form-control" type="text"
                                             placeholder="Credit Card Number" name="reg_cardnum" required>-->

                                    <!--     <div class="publisher" style="display:none">
                                            <input id="register_username" class="form-control" type="text"
                                                   placeholder="Username" name= "pub_username" required> 
                                            <input
                                                id="pub_password" class="form-control" type="password"
                                                placeholder="Password" name= "pub_password" required> 
                                            <input name="pub_password_confirm"
                                                   id="register_confirm_password" class="form-control"
                                                   type="password" placeholder="Confirm Password" required>
                                            <input id="company_name"  name="company_name" class="form-control" type="text"
                                                   placeholder="Company name" required>
                                            <input id="pub_address" name="pub_address"
                                                   class="form-control" type="text" placeholder="Address"
                                                   required> 
                                            <input
                                                id="pub_email" class="form-control" type="text"
                                                placeholder="Email" name= "pub_email" required> 
                                            <input name="pub_phone"
                                                   id="pub_phone" class="form-control"
                                                   type="text" placeholder="Phone" required>
        
                                        </div> -->
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

        <c:import url="fooder.html"/>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>

