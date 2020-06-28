/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_extend;

import common.ConnectJDBC;
import entities.TblColor;
import entities.TblOrder;
import entities.TblPaymentMethod;
import entities.TblProduct;
import entities.TblProductDetail;
import entities.TblProductType;
import entities.TblShipMethod;
import entities.TblSize;
import entities.TblSubProductType;
import entities.TblUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProductDAO {

    public List<Product> getAlll() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Product> user = new ArrayList<>();
            List<TblProduct> list = session.createQuery("from TblProduct").list();
            for (TblProduct p : list) {
                Product pext = new Product(p.getProductId(), p.getProductName(), p.getPriceOlder(), p.getDescription(), p.getStatus(), p.getImgProduct(), p.getProducerId().getProducerId(), p.getSubProductTypeId().getSubProductTypeId());
                Collection<TblProductDetail> listPD = p.getTblProductDetailCollection();
                if (listPD != null && listPD.size() > 0) {
                    TblProductDetail[] arr = new TblProductDetail[p.getTblProductDetailCollection().size()];
//                Collection<TblProductDetail> listDetail = p.getTblProductDetailCollection();
                    arr = p.getTblProductDetailCollection().toArray(arr);
//                pext.setTblProductDetailCollection(arr);

                    pext.setPriceNew(arr[0].getPriceNew());

                } else {
                    pext.setPriceNew(0.0);
                }
                user.add(pext);
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

    public List<Product> getProductByName(int id, String name) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Product> user = new ArrayList<>();
            List<TblProduct> list = session.createQuery("FROM TblProduct WHERE ProductName LIKE '%'+ :name +'%' AND SubProductTypeId = :id")
                    .setParameter("name", name)
                    .setParameter("id", id)
                    .list();
            for (TblProduct p : list) {
                Product pext = new Product(p.getProductId(), p.getProductName(), p.getPriceOlder(), p.getDescription(), p.getStatus(), p.getImgProduct(), p.getProducerId().getProducerId(), p.getSubProductTypeId().getSubProductTypeId());
                Collection<TblProductDetail> listPD = p.getTblProductDetailCollection();
                if (listPD != null && listPD.size() > 0) {
                    TblProductDetail[] arr = new TblProductDetail[p.getTblProductDetailCollection().size()];
//                Collection<TblProductDetail> listDetail = p.getTblProductDetailCollection();
                    arr = p.getTblProductDetailCollection().toArray(arr);
//                pext.setTblProductDetailCollection(arr);

                    pext.setPriceNew(arr[0].getPriceNew());

                } else {
                    pext.setPriceNew(0.0);
                }
                user.add(pext);
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

    public List<Order> getOrderbyUser(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Order> user = new ArrayList<>();
            List<TblOrder> list = session.createQuery("from TblOrder where UserId = :id")
                    .setParameter("id", id)
                    .list();
            for (TblOrder p : list) {
                Integer orderId = p.getOrderId();
                String fullName = p.getFullName();
                String addressShip = p.getAddressShip();
                String phone = p.getPhone();
                Integer codeId = (p.getCodeId() == null) ? 0 : p.getCodeId();
                Double pointCount = (p.getPointCount() == null) ? 0.0 : p.getPointCount();
                Double discountAmount = (p.getDiscountAmount() == null) ? 0.0 : p.getDiscountAmount();
                Double totalAmountOrder = p.getTotalAmountOrder();
                Date dateOrder = p.getDateOrder();
                String description = p.getDescription();
                Integer status = p.getStatus();
                Integer paymentMethod = p.getPaymentMethod().getPaymentMethodId();
                Integer shipMethod = p.getShipMethod().getShipMethodId();

                Integer userId = 0;

                if (p.getUserId() != null) {
                    userId = p.getUserId().getUserId();
                }

                Order pext = new Order(orderId, fullName, addressShip, phone, codeId, pointCount, discountAmount, totalAmountOrder, dateOrder, description, status, paymentMethod, shipMethod, userId);
                user.add(pext);
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

    public List<Order> getOrderbyUser() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Order> user = new ArrayList<>();
            List<TblOrder> list = session.createQuery("from TblOrder").list();
            for (TblOrder p : list) {
                Integer orderId = p.getOrderId();
                String fullName = p.getFullName();
                String addressShip = p.getAddressShip();
                String phone = p.getPhone();
                Integer codeId = (p.getCodeId() == null) ? 0 : p.getCodeId();
                Double pointCount = (p.getPointCount() == null) ? 0.0 : p.getPointCount();
                Double discountAmount = (p.getDiscountAmount() == null) ? 0.0 : p.getDiscountAmount();
                Double totalAmountOrder = p.getTotalAmountOrder();
                Date dateOrder = p.getDateOrder();
                String description = p.getDescription();
                Integer status = p.getStatus();
                Integer paymentMethod = p.getPaymentMethod().getPaymentMethodId();
                Integer shipMethod = p.getShipMethod().getShipMethodId();

                Integer userId = 0;

                if (p.getUserId() != null) {
                    userId = p.getUserId().getUserId();
                }

                Order pext = new Order(orderId, fullName, addressShip, phone, codeId, pointCount, discountAmount, totalAmountOrder, dateOrder, description, status, paymentMethod, shipMethod, userId);
                user.add(pext);
            }

            session.getTransaction().commit();
            session.close();
            if (user != null) {
                return user;
            } else {

                return null;
            }

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    public List<OrderDetail> getOrderDetailbyUser(int id) {
        Connection con;
        ConnectJDBC cnn = new ConnectJDBC();

        String sql = " SELECT d.*,p.ImgProduct FROM dbo.tblOrderDetail  d inner  JOIN  dbo.tblOrder od ON od.OrderId = d.OrderId inner  JOIN dbo.tblProductDetail p ON p.Id = d.ProductId Where UserId = ?";
        List<OrderDetail> arrayList = new ArrayList<>();
        con = cnn.ConnectJDBC();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderDetail detail = new OrderDetail();
                detail.setId(rs.getInt("Id"));
                detail.setOrderId(rs.getInt("OrderId"));
                detail.setProductId(rs.getInt("ProductId"));
                detail.setProductName(rs.getString("ProductName"));
                detail.setPriceProductOrder(rs.getDouble("PriceProductOrder"));
                detail.setQuantity(rs.getInt("Quantity"));
                detail.setAmount(rs.getDouble("Amount"));
                detail.setStatus(rs.getInt("Status"));
                detail.setProductImg(rs.getString("ImgProduct"));
                arrayList.add(detail);

            }
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<OrderDetail> getOrderDetailbyUser2() {
        Connection con;
        ConnectJDBC cnn = new ConnectJDBC();

        String sql = " SELECT d.*,p.ImgProduct FROM dbo.tblOrderDetail  d inner  JOIN  dbo.tblOrder od ON od.OrderId = d.OrderId inner  JOIN dbo.tblProductDetail p ON p.Id = d.ProductId";
        List<OrderDetail> arrayList = new ArrayList<>();
        con = cnn.ConnectJDBC();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderDetail detail = new OrderDetail();
                detail.setId(rs.getInt("Id"));
                detail.setOrderId(rs.getInt("OrderId"));
                detail.setProductId(rs.getInt("ProductId"));
                detail.setProductName(rs.getString("ProductName"));
                detail.setPriceProductOrder(rs.getDouble("PriceProductOrder"));
                detail.setQuantity(rs.getInt("Quantity"));
                detail.setAmount(rs.getDouble("Amount"));
                detail.setStatus(rs.getInt("Status"));
                detail.setProductImg(rs.getString("ImgProduct"));
                arrayList.add(detail);

            }
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<ProductType> getAllProductType() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<ProductType> user = new ArrayList<>();
            List<TblProductType> list = session.createQuery("from TblProductType").list();
            for (TblProductType p : list) {
                ProductType pext = new ProductType(p.getProductTypeId(), p.getProductTypeName());

                user.add(pext);
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

    public List<SubProductType> getAllSubProductType() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<SubProductType> user = new ArrayList<>();
            List<TblSubProductType> list = session.createQuery("from TblSubProductType")
                    .list();
            for (TblSubProductType p : list) {
                SubProductType pext = new SubProductType(p.getSubProductTypeId(), p.getSubProductTypeName());

                user.add(pext);
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

    public List<ProductDetail> getAllDetail(int id) {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<ProductDetail> user = new ArrayList<>();
            TblProduct p = (TblProduct) session.createQuery("from TblProduct where  productId = :id and status = 1")
                    .setParameter("id", id)
                    .uniqueResult();

            Collection<TblProductDetail> listPD = p.getTblProductDetailCollection();

            if (listPD != null && listPD.size() > 0) {
                for (TblProductDetail listPD1 : listPD) {
                    ProductDetail prd = new ProductDetail(listPD1.getId(), listPD1.getPriceNew(), listPD1.getQuantity(), listPD1.getImgProduct(), listPD1.getColorId().getColorName(), p.getProductId(), listPD1.getSizeId().getSize(), p.getProductName(), listPD1.getColorId().getColorCode(), p.getDescription(), p.getProducerId().getProducerName(), p.getSubProductTypeId().getSubProductTypeName());
                    user.add(prd);
                }
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

    public List<PaymentMethod> getAllPayment() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<PaymentMethod> pmm = new ArrayList<>();
            List<TblPaymentMethod> list = session.createQuery("from TblPaymentMethod").list();
            for (TblPaymentMethod list1 : list) {
                PaymentMethod pm = new PaymentMethod(list1.getPaymentMethodId(), list1.getPaymentMethodName());
                pmm.add(pm);
            }
            session.getTransaction().commit();
            session.close();
            if (list != null) {
                return pmm;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    public List<ShipMethod> getAllShip() {
        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<ShipMethod> pmm = new ArrayList<>();
            List<TblShipMethod> list = session.createQuery("from TblShipMethod").list();
            for (TblShipMethod list1 : list) {
                ShipMethod pm = new ShipMethod(list1.getShipMethodId(), list1.getShipMethodName());
                pmm.add(pm);
            }
            session.getTransaction().commit();
            session.close();
            if (list != null) {
                return pmm;
            } else {

                return null;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    public List<TblUser> lisUser() {

        Session session = BackEndDAO.HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblUser> ad = session.createQuery("from TblUser").list();

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
}
