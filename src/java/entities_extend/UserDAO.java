/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_extend;

import entities.TblOrder;
import entities.TblOrderDetail;
import entities.TblUser;
import entities_extend.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public User login(String userName, String pass) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser u = (TblUser) session.createQuery("from TblUser where UserName= :user and Password= :pass")
                    .setParameter("user", userName)
                    .setParameter("pass", pass).uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (u != null) {
                User us = new User(u.getUserId(), u.getUserName(), u.getPassword(), u.getFullName(), u.getAddress() + "", u.getEmail() + "", u.getBirthDay(), u.getSex(), u.getAvatar() + "", u.getPhone(), u.getPoint(), u.getStatus());
                return us;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;

    }
    public TblUser getUser(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser u = (TblUser) session.createQuery("from TblUser where UserId= :id")
                    
                    .setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (u != null) {
               return u;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;

    }

    public boolean checkuser(String username) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser u = (TblUser) session.createQuery("from TblUser where UserName= :user")
                    .setParameter("user", username).uniqueResult();
            session.getTransaction().commit();
            session.close();
            if (u != null) {
                return false;
            } else {

                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }

        return true;
    }

    public boolean regis(User user) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser u = new TblUser();
            u.setFullName(user.getFullName());
            u.setUserName(user.getUserName());
            u.setPassword(user.getPassword());
             u.setAddress(user.getAddress());
            u.setEmail(user.getEmail());
            u.setBirthDay(user.getBirthDay());
            u.setSex(user.getSex());
            u.setAvatar(user.getAvatar());
            u.setPhone(user.getPhone());
            u.setPoint(user.getPoint());
            u.setStatus(user.getStatus());
            session.save(u);
            session.getTransaction().commit();
            session.close();

            return true;

        } catch (Exception e) {
            System.out.println("Lỗi "+e.getMessage());
            session.getTransaction().rollback();
            session.close();
            return false;
        }

    }

    public List<User> getAlll() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<User> user = new ArrayList<>();
            List<TblUser> list = session.createQuery("from TblUser").list();
            for (TblUser u : list) {
                User us = new User(u.getUserId(), u.getUserName(), u.getPassword(), u.getFullName(), u.getAddress(), u.getEmail() + "", u.getBirthDay(), u.getSex(), u.getAvatar() + "", u.getPhone(), u.getPoint(), u.getStatus());
                user.add(us);
            }
            session.getTransaction().commit();
            session.close();
            if (user != null) {
                return user;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;

    }
    
    public int Order( TblOrder order) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        int id = 0;
        try {
            session.beginTransaction();
            session.save(order);
           
           id = (Integer)session.createQuery("select max(orderId) from TblOrder").uniqueResult();
            
            
            session.getTransaction().commit();
            session.close();
            return  id;

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return id;

    }
     public boolean OrderEror( TblOrder order) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        int id = 0;
        try {
            session.beginTransaction();
            session.delete(order);
          
            
            session.getTransaction().commit();
            session.close();
            return  true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return false;

    }
     public boolean OrderDetail( TblOrderDetail orderDetail) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
       
        try {
            session.beginTransaction();
            session.save(orderDetail);
       
            session.getTransaction().commit();
            session.close();
            return  true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            System.out.println("Loi insert detail"+ e.getMessage());
        }
        return false;

    }
   
}
