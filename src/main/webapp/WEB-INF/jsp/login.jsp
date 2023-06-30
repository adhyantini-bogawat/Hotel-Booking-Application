<%-- 
    Document   : login
    Created on : Jun 22, 2023, 4:04:07 PM
    Author     : Adhyantini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
       integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   <link rel="stylesheet" href="<c:url value="/resources/css/background.css"/>">
    </head>
    <body>
        <h1 style="text-align: center"> Hilton Booking Management System </h1>
        <h2 style="text-align: center"> Login </h2>
        
        <div class="container">
                <div class="card">
                    <div class="card-body">
                    <form action="login.htm" method="post">
                    <div class="form-group row">
                    <label for="emailID" class="col-sm-2 col-form-label"> Email ID </label>
                    <div class="col-sm-7">
                        <input type="text" name="emailID" placeholder="Email id">
                    </div>
                    </div>

                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label"> Password </label>
                        <div class="col-sm-7">
                        <input type="password" name="password" placeholder="password">
                        </div>
                    </div>
                        
                     <div class="form-group row">
                        <label for="role" class="col-sm-2 col-form-label"> Logging In As  </label>
                        <div class="col-sm-7">
                            User <input type="radio" name ="role" value="User"><br>
                       Admin <input type="radio" name="role" value="Admin">
                        </div>
                    </div>

                  
                 
            <button type="submit" class="btn btn-primary">Login </button>
   </form>
   </div>
  </div>
 </div>
        
        
        <br>
        <a href="registerUser.htm"> Sign up here </a>
    </body>
</html>
