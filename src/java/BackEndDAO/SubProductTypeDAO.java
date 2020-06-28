/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

import entities.TblOrder;
import entities.TblSubProductType;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class SubProductTypeDAO {

    public List<TblSubProductType> getAllSub() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblSubProductType> ad = session.createQuery("from TblSubProductType").list();

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

    public boolean insertSubProductType(TblSubProductType p) {
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
     public boolean updateOrder(TblOrder p) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblOrder od = (TblOrder) session.createQuery("from TblOrder where orderId= :id")
                    .setParameter("id", p.getOrderId()).uniqueResult();
            
            od.setStatus(p.getStatus());
            session.update(od);
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
