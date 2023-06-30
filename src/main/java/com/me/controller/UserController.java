/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.me.controller;

import com.me.dao.BookingInfoDAO;
import com.me.dao.RoomDAO;
import com.me.dao.UserDAO;
import com.me.pojo.BookingInfo;
import com.me.pojo.Room;
import com.me.pojo.User;
import com.me.validator.userValidator;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.apache.commons.mail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Adhyantini
 */

@Controller
public class UserController {
      @Autowired
      userValidator validator;
      
    @GetMapping("/login.htm")
    public String showLoginForm() {
        return "login";
    }
    
    
     @PostMapping("/login.htm")
    public String loginCheck(HttpServletRequest request, UserDAO userdao) {
        String emailID = request.getParameter("emailID");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        if (userdao.validUser(emailID, password)) {
            User user = userdao.getUser(emailID, password);
            HttpSession session = request.getSession();
	    session.setAttribute("loggedIn", user);
            System.out.println("Inside the USER CONTROLLLERRRRR ====== " + role);
            
            if (role.equalsIgnoreCase("User")){
                return "redirect:/showAvailableRooms.htm";
            } else {
                return "adminHomePage";
            }
            
            //put the user name or user id in the session
        }
        else
            return "login";
    }
    
//    @GetMapping("/registerUser.htm")
//    public String getUserRegistrationForm() {
//        return "register";
//    }
    
//    @PostMapping("/registerUser.htm")
//    public String postUserRegistrationForm(HttpServletRequest request, UserDAO userdao) {
//        String emailID = request.getParameter("emailID");
//        String password = request.getParameter("password");
//        String conf_password = request.getParameter("conf_password");
//        long phone = Long.parseLong(request.getParameter("phone"));
//        String addressLine1 = request.getParameter("addressLine1");
//        String addressLine2 = request.getParameter("addressLine2");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
//        
//        userdao.saveUser(emailID, password, conf_password, phone, addressLine1, addressLine2, city, zipcode, state);
//        
//        return "login";
//    }
    
    
    @GetMapping("/registerUser.htm")
    public String getUserRegistrationForm(ModelMap model) {
        System.out.println("Inside show register form");
        model.addAttribute("userRegister",  new User());
        return "register";
    }

    @PostMapping("/registerUser.htm")
    public String postUserRegistrationForm(@ModelAttribute("userRegister") User user, BindingResult result, SessionStatus status, UserDAO userdao) {
       
        validator.validate(user, result);
         if (result.hasErrors()) {
            return "register";
        }

        //Mark the current handler's session processing as complete, allowing for cleanup of session attributes
        status.setComplete();

        //persist the Book object
        
        userdao.saveUser(user);
        
        return "login";
    }
    
    
    @GetMapping("/showAvailableRooms.htm")
    public ModelAndView getAvailableForms(RoomDAO roomdao) {
        return new ModelAndView("userHomePage", "userViewRooms", roomdao.getAllRooms());
    }
    
     @GetMapping("/roomDetails.htm")
    public ModelAndView getRoomDetails(HttpServletRequest request,RoomDAO roomdao) {
        String id = request.getParameter("id");
        String sId = id.replaceAll("'", "");
        return new ModelAndView("roomDetails", "roomDetail", roomdao.getRoomById(sId));
    }
    
    @GetMapping("/bookRoom.htm")
    public ModelAndView getBookRoom(RoomDAO roomdao,HttpServletRequest request) {
                String id = request.getParameter("id");
                System.out.println(" THE ID INSIDE get UPDATE ISSSSS "+ id);
		String sId = id.replaceAll("'", "");
		Room room = roomdao.getRoomById(sId);
		return new ModelAndView("bookRoom", "roomDetail", room);
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
    @PostMapping("/bookRoom.htm")
    public String postBookRoom(HttpServletRequest request,RoomDAO roomdao, BookingInfoDAO bookinginfodao) throws EmailException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedIn");
        int userid = user.getUserID();
        String roomId = request.getParameter("roomid");
        int rId = Integer.parseInt(roomId);
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String emailID = request.getParameter("emailid");
        long phone_number = Long.parseLong(request.getParameter("phone_number"));
        String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        String status = "booked";
        bookinginfodao.saveBookingInfo(firstname, lastname, emailID, phone_number, checkin, checkout, userid, rId, status);
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("adhyantini.logito@gmail.com", "wcnbsmrddpizhmom"));
        email.setSSLOnConnect(true);
        email.setFrom("adhyantini.logito@gmail.com");
        email.setSubject("Booking Successful");
        email.setMsg(" Room successfully booked for dates "+checkin+" to"+ checkout);
        email.addTo(emailID);
        email.send();
        return "redirect:/showAvailableRooms.htm";
    }
    
     @GetMapping("/viewBookings.htm")
    public ModelAndView getAllBookings(HttpServletRequest request,BookingInfoDAO bookingInfoDao) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedIn");
        System.out.println("The user ID is ==="+user.getUserID());
        int userid = user.getUserID();
        List<BookingInfo> list = new ArrayList<BookingInfo>();
        list = bookingInfoDao.getBookingsByUserId(userid);
        
        
        return new ModelAndView("userViewAllBookings", "bookingDetails", list);
    }
    
    @GetMapping("/userlogout.htm")
    public String userLogout(HttpServletRequest request) {
                HttpSession session = request.getSession(false);
		session.removeAttribute("loggedIn");
		return "redirect:/login.htm";
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
}
