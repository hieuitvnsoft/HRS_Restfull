/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

import entities.TblColor;
import entities.TblProducer;
import entities.TblProduct;
import entities.TblSize;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProducerDAO {
    
    
     public List<TblProducer> getAllProducer() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblProducer> ad = session.createQuery("from TblProducer").list();
                    
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
public boolean insertProducer(TblProducer p) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
             session.save(p);
             session.flush();
            session.getTransaction().commit();
            session.close();
          
                return true;
         
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            System.out.println(e);
        }
        return false;
}

}
