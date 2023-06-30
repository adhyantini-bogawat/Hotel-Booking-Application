/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.me.pojo.Room;
import com.me.pojo.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adhyantini
 */
@Component
public class RoomDAO extends DAO {
    public void saveRoom(Room room) {
//        room.bedsize = Integer.parseInt(room.bedsize);
        System.out.println(" INSIDEEEEEEEEE SAVE ROOM DAO ====== "+room.getRoomName());
        try {
            begin();
            getSession().persist(room);
            commit();
        } catch(HibernateException e) {
             System.out.println("Error inside create room dao"+e);
            rollback();
        }
    }
    
    public List<Room> getAllRooms() {
//        Query q = getSession().createNamedQuery("allrooms", Room.class);
        begin();
        Query q = getSession().createQuery("FROM Room", Room.class);
        commit();
        return q.list();
    }
    
    public Room getRoomById(String id) {
		try {
System.out.println("Inside update "+ id);
			begin();
			Query query = getSession().createQuery("from Room where id = :id", Room.class);
			query.setParameter("id", id);
			Room room = (Room) query.uniqueResult();
                        System.out.println("Inside logidaoooon"+room.getRoomID());
                        commit();
			return room;
		} catch (Exception e) {
			rollback();
			// TODO: handle exception
		}
		return null;
	}
    
    public void updateRoom(String id, int roomNumber, String roomName, String bedsize, String roomHighlights) {
		try {
			begin();
			Query query = getSession().createQuery("from Room where id =:id", Room.class);
                        
                        
                        
			query.setParameter("id", id);
			Room room = (Room) query.uniqueResult();
			
			if (room != null) {
				room.setRoomNumber(roomNumber);
				room.setRoomName(roomName);
				room.setBedsize(bedsize);
				room.setRoomHighlights(roomHighlights);
				getSession().merge(room);
				commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
                        System.out.println("Error inside update dao"+e);
			rollback();
		}

	}
    
    public void deleteRoom(int id) {
		try {
			begin();
			Query query = getSession().createQuery("delete Room where id = :id");
			query.setParameter("id", id);
                        System.out.println("Inside Room delete !!"+id);
                        System.out.println("Inside Room delete !!"+query);
			query.executeUpdate();
                        commit();
		} catch (Exception e) {
			// TODO: handle exception
                         System.out.println("Error inside delete room dao"+e);
                       e.printStackTrace();
		}

	}
}
