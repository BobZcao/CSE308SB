<%-- 
    Document   : display_page
    Created on : Apr 20, 2016, 11:32:27 AM
    Author     : Tian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <c:import url="header.html"/>
    <body>

        <c:import url="nav.jsp"/>
        <div class="container" style="margin-top:80px">
            <div class="row">
                <div class="col-lg-3" style="margin-top:20px">
                    <h2>Filter search by:</h2> 
                    <span> <a href="display_page_filterByAllTitle.htm">All Titles</a></span><br>
                    <span> <a href="display_page_filterByAvailableNow.htm">Available now</a></span><br>
                    <span> <a href="display_page_filterByAdditionalTitle.htm">additional titles to recommend</a></span><br>
                    <div class="panel-group" id="accordion" style="margin-top:40px">
                          
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Format</a>
                                </h4>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse in">
                                <div class="panel-body">
                             
                                    <c:forEach var="b" items="${formatList}">
                                         <span> <a href="display_format.htm?format=${b}">${b}</a></span><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Subject</a>
                                </h4>
                            </div>
                            <div id="collapse2" class="panel-collapse collapse in">
                                <div class="panel-body">
                             
                                    <c:forEach var="b" items="${subjectsList}">
                                         <span> <a href="display_subject.htm?subject=${b}">${b}</a></span><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        
                        
                        
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse"  href="#collapse3">Publisher</a>
                                </h4>
                            </div>
                            <div id="collapse3" class="panel-collapse collapse">
                                <div class="panel-body">
                                    
                                    <c:forEach var="b" items="${publisherList}">
                                         <span> <a href="display_publisher.htm?publisher=${b}">${b}</a></span><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse"  href="#collapse4">Rating</a>
                                </h4>
                            </div>
                            <div id="collapse4" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <c:forEach var="b" items="${ratingList}">
                                         <span> <a href="display_rating.htm?rating=${b}">${b}</a></span><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse"  href="#collapse5">Interest Level</a>
                                </h4>
                            </div>
                            <div id="collapse5" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <c:forEach var="b" items="${interestLevelList}">
                                         <span> <a href="display_interestLevel.htm?interestLevel=${b}">${b}</a></span><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                    </div> 
                </div>
                <div class="col-lg-8" style="font-size:150%;">
                    <h2>Book Title</h2>
                    <Span>Sort by:</Span>
                    <select style="margin-right: 40%" onChange="window.location.href=this.value">
                        <option value="#"></option>
                        <option value="diaplay_page_sortByRelevancy.htm">Relevancy</option>
                        <option value="diaplay_page_sortByTitleAZ.htm">Title A-Z</option>
                        <option value="diaplay_page_sortByTitleZA.htm">Title Z-A</option>
                        <option value="diaplay_page_sortByAuthorAZ.htm">Author A-Z</option>
                        <option value="diaplay_page_sortByAuthorZA.htm">Author Z-A</option>
                        <option value="diaplay_page_sortByReleaseDate.htm">Release Date</option>
                        <option value="diaplay_page_sortByAddedToSite.htm">Added to Site </option>
                        <option value="diaplay_page_sortByPopular.htm">Most Popular</option>

                    </select>
                    <button type="button" onclick="cover()" class="btn btn-primary"><span class="glyphicon glyphicon-th">Cover</span></button>

                    <button type="button" onclick="list()" class="btn btn-primary"><span class="glyphicon glyphicon-th-list">List</span></button><br><br><br>
                    <div class="cover">
                        <c:forEach var="book" items="${searchBookList}">
                            <div class="col-lg-4 col-md-3 col-xs-6 thumb">
                                <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                                    <img class="img-responsive" src="${book.imageUrl}" alt="">
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="list" style="display:none;">
                        <c:forEach var="book" items="${searchBookList}">
                            <div class="row">
                                <div class="col-lg-4" style="margin-top:20px">
                                    <a class="thumbnail" href="view.htm?isbn=${book.isbn}">
                                        <img class="img-responsive" src="${book.imageUrl}" alt="" style="width:220px" >
                                    </a>
                                    <button class="btn btn-default" style="margin-top: 10px; width: 100px; margin-left:100px;">Sample</button>
                                </div>      
                                <div class="col-lg-8"  >
                                    <a href="/view.htm?isbn=${book.isbn}">
                                        <h3>${book.title}</h3>
                                    </a>
                                    <p>By <a href="#">${book.author}</a></p>
                                    <button type="button" style="width:200px" class="btn btn-primary btn-lg btn-block">Borrow</button>
                                    <button type="button" style="width:200px" class="btn btn-warning btn-lg btn-block">Add to Wish List</button>
                                    <h4>Description</h4>
                                    <p>${book.description}</p>
                                </div>
                            </div>
                            <hr> 
                        </c:forEach>

                    </div>

                </div>

            </div>
        </div>

        <div>
            <ul class="pager" style="margin-top:20px">
                <li><a href="display_page_next.htm">Next</a></li>
                <li><a href="display_page_previous.htm">Previous</a></li>
                <li><a href="display_page_last.htm">Last</a></li>
                <li><a href="display_page_first.htm">First</a></li>
            </ul>
        </div>
         <c:import url="footer.jsp"/>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
        <script>
                        function list() {
                            $(".list").css("display", "inline");
                            $(".cover").css("display", "none");
                        }
                        function cover() {
                            $(".cover").css("display", "inline");
                            $(".list").css("display", "none");
                        }
        </script>
    </body>
</html>
