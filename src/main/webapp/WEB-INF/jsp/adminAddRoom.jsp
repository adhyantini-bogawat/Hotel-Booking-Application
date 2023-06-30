<%-- 
    Document   : adminAddRoom
    Created on : Jun 26, 2023, 11:23:17 AM
    Author     : Adhyantini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
       integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   <link rel="stylesheet" href="<c:url value="/resources/css/background.css"/>">
    </head>
    <body>
        <h1 style="text-align: center"> Hilton Hotel Management </h1>
        <h2> Add Available Rooms </h2>
        
               <nav class="navbar navbar-dark bg-dark">
                <div class="navbar-nav">
               <a class="nav-item nav-link" href="adminHomePage.jsp">Home</a>
               <a class="nav-item nav-link" href="roomAdd.htm"> Add Room </a>
               <a class="nav-item nav-link" href="viewAll.htm">View Room</a>
               <a class="nav-item nav-link" href="viewAllBookings.htm"> View All Bookings </a>
               <a class="nav-item nav-link" href="logout.htm"> Logout </a>
        </div>
        </nav>
            
         <div class="container">
                <div class="card">
                    <div class="card-body">
                     <form:form action="roomAdd.htm" modelAttribute="room" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                    <label for="room-number" class="col-sm-2 col-form-label">Room Number</label>
                    <div class="col-sm-7">
                        <form:input path="roomNumber"/> 
                    </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomName" class="col-sm-2 col-form-label">Room Name</label>
                        <div class="col-sm-7">
                        <form:input path="roomName"/>
                        </div>
                    </div>

                    <div class=" form-group row">
                        <label for="bedsize" class="col-sm-2 col-form-label">Bed Size</label>
                        <div class="col-sm-7">
                         <form:input path="bedsize"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomHighlights" class="col-sm-2 col-form-label">Room Highlights</label>
                        <div class="col-sm-7">
                        <form:input path="roomHighlights"/>
                        </div>
                     </div>
                        
                    <div class="form-group row">
                        <label for="Photo" class="col-sm-2 col-form-label">Room Photo</label>
                        <div class="col-sm-7">
                         <input type="file" name="photo" required="required"/>
                        </div>
                     </div>

                   

                        <input type="submit" class="btn btn-primary" value="Post Room"/>
    </form:form>
   </div>
  </div>
 </div>
            
            
    </body>
</html>
