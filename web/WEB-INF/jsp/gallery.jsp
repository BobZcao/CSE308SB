<%-- 
    Document   : gallery
    Created on : Apr 20, 2016, 1:16:49 PM
    Author     : Tian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">New eBooks</h1>
        </div>
        <c:forEach var="book" items="${resultBookList}">
            <div class="col-lg-4 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="${book.imageUrl}" alt="" width="150" height="200">
                </a>
            </div>
        </c:forEach>

        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header">Most Popular</h1>
            </div>

            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>
            <div class="col-lg-2 col-md-3 col-xs-6 thumb">
                <a class="thumbnail" href="#">
                    <img class="img-responsive" src="http://placehold.it/150x200" alt="">
                </a>
            </div>

        </div>
</html>
