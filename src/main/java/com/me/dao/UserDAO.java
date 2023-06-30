/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.me.pojo.Room;
import com.me.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adhyantini
 */
@Component
public class UserDAO extends DAO {
    public boolean validUser(String emailID, String password) {
        Query q = getSession().createQuery("FROM User WHERE emaildID = :emaildID AND password = :password", User.class);
        q.setParameter("emaildID", emailID);
        q.setParameter("password", password);
        
        if (q.uniqueResult() == null)
            return false;
        else
            return true;
        
    }
    
    public User getUser(String emailID, String password) {
        Query q = getSession().createQuery("FROM User WHERE emaildID = :emaildID AND password = :password", User.class);
        q.setParameter("emaildID", emailID);
        q.setParameter("password", password);
        User user = (User) q.uniqueResult();
        System.out.println("Inside logidaoooon"+user.getUserID());
        return user;
        
    }
    
//    public boolean saveUser(String emailID, String password, String conf_password, long phone_no, String addressLine1, String addressLine2, String city, int zipcode, String state) {
//        User user = new User();
//        user.setEmaildID(emailID);
//        user.setPassword(password);
//        user.setConfirm_password(conf_password);
//        user.setPhone(phone_no);
//        user.setAddress_line1(addressLine1);
//        user.setAddress_line2(addressLine2);
//        user.setCity(city);
//        user.setState(state);
//        user.setZipcode(zipcode);
//        
//        begin();
//        getSession().persist(user);
//        commit();
//        
//        return true;
//    }
    
    
    public void saveUser(User user) {
//        room.bedsize = Integer.parseInt(room.bedsize);
        System.out.println(" INSIDEEEEEEEEE SAVE USER DAO ====== "+user.getUserID());
        try {
            begin();
            getSession().persist(user);
            commit();
        } catch(HibernateException e) {
             System.out.println("Error inside create user dao"+e);
            rollback();
        }
    }
    
}
