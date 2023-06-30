<%-- 
    Document   : adminHomePage
    Created on : Jun 22, 2023, 4:05:30 PM
    Author     : Adhyantini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1 style="text-align: center"> Hilton Hotel Management </h1><br><br>
        <h2 style="text-align: center">  Welcome Admin </h2>       
           <nav class="navbar navbar-dark bg-dark">
                <div class="navbar-nav">
               <a class="nav-item nav-link" href="adminHomePage.jsp">Home</a>
               <a class="nav-item nav-link" href="roomAdd.htm"> Add Room </a>
               <a class="nav-item nav-link" href="viewAll.htm">View Room</a>
               <a class="nav-item nav-link" href="viewAllBookings.htm"> View All Bookings </a>
               <a class="nav-item nav-link" href="logout.htm"> Logout </a>
        </div>
        </nav>
    </body>
</html>
