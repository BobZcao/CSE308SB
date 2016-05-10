<%-- 
    Document   : advanced_search
    Created on : May 2, 2016, 2:46:09 PM
    Author     : code
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>

    <div class="header"></div>

    <body>

        <div class="navigation"></div>

        <div class="tab-pane" id="search" >

            <div class="container" style = "margin-top:40px">
                <div class="content-container clearfix">

                    <div class="col-md-12">
                        <form:form action = "display_page.htm" method = "POST" commandName="searchBean">
                            <div class="form-group">
                                <form:input path = "title" type="text"
                                            class="form-control" placeholder="Title" />
                            </div>
                            
                            <div class="form-group">
                                <form:input path = "ISBN" id="tokenfield"
                                            type="text" class="form-control"
                                            placeholder="ISBN" />
                            </div>
                            <div class="form-group">
                                <form:input path ="author" type="text" 
                                            class="form-control" placeholder="Author" />
                            </div>
                            
                            <div  style="font-size:150%;">
                                <label for="addedToSite">Added to site:</label>
                                <form:select path = "addedToSite" items = "${addedToSite}" style="margin-right: 40%; width: 60%"/>

                            </div>
                            
                             <div  style="font-size:150%;">
                                <label for="subjects">Subject(genre):</label>
                                <form:select path = "subjects" items = "${subjectsList}" style="margin-right: 40%; width: 60%"/>

                            </div>

                            <div  style="font-size:150%;">
                                <label for="subjects">Format:</label>
                                <form:select path = "format" items = "${formatList}" style="margin-right: 40%; width: 60%"/>

                            </div>

                            <div  style="font-size:150%;">
                                <label for="subjects">Language:</label>
                                <form:select path = "language" items = "${languageList}" style="margin-right: 40%; width: 60%"/>

                            </div>

                            <div  style="font-size:150%;">
                                <label for="subjects">Publisher:</label>
                                <form:select path = "publisher" items = "${publisherList}" style="margin-right: 40%; width: 60%"/>

                            </div>

                            <div  style="font-size:150%;">
                                <label for="subjects">Awards:</label>
                                <form:select path = "award" items = "${awardList}" style="margin-right: 40%; width: 60%"/>

                            </div>

                             <div  style="font-size:150%;">
                                <label for="subjects">Reading level range:</label>
                                <form:select path = "readingLevelRange" items = "${levelRange}" style="margin-right: 40%; width: 60%"/>

                            </div>
                                
                              

                            <div class="btn-send">
                                <a href="display_page.html" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-send"></span> Search</a>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
        <script src="bootstrap-3.3.6-dist/js/jquery-ui-timepicker-addon.js"></script>
    
    </body>
</html>