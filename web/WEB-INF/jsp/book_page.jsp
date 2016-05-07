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
                <div class="col-lg-4" style="margin-top:20px">
                    <img class="img-responsive" src="${book.imageUrl}" alt="">
                    <button class="btn btn-default" style="margin-top: 10px; width: 200px; margin-left:50px;">Sample</button>
                </div>
                <div class="col-lg-4">
                    <h2>${book.title}</h2>
                    <p>By <a href="#">${book.author}</a></p>
                    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="location.href = 'borrow.htm?isbn=${book.isbn}';">Borrow</button>
                    <button type="button" class="btn btn-warning btn-lg btn-block"  >Add to Wish List</button>

                    <h4>Description</h4>
                    <p>${book.description}</p>

                </div>

                <div class="col-lg-4" style="margin-top:20px">
                    <img class="icon pull-right" src="http://image005.flaticon.com/67/svg/69/69480.svg" alt="">
                    <img class="icon pull-right" src="http://image005.flaticon.com/67/svg/69/69407.svg" alt="">
                    <img class="icon pull-right" src="http://image005.flaticon.com/11/svg/9/9556.svg" alt="">

                    <div class="panel-group" id="accordion" style="margin-top:40px">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Subject</a>
                                </h4>
                            </div>
                            <div id="collapse2" class="panel-collapse collapse">
                                <div class="panel-body"><p>${book.subjects}</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Library copies</a>
                                </h4>
                            </div>
                            <div id="collapse3" class="panel-collapse collapse">
                                <div class="panel-body">${book.licenses}
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Available</a>
                                </h4>
                            </div>
                            <div id="collapse4" class="panel-collapse collapse">
                                <div class="panel-body">${book.available}
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8">
                    <h2>Review</h2>
                    <div class="ratings">
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <button class="btn btn-default" data-toggle="modal" data-target="#rate-modal">Rate</button>
                        </p>
                    </div>

                    <div class="detailBox">

                        <div class="actionBox">
                            <ul class="commentList">
                                <li>
                                    <div class="commenterImage">
                                        <img src="http://lorempixel.com/50/50/people/6" />
                                    </div>
                                    <div class="commentText">
                                        <p class="">Hello this is a test comment.</p> <span class="date sub-text">on March 5th, 2014</span>

                                    </div>
                                </li>
                                <li>
                                    <div class="commenterImage">
                                        <img src="http://lorempixel.com/50/50/people/7" />
                                    </div>
                                    <div class="commentText">
                                        <p class="">Hello this is a test comment and this comment is particularly very long and it goes on and on and on.</p> <span class="date sub-text">on March 5th, 2014</span>

                                    </div>
                                </li>
                                <li>
                                    <div class="commenterImage">
                                        <img src="http://lorempixel.com/50/50/people/9" />
                                    </div>
                                    <div class="commentText">
                                        <p class="">Hello this is a test comment.</p> <span class="date sub-text">on March 5th, 2014</span>

                                    </div>
                                </li>
                            </ul>
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Your comments" />
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-default">Add</button>
                                </div>
                            </form>
                        </div>
                    </div>



                </div>
            </div>

        </div>

        <!-- BEGIN # MODAL BORROW -->
        <div class="modal fade" id="borrow-modal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true"
             style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Begin # DIV Form -->
                    <div id="div-forms">

                        <!-- Begin # Login Form -->
                        <form id="borrow-form" action="#" method="post">
                            <div class="modal-body">
                                <p>Sorry, this book is temporarily unavailable.</p>
                                <p>Do you want to place a hold on this book?</p>
                                <label class="radio-inline"><input type="radio" name="optradio">Yes</label>
                                <label class="radio-inline"><input type="radio" name="optradio">No</label>
                            </div>
                            <div class="modal-footer">
                                <div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">submit</button>
                                </div>

                            </div>
                        </form>
                        <!-- End # Login Form -->
                    </div>
                    <!-- End # DIV Form -->

                </div>
            </div>
        </div>

        <!-- BEGIN # MODAL RATE -->
        <div class="modal fade" id="rate-modal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true"
             style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Begin # DIV Form -->
                    <div id="div-forms">

                        <!-- Begin # Login Form -->
                        <form id="rate-form" action="#" method="post">
                            <div class="modal-body">                                                   

                                <label class="radio" style="padding-left: 20px"><input type="radio" name="optradio">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </label>
                                <label class="radio" style="padding-left: 20px"><input type="radio" name="optradio">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </label>
                                <label class="radio" style="padding-left: 20px"><input type="radio" name="optradio">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </label>
                                <label class="radio" style="padding-left: 20px"><input type="radio" name="optradio">
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>                                 
                                </label>
                                <label class="radio" style="padding-left: 20px"><input type="radio" name="optradio">
                                    <span class="glyphicon glyphicon-star"></span>
                                </label>
                            </div>
                            <div class="modal-footer">
                                <div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">submit</button>
                                </div>

                            </div>
                        </form>
                        <!-- End # Login Form -->
                    </div>
                    <!-- End # DIV Form -->

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
