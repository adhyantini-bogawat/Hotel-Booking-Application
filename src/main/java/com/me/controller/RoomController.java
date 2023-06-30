/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.me.controller;

import com.me.dao.BookingInfoDAO;
import com.me.dao.RoomDAO;
import com.me.pojo.BookingInfo;
import com.me.pojo.Room;
//import com.me.validator.roomValidator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 *
 * @author Adhyantini
 */
@Controller
public class RoomController {
//     @Autowired
//     roomValidator validator;
 
     public RoomController(){}
     
  @GetMapping("/roomAdd.htm")
    public String showAddRoomForm(ModelMap model) {
        System.out.println("Inside showFormmmmmmmmmmm");
        model.addAttribute("room",  new Room());
        return "adminAddRoom";
    }

    @PostMapping("/roomAdd.htm")
    public String showAddRoomSuccess(@Valid @ModelAttribute("room") Room room, BindingResult result, SessionStatus status, RoomDAO roomdao) {
//        validator.validate(room, result);
//         if (result.hasErrors()) {
//            return "adminAddRoom";
//        }

        try {
           
            String fileName = room.getPhoto().getOriginalFilename();
            System.out.println(" INSIDEEEEEEEEE THE POST METHODDDDDDDDDDDDDDDDD 2"+room.getRoomName());
            File file = new File("D:\\roomuploads\\", room.getRoomNumber() + ".jpg");
            room.getPhoto().transferTo(file);
            room.setPhotoFilePath(room.getRoomNumber() + ".jpg");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            System.out.println("IllegalStateException: " + ex.getMessage());
        }

        //Mark the current handler's session processing as complete, allowing for cleanup of session attributes
        status.setComplete();

        //persist the Book object
        
        roomdao.saveRoom(room);
        
        return "adminHomePage";
    }
    
    @GetMapping("/viewAll.htm")
    public ModelAndView allRooms(RoomDAO roomdao) {
         ArrayList<Room> list = new ArrayList<Room>();
        list = (ArrayList<Room>) roomdao.getAllRooms();
        for(int i=0; i<list.size();i++) {
                System.out.println("Get All Booking, object ==== "+list.get(i).getRoomName());
        }
        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
     @GetMapping("/viewAllBookings.htm")
    public ModelAndView allBookings(BookingInfoDAO bookingInfoDao) {
        return new ModelAndView("adminViewAllBookings", "bookings", bookingInfoDao.getAllBookings());
    }
    
    
    @GetMapping("/checkoutGuest.htm")
    public String guestCheckOut(BookingInfoDAO bookingInfoDao,HttpServletRequest request) {
                String id = request.getParameter("id");
                int bookingid = Integer.parseInt(id);
                System.out.println(" THE ID INSIDE GUest CHECK OUT ISSSSS "+ id);
		bookingInfoDao.updateBookingStatus(bookingid);
                System.out.println("Finished executing delete operation!!");
		return "redirect:/viewAll.htm";
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
     @GetMapping("/updateRoom.htm")
    public ModelAndView getUpdateRoom(RoomDAO roomdao,HttpServletRequest request) {
                String id = request.getParameter("id");
                System.out.println(" THE ID INSIDE get UPDATE ISSSSS "+ id);
		String sId = id.replaceAll("'", "");
		Room room = roomdao.getRoomById(sId);
		return new ModelAndView("adminUpdateRoomDetails", "room", room);
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
     @PostMapping("/updateRoom.htm")
    public String postUpdateRoom(RoomDAO roomdao,HttpServletRequest request) {
                String id = request.getParameter("id");
                String sId = id.replaceAll("'", "");
                System.out.println(" THE ID INSIDE post UPDATE ISSSSS "+ id);
                int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
                String roomName = request.getParameter("roomName");
                String bedsize = request.getParameter("bedsize");
                String roomHighlights = request.getParameter("roomHighlights");
		roomdao.updateRoom(sId, roomNumber, roomName, bedsize, roomHighlights);
       
		return "redirect:/viewAll.htm";
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
    @GetMapping("/deleteRoom.htm")
    public String deleteRoom(RoomDAO roomdao,HttpServletRequest request) {
                String id = request.getParameter("id");
                int roomid = Integer.parseInt(id);
                System.out.println(" THE ID INSIDE DELETE ISSSSS "+ id);
		roomdao.deleteRoom(roomid);
                System.out.println("Finished executing delete operation!!");
		return "redirect:/viewAll.htm";
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
     @GetMapping("/logout.htm")
    public String adminLogout(HttpServletRequest request) {
                
		return "redirect:/login.htm";
//        return new ModelAndView("adminViewRooms", "roomList", roomdao.getAllRooms());
    }
    
}
