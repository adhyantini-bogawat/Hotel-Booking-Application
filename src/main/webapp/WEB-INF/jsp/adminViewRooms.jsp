<%-- 
    Document   : adminViewRooms
    Created on : Jun 22, 2023, 6:08:06 PM
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
       <h1 style="text-align: center"> View All Rooms Added </h1>
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
                <td>Room Number</td>
                <td>Room Name</td>
                <td>Bed Size</td>
                <td>Room Highlights</td>
                <td>Room Image</td>
                <td> Update Room </td>
                <td> Delete Room </td>
            </tr>
        <c:choose> 
            <c:when test="${requestScope.roomList != null }">
                     <c:forEach var="room" items="${requestScope.roomList}">
                            <tr>
                                    <td><c:out value="${room.roomNumber}"/></td>
                                    <td><c:out value="${room.roomName}"/></td>
                                    <td><c:out value="${room.bedsize}"/></td>
                                    <td><c:out value="${room.roomHighlights}"/></td>
                                    <td><img src="<c:out value="${room.photoFilePath}"/>"/></td>
                                    <td> <a href="updateRoom.htm?id=${room.roomID}"> Update </a> </td>
                                    <td> <a href="deleteRoom.htm?id=${room.roomID}"> Delete </a> </td>
                            </tr>
                    </c:forEach>
         
            </c:when>
         <c:otherwise>
            There are no rooms. <a href="roomAdd.htm">Click here</a> to add rooms.
        </c:otherwise>
        </c:choose> 
        </table>
    </body>
</html>
