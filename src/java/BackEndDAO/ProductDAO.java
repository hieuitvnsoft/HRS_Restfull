/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEndDAO;

import entities.TblAdmin;
import entities.TblColor;
import entities.TblProduct;
import entities.TblProductDetail;
import entities.TblSize;
import entities.TblUser;
import entities_extend.Product;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProductDAO implements Serializable {

    public List<TblProduct> getAllProduct() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblProduct> ad = session.createQuery("from TblProduct").list();

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
//      TblAdmin ad =  (TblAdmin) session.createQuery("from TblAdmin where UserName= :user and Password= :pass")
//                    .setParameter("user", user)
//                    .setParameter("pass", pass).uniqueResult();

    public List<TblProductDetail> getAllProductDetail(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblProductDetail> ad = session.createQuery("from TblProductDetail where ProductId=:productId")
                    .setParameter("productId", id)
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

    public boolean insertProduct(TblProduct p) {
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

    public boolean insertProductDetail(TblProductDetail p) {
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

    public boolean updateProductDetail(TblProductDetail p) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblProductDetail px = (TblProductDetail) session.createQuery("from TblProductDetail where Id= :id")
                    .setParameter("id", p.getId())
                    .uniqueResult();

            if ("".equals(p.getImgProduct()) || p.getImgProduct() == null) {
                p.setImgProduct(px.getImgProduct());
            }
            session.update(p);
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

    public boolean updateProduct(TblProduct p) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblProduct px = (TblProduct) session.createQuery("from TblProduct where productId = :id ").setParameter("id", p.getProductId()).uniqueResult();

            if (!"".equals(p.getImgProduct()) || p.getImgProduct() != null) {
                p.setImgProduct(px.getImgProduct());
            }

            session.update(p);
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

    public TblProduct getProductById(int Id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        TblProduct p = new TblProduct();
        try {
            session.beginTransaction();
            p = (TblProduct) session.createQuery("from TblProduct where ProductId=:Id")
                    .setParameter("Id", Id).uniqueResult();

            session.flush();
            session.getTransaction().commit();
            session.close();

            return p;

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            System.out.println(e);
        }
        return null;
    }

    public List<TblColor> getAllColor() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            List<TblColor> list = session.createQuery("from TblColor").list();

            session.getTransaction().commit();
            session.close();
            if (list != null) {
                return list;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    public List<TblSize> getAllSize() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            List<TblSize> list = session.createQuery("from TblSize").list();

            session.getTransaction().commit();
            session.close();
            if (list != null) {
                return list;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    public List<TblUser> getAllUser() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            List<TblUser> list = session.createQuery("from TblUser").list();

            session.getTransaction().commit();
            session.close();
            if (list != null) {
                return list;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
}
