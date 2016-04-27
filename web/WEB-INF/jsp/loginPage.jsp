
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <div class="header"></div>

    <body>
        <div class="navigation"></div>
        <div class="tab-pane" id="search" >

            <div class="container" style = "margin-top:40px">
                <div class="content-container clearfix">

                    <div class="col-md-12">
                        <div  style="font-size:150%;">
                            <form:form action="login.htm" method="POST" id="loginForm" commandName="loginBean" >
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

                                  
                                </div>
                                <div class="modal-footer">

                                    <div>
                                        <button type="submit" value = "Submit" class="btn btn-primary btn-lg btn-block" >Sign in</button>
                                    </div>

                                </div>

                                <!-- End | Register Form -->

                            </div>

                        </form:form>
                    </div>
                </div>
            </div>

        </div>

        <div class="footer"></div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>

