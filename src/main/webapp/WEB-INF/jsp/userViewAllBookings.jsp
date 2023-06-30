<%-- 
    Document   : userViewAllBookings
    Created on : Jun 27, 2023, 8:34:59 PM
    Author     : Adhyantini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1 style="text-align: center"> View All Bookings </h1>
        <div class="topnav">
               <a class="active" href="showAvailableRooms.htm">Home</a>
               <a href="viewBookings.htm"> Bookings </a>
               <a href="#contact">Contact</a>
               <a href="#about">About</a>
               <a href="userlogout.htm"> Logout </a>
        </div>
        <c:choose>
            <c:when test="${requestScope.bookingDetails != null }">
               <h2> View Available Rooms </h2>
            <c:forEach var="bookingDetails" items="${requestScope.bookingDetails}">
			<div class="col-md-3 col-sm-6 sb">
				<div class="thumbnail">
					<div class="caption">
				            Room ID:
                                            <c:out value="${bookingDetails.roomId}"/>
                                            <br><br>
                                            CheckIn Date:
                                            <c:out value="${bookingDetails.checkin}"/>
                                            <br><br>
                                            Checkout Date:
                                            <c:out value="${bookingDetails.checkout}"/>
                                            <br><br>
                                            Status:
                                             <c:out value="${bookingDetails.status}"/>
					</div>
					
				</div>
			</div>
                                        <hr><hr>
	</c:forEach>
        
       </c:when>
       <c:otherwise>
            You have no current or previous bookings.
        </c:otherwise>
      </c:choose>
        
    </body>
</html>
