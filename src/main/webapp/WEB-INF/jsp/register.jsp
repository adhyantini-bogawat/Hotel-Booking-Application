<%-- 
    Document   : register
    Created on : Jun 22, 2023, 4:04:38 PM
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
        <h1 style="text-align: center">Hilton Booking Management System </h1>
        <h2 style="text-align: center"> Sign Up </h2>      
            
      <div class="container">
                <div class="card">
                    <div class="card-body">
                    <form:form action="registerUser.htm" modelAttribute="userRegister" method="post">
                    <div class="form-group row">
                    <label for="emailID" class="col-sm-2 col-form-label"> Email ID </label>
                    <div class="col-sm-7">
                        <form:input path="emaildID"/>   <form:errors path="emaildID" />
                    </div>
                    </div>

                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label"> Password </label>
                        <div class="col-sm-7">
                         <form:input path="password"/>   <form:errors path="password" />  
                        </div>
                    </div>
                        
                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label">Confirm Password </label>
                        <div class="col-sm-7">
                        <form:input path="confirm_password"/> <form:errors path="confirm_password" /> 
                        </div>
                    </div>
                        
                        
                     <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> Phone Number </label>
                        <div class="col-sm-7">
                         <form:input path="phone"/>   <form:errors path="phone" />  
                        </div>
                    </div>
                        
                     <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> Address Line 1 </label>
                        <div class="col-sm-7">
                         <form:input path="address_line1"/>   <form:errors path="address_line1" /> 
                        </div>
                    </div>
                        
                     <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> Address Line 2 </label>
                        <div class="col-sm-7">
                         <form:input path="address_line2"/>  
                        </div>
                    </div>
                        
                     <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> City </label>
                        <div class="col-sm-7">
                         <form:input path="city"/>  <form:errors path="city" />  
                        </div>
                    </div>
                        
                      <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> State </label>
                        <div class="col-sm-7">
                          <form:input path="state"/>  <form:errors path="state" />
                        </div>
                    </div>
                        
                     <div class="form-group row">
                        <label for="phone-number" class="col-sm-2 col-form-label"> Zipcode </label>
                        <div class="col-sm-7">
                          <form:input path="zipcode"/> <form:errors path="zipcode" />  
                        </div>
                    </div>

                  
                 
            <input type="submit" class="btn btn-primary" value="Register"/>
    </form:form>
   </div>
  </div>
 </div>      
                 
   <a href="login.htm"> Already registered? Login here </a>
    </body>
</html>
