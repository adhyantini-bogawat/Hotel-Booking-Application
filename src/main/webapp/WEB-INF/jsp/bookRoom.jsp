<%-- 
    Document   : bookRoom
    Created on : Jun 27, 2023, 3:38:19 PM
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
        <h1 style="text-align: center">Enter Details to Book Room</h1>
         <div class="topnav">
               <a class="active" href="showAvailableRooms.htm">Home</a>
               <a href="viewBookings.htm"> Bookings </a>
               <a href="#contact">Contact</a>
               <a href="#about">About</a>
               <a href="userlogout.htm"> Logout </a>
        </div>
            
            <div class="container">
                <div class="card">
                    <div class="card-body">
                     <form action="bookRoom.htm?id=${requestScope.roomDetail.getRoomID()}" method="POST">
                         <input type="hidden" name="roomid" value="${requestScope.roomDetail.getRoomID()}">
                    <div class="form-group row">
                    <label for="room-number" class="col-sm-2 col-form-label"> Firstname </label>
                    <div class="col-sm-7">
                        <input type="text" name="firstname" placeholder="Firstname">
                    </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomName" class="col-sm-2 col-form-label"> Lastname </label>
                        <div class="col-sm-7">
                        <input type="text" name="lastname" placeholder="Lastname">
                        </div>
                    </div>

                    <div class=" form-group row">
                        <label for="bedsize" class="col-sm-2 col-form-label">Email ID </label>
                        <div class="col-sm-7">
                         <input type="text" name="emailid" placeholder="Email ID">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomHighlights" class="col-sm-2 col-form-label"> Phone Number </label>
                        <div class="col-sm-7">
                        <input type="text" name="phone_number" placeholder="Phone Number">
                        </div>
                     </div>
                        
                   <div class="form-group row">
                        <label for="roomHighlights" class="col-sm-2 col-form-label"> Enter check-in date </label>
                        <div class="col-sm-7">
                        <input type="date" name="checkin">
                        </div>
                   </div>
                    
                     <div class="form-group row">
                        <label for="roomHighlights" class="col-sm-2 col-form-label"> Enter check-out date </label>
                        <div class="col-sm-7">
                        <input type="date" name="checkout" >
                        </div>
                   </div>
            <button type="submit" class="btn btn-primary"> Confirm Booking </button>
            <a href="showAvailableRooms.htm"> Go Back </a>
   </form>
   </div>
  </div>
 </div>
            
    </body>
</html>
