<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RSP</title>
    </head>

    <c:import url="nav.jsp"/>
    <body>
        <h1>Member Registration Successfully!!!</h1>
        <br>
        Dear ${member.firstName} ${member.lastName},
        <br>
        Your username is ${member.userName}

    </body>

    <c:import url="fooder.html"/>
</html>
