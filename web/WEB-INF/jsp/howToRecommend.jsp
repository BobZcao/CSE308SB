<%-- 
    Document   : howToRecommend
    Created on : May 17, 2016, 11:22:06 PM
    Author     : Tian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <c:import url="header.html"/>
    <body>

        <c:import url="nav.jsp"/>
        <div class="container" style="margin-top:80px">
            <h3>How to recommend titles that you'd like your library to add to its collection</h3>
            <div class="large-12 columns nextgen" style="display: block;">
                <p>If your library has the <strong>Recommend</strong> feature, you can use the steps below to browse through digital titles that your library doesn't own yet. You can then make recommendations to let your library know what you'd like to be added to the digital collection.</p>
                <p><em><strong>Note</strong>: If you recommend a title to your library, there is no guarantee they will purchase it.</em>
                </p>
                <ol>
                    <li value="1">After you search for something in your library's digital collection, click or tap the <strong>Add titles you can recommend</strong> button (you may have to scroll to the bottom of the page to see it).<br></li>
                    <li value="2">Once you select this button, the site will run your original search again, showing titles your library doesn't own yet in your results. You can then continue to sort and filter your results to find exactly what you're looking for.<br><em><strong>Note:</strong> Another way to add recommendable titles to your search results is by selecting <strong>Additional Titles to Recommend</strong> in the search filters (if available) or in the advanced search.</em> <br></li>
                    <li value="3">To determine which titles you can recommend to your library, look for the recommend icon.<br></li>
                    <li value="4">To recommend a title,  mouse over it (or tap it, on a mobile device) and select the <strong>Recommend</strong> button. If prompted, sign in.<br></li>
                    <li value="5">When you select <strong>Recommend</strong>, a new page will open where you can choose to be notified or placed on the holds list if your library purchases the title. <br></li>
                    <li value="6">Select <strong>Recommend this title</strong> to complete your recommendation. </li>
                </ol>
                <p>Your library can limit how many titles you're allowed to recommend in a given period of time, so if you've hit your limit, just wait a few days, then try again.</p>
                <p>You can view a list of titles you've recommended under your <em>Account &gt; Lists &gt; Titles you recommended.</em> Once you recommend a title to your library, you cannot remove it from your "Titles you recommended" list because your library has already been alerted that you've made the request.</p>
                <p>You may also be able to use the <strong>Buy It Now</strong> feature (if your library offers it) to purchase digital titles for your own collection.</p>
            </div>
        </div>
        <c:import url="footer.html"/><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

        <!-- Customized js files -->
        <script src="bootstrap-3.3.6-dist/js/script.js"></script>
    </body>
</html>
