/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

import entities.TblProductType;
import entities.TblSubProductType;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class TypeProductDAO {
     public List<TblProductType> getAllType() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblProductType> ad = session.createQuery("from TblProductType").list();
                    
            session.getTransaction().commit();
            session.close();
            if (ad!=null) {
                return ad;
            }else{
            
            return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;

    }
     public List<TblSubProductType> getAllSubType() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblSubProductType> ad = session.createQuery("from TblSubProductType").list();
                    
            session.getTransaction().commit();
            session.close();
            if (ad!=null) {
                return ad;
            }else{
            
            return null;
            }
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;

    }
}
