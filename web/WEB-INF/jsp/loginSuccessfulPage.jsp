<%-- 
    Document   : loginSuccessfulPage
    Created on : Apr 20, 2016, 5:13:09 PM
    Author     : code
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <h1>Log in Successfully!!!</h1>
        <br>
        Dear ${account.userName},
        <br>
        Welcome to library!
        <button href="#" onclick = "location.href='index.htm'">go to home page</button>
    </body>
    </body>
</html>
