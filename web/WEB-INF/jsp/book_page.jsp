
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
        <div id="fb-root"></div>
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>

        <script>!function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
                if (!d.getElementById(id)) {
                    js = d.createElement(s);
                    js.id = id;
                    js.src = p + '://platform.twitter.com/widgets.js';
                    fjs.parentNode.insertBefore(js, fjs);
                }
            }(document, 'script', 'twitter-wjs');</script>

        <script
            type="text/javascript"
            async defer
            src="//assets.pinterest.com/js/pinit.js"
        ></script>

        <c:import url="nav.jsp"/>

        <div class="container" style="margin-top:80px">
            <div class="row">
                <div class="col-lg-4" style="margin-top:20px">
                    <img class="img-responsive" src="${book.imageUrl}" alt="">
                    <button class="btn btn-default" style="margin-top: 10px; width: 200px; margin-left:50px;" onclick="window.open('${book.sample}')" >Sample</button>
                </div>
                <div class="col-lg-4">
                    <h2>${book.title}</h2>
                    <p>By <a href="#">${book.author}</a></p>
                        <c:choose>

                        <c:when test="${not empty borrow}">

                            <button type="button" class="btn btn-warning btn-lg btn-block" onclick="location.href = 'return.htm?isbn=${book.isbn}';">Return</button>
                        </c:when>

                        <c:when test="${not empty hold}">
                            <button type="button" class="btn btn-warning btn-lg btn-block" onclick="location.href = 'editHold.htm?isbn=${book.isbn}';">Edit Hold</button>
                        </c:when>

                        <c:when test="${book.licenses==0}">

                            <button type="button" class="btn btn-warning btn-lg btn-block" onclick="location.href = 'addRecommend.htm?isbn=${book.isbn}';">Recommend</button>
                        </c:when>

                        <c:when test="${book.available==0}">

                            <button type="button" class="btn btn-warning btn-lg btn-block" onclick="location.href = 'hold.htm?isbn=${book.isbn}';">Hold</button>
                        </c:when>



                        <c:otherwise>

                            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="location.href = 'borrow.htm?isbn=${book.isbn}';">Borrow</button>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${empty wishBook}" >
                        <button type="button" onclick="location.href = 'addWishList.htm?isbn=${book.isbn}'" class="btn btn-warning btn-lg btn-block"  >Add to Wish List</button>
                    </c:if>
                    <c:if test="${not empty wishBook}" >
                        <button type="button" onclick="location.href = 'removeFromWishList.htm?isbn=${book.isbn}'" class="btn btn-warning btn-lg btn-block"  >Remove From Wish List</button>
                    </c:if>
                    <h4>Description</h4>
                    <p>${book.description}</p>

                </div>

                <div class="col-lg-4" style="margin-top:20px">
                    <div class="fb-share-button" data-href="" data-layout="button" data-mobile-iframe="true"></div>
                    <a href="https://twitter.com/share" class="twitter-share-button">Tweet</a>
                    <a href="https://www.pinterest.com/pin/create/button/">
                        <img src="//assets.pinterest.com/images/pidgets/pinit_fg_en_rect_gray_20.png" />
                    </a>
                    <a href="mailto:?subject=I wanted you to see this site&amp;body=Check out this site http://www.website.com."
                       title="Share by Email">
                        <img src="https://cdn.shopify.com/s/files/1/0194/2989/t/3/assets/email-button.png?16850287810030628576">
                    </a>


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
                    <h2>Rating</h2>
                    <br>
                    <h3>Average Rating: ${not empty book.rating? book.rating:0.0}</h3>
                    <br>
                    <h3>Your rating :</h3>
                    <div>
                        <ul class="c-rating"></ul>
                    </div>
                    <div style="margin-top: 10px">
                        <c:if test="${not empty rating}">
                            <button type="button" class="btn btn-primary btn-lg btn-block" style="width:200px" onclick="removeRating()">Remove rating</button>
                        </c:if>
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
        <script src="js/dist/rating.min.js"></script>
        <script>
                                $(document).ready(function () {
                                    var ratingElement = document.querySelector(".c-rating");
                                    var currentRating = ${not empty rating? rating.rating:0};
                                    var maxRating = 5;
                                    var callback = function (rating) {
                                        var url = "rating.htm?isbn=" +${book.isbn} + "&&rating=" + rating;
                                        $.ajax({
                                            url: url,
                                            success: function (data) {
                                                if (data == "ok") {

                                                    location.replace("view.htm?isbn=" +${book.isbn})
                                                }
                                            }
                                        });
                                    };
                                    if (${empty account}) {
                                        callback = function (rating) {
                                            location.replace("loginPage.htm");
                                        }
                                    }
                                    var r = rating(ratingElement, currentRating, maxRating, callback);

                                });
                                function removeRating() {
                                    var url = "rating.htm?isbn=" +${book.isbn} + "&&rating=0";
                                    $.ajax({
                                        url: url,
                                        success: function (data) {
                                            if (data == "ok") {

                                                location.replace("view.htm?isbn=" +${book.isbn})
                                            }
                                        }
                                    });
                                }
        </script>
    </body>
</html>
