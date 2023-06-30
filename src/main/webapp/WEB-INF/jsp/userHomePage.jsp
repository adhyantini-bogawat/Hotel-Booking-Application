<%-- 
    Document   : userHomePage
    Created on : Jun 22, 2023, 4:05:42 PM
    Author     : Adhyantini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
        <h1 style="text-align: center"> Hilton Booking Management System</h1>
        <div class="topnav">
               <a class="active" href="showAvailableRooms.htm">Home</a>
               <a href="viewBookings.htm"> Bookings </a>
               <a href="#contact">Contact</a>
               <a href="#about">About</a>
               <a href="userlogout.htm"> Logout </a>
        </div>
        
        <br> <br> <br>
        <form action="showAvailableRooms" method="POST">
            <c:choose>
            <c:when test="${requestScope.userViewRooms != null }">
               <h2> View Available Rooms </h2>
            <c:forEach var="room" items="${requestScope.userViewRooms}">
			<div class="col-md-3 col-sm-6 sb">
				<div class="thumbnail">
                                    <c:out value="${room.photoFilePath}"/>
                                    <img src="/rooms/<c:out value="${room.photoFilePath}"/>"/>
					<div class="caption">
						<h4>
							<c:out value="${room.roomName}"/>
						</h4>
					</div>
					<p>
						<a class="btn btn-primary" href="roomDetails.htm?id=${room.roomID}">More Info</a>
					</p>
				</div>
			</div>
                                        <hr><hr>
	</c:forEach>
        
       </c:when>
       <c:otherwise>
            There are no rooms available. Please check back later
        </c:otherwise>
      </c:choose>
        </form>
        
    </body>
</html>
