<%-- 
    Document   : gallery
    Created on : Apr 20, 2016, 1:16:49 PM
    Author     : Tian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Most Popular</h1>
        </div>
        <c:forEach var="book" items="${mostPopular}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">New eBooks</h1>
        </div>

       <c:forEach var="book" items="${newEBook}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>

    </div>
    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">New audio Books</h1>
        </div>

       <c:forEach var="book" items="${NewAudioBook}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>

    </div>
    
    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Recommendation</h1>
        </div>

       <c:forEach var="book" items="${recommendation}">
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>

    </div>
</html>
