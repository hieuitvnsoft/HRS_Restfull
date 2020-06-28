/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

import entities.TblOrder;
import entities.TblOrderDetail;
import entities.TblProduct;
import entities.TblProductDetail;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class OrderDAO {
    
    public List<TblOrder> getAllOrder() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblOrder> ad = session.createQuery("from TblOrder").list();
            
            session.getTransaction().commit();
            session.close();
            if (ad != null) {
                return ad;
            } else {
                
                return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
        
    }
    
    public TblOrder getOrderbyId(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblOrder ad = (TblOrder) session.createQuery("from TblOrder where OrderId = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            
            session.getTransaction().commit();
            session.close();
            if (ad != null) {
                return ad;
            } else {
                
                return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
        
    }
    
    public List<TblOrderDetail> getOrderDetailbyId(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblOrderDetail> ad = session.createQuery("from TblOrderDetail where orderId.orderId = :id")
                    .setParameter("id", id)
                    .list();
            
            session.getTransaction().commit();
            session.close();
            if (ad != null) {
                return ad;
            } else {
                
                return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
        
    }
     public TblProductDetail getProductDetail(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblProductDetail  ad = (TblProductDetail) session.createQuery("from TblProductDetail where Id = :id")
                    .setParameter("id", id)
                     .uniqueResult();
            
            session.getTransaction().commit();
            session.close();
            if (ad != null) {
                return ad;
            } else {
                
                return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
        
    }

    public boolean deleteOrderDetailbyId(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblOrderDetail ad = (TblOrderDetail) session.createQuery("from TblOrderDetail where id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            ad.setStatus(0);
            session.update(ad);
            session.getTransaction().commit();
            session.close();
            return true;
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return false;
        
    }
    
    public int countOrderNew() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            int count = ((Number) session.createSQLQuery("select COUNT(*) from TblOrder where status = 1").uniqueResult()).intValue();
            
            session.getTransaction().commit();
            session.close();
            return count;
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return 0;
        
    }
    
    public int countOrderDetroy() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            int count = ((Number) session.createSQLQuery("select COUNT(*) from TblOrder where status = 0").uniqueResult()).intValue();
            
            session.getTransaction().commit();
            session.close();
            return count;
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return 0;
        
    }
    
}
