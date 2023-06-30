<%-- 
    Document   : adminViewAllBookings
    Created on : Jun 28, 2023, 12:08:58 PM
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
        <h1 style="text-align: center"> View All Bookings </h1>
        <p> Please Note: Do not forget to check out the guests after their stay is over. </p>
        
         <nav class="navbar navbar-dark bg-dark">
                <div class="navbar-nav">
               <a class="nav-item nav-link" href="adminHomePage.jsp">Home</a>
               <a class="nav-item nav-link" href="roomAdd.htm"> Add Room </a>
               <a class="nav-item nav-link" href="viewAll.htm">View Room</a>
               <a class="nav-item nav-link" href="viewAllBookings.htm"> View All Bookings </a>
               <a class="nav-item nav-link" href="logout.htm"> Logout </a>
        </div>
        </nav>
       <table border='1' style='border-collapse:collapse'>
            <tr>
                <td>Room ID</td>
                <td>Guest Firstname </td>
                <td>Guest Lastname </td>
                <td>Guest Email ID</td>
                <td> Status </td>
                <td> Check out </td>

            </tr>
        <c:choose> 
            <c:when test="${requestScope.bookings != null }">
                     <c:forEach var="booking" items="${requestScope.bookings}">
                            <tr>
                                    <td><c:out value="${booking.roomId}"/></td>
                                    <td><c:out value="${booking.firstname}"/></td>
                                    <td><c:out value="${booking.lastname}"/></td>
                                    <td><c:out value="${booking.emailID}"/></td>
                                    <td><c:out value="${booking.status}"/></td>
                                    <td> <a href="checkoutGuest.htm?id=${booking.bookingID}"> Check Out </a> </td>
                            </tr>
                    </c:forEach>
         
            </c:when>
         <c:otherwise>
            There are no Bookings.
        </c:otherwise>
        </c:choose> 
        </table>
        
    </body>
</html>
