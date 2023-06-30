<%-- 
    Document   : roomDetails
    Created on : Jun 22, 2023, 5:26:31 PM
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
        <h1 style="text-align: center">Room Details are as follows : </h1>
         <div class="topnav">
               <a class="active" href="showAvailableRooms.htm">Home</a>
               <a href="viewBookings.htm"> Bookings </a>
               <a href="#contact">Contact</a>
               <a href="#about">About</a>
               <a href="userlogout.htm"> Logout </a>
        </div>
        <br><br>
        <form action="roomDetails.htm?id=${requestScope.roomDetail.getRoomID()}" method="POST">
            Room Name: <c:out value="${requestScope.roomDetail.getRoomName()}"/> <br><br>
            Room Number: <c:out value="${requestScope.roomDetail.getRoomNumber()}"/> <br><br>
            Bed Size: <c:out value="${requestScope.roomDetail.getBedsize()}"/><br><br>
            Highlights:<c:out value="${requestScope.roomDetail.getRoomHighlights()}"/>
            <br><br>
            <a href="bookRoom.htm?id=${requestScope.roomDetail.getRoomID()}"> Book This </a>
        </form>
    </body>
</html>
