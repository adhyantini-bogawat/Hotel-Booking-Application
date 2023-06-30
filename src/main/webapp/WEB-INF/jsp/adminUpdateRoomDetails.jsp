<%-- 
    Document   : adminUpdateRoomDetails
    Created on : Jun 22, 2023, 6:14:13 PM
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
        <h1 style="text-align: center">Update Room Details </h1>     
        <div class="container">
                <div class="card">
                    <div class="card-body">
                     <form action="updateRoom.htm?id=${requestScope.room.getRoomID()}" method="POST">
                            <div class="form-group row">
                            <label for="room-number" class="col-sm-2 col-form-label">Room Number</label>
                            <div class="col-sm-7">
                                <input type="text" name="roomNumber" placeholder="${requestScope.room.getRoomNumber()}"/>
                            </div>
                            </div>

                    <div class="form-group row">
                        <label for="roomName" class="col-sm-2 col-form-label">Room Name</label>
                        <div class="col-sm-7">
                        <input type="text" name="roomName" placeholder="${requestScope.room.getRoomName()}"/>
                        </div>
                    </div>

                    <div class=" form-group row">
                        <label for="bedsize" class="col-sm-2 col-form-label">Bed Size</label>
                        <div class="col-sm-7">
                         <input type="text" name="bedsize" placeholder="${requestScope.room.getBedsize()}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="roomHighlights" class="col-sm-2 col-form-label">Room Highlights</label>
                        <div class="col-sm-7">
                        <input type="text" name="roomHighlights" placeholder="${requestScope.room.getRoomHighlights()}"/>
                        </div>
                     </div>

                   
                  <button type="submit"class="btn btn-primary" > Update Room </button>
 </form>
   </div>
  </div>
 </div>
                
            
    </body>
</html>
