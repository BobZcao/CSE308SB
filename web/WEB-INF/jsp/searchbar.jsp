<%-- 
    Document   : searchbar
    Created on : Apr 29, 2016, 5:45:23 PM
    Author     : code
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
      <div class="row" style="text-align: center">
        <div class="col-lg-12">
            <form:form action="display_page.htm" method="POST" class="navbar-form page-header" role="search" id="search" commandName= "searchBean">
                <div class="form-group" style="width: 50%">
                    
                    <form:input path = "keywords" type="text"
                                name = "keywords" class="form-control" 
                                placeholder="Search" style="width:100%"/>
                    
                </div>
                <button type="submit" value="Submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button> 
            </form:form>
            <a href="advanced_search.htm">Advanced Search </a>
        </div>
    </div>
</html>
