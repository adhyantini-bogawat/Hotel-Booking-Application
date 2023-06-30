/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.me.pojo.BookingInfo;
import com.me.pojo.Room;
import com.me.pojo.User;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adhyantini
 */
@Component
public class BookingInfoDAO extends DAO {
    public boolean saveBookingInfo(String firstname, String lastname, String emailID, long phoneNumber, String checkin, String checkout, int userId, int roomId, String status) {
        BookingInfo bookingInfo = new BookingInfo();
       
        bookingInfo.setFirstname(firstname);
        bookingInfo.setLastname(lastname);
        bookingInfo.setEmailID(emailID);
        bookingInfo.setPhone(phoneNumber);
        bookingInfo.setCheckin(checkin);
        bookingInfo.setCheckout(checkout);
        bookingInfo.setUserId(userId);
        bookingInfo.setRoomId(roomId);
        bookingInfo.setStatus(status);
        begin();
        getSession().persist(bookingInfo);
        commit();
        
        return true;
    }
    
     public List<BookingInfo> getBookingsByUserId(int userId) {
           try{
               begin();
                Query q = getSession().createQuery("FROM BookingInfo where userId = :userId", BookingInfo.class);
                q.setParameter("userId", userId);
                commit();
                return q.list();
           } catch (Exception e) {
			rollback();
			// TODO: handle exception
		}
           return null;
    }
     
      public List<Room> getAllBookings() {
//        Query q = getSession().createNamedQuery("allrooms", Room.class);
        begin();
        Query q = getSession().createQuery("FROM BookingInfo", BookingInfo.class);
        commit();
        return q.list();
    }
      
      public void updateBookingStatus(int id) {
		try {
			begin();
			Query query = getSession().createQuery("FROM BookingInfo where id =:id", BookingInfo.class);
                        
                        
                        
			query.setParameter("id", id);
			BookingInfo bookingInfo = (BookingInfo) query.uniqueResult();
			
			if (bookingInfo != null) {
				bookingInfo.setStatus("checked-out");
				System.out.println("Get status =========" +bookingInfo.getStatus());
				getSession().merge(bookingInfo);
				commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
                        System.out.println("Error inside update dao"+e);
			rollback();
		}

	}
     
    
}
