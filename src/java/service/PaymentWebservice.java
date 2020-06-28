/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import BackEndDAO.EmailUtil;
import com.google.gson.Gson;
import entities.TblOrder;
import entities.TblOrderDetail;
import entities.TblPaymentMethod;
import entities.TblProductDetail;
import entities.TblShipMethod;
import entities.TblUser;
import entities_extend.Order;
import entities_extend.OrderDetail;
import entities_extend.PaymentMethod;
import entities_extend.ProductDAO;
import entities_extend.Result;
import entities_extend.ShipMethod;
import entities_extend.UserDAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */

@Path(value = "/payment")
public class PaymentWebservice {

    //ProductDAO pdd = new ProductDAO();
    @GET
    @Path(value = "/order")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON)
    public String payment(@QueryParam("data") String data) {
        Gson son = new Gson();
        Result n = new Result();
        JSONObject rootJSON;
        try {
            rootJSON = new JSONObject(data);
            int userId = Integer.parseInt(rootJSON.getString("userId"));
            String fullName = rootJSON.getString("fullName");
            String addressShip = rootJSON.getString("addressShip");
            String phone = rootJSON.getString("phone");
            Integer paymentMethod = rootJSON.getInt("paymentMethod");
            Integer shipMethod = rootJSON.getInt("shipMethod");
            String description = rootJSON.getString("description");
            Double totalAmountOrder = rootJSON.getDouble("totalAmountOrder");
            String detail = rootJSON.getString("detail");

            //Xử lý add order
            TblOrder order = new TblOrder();
            if (userId != 0) {
                TblUser u = new TblUser();
                u.setUserId(userId);
                order.setUserId(u);

            }
            order.setFullName(fullName);
            order.setDateOrder(new Date());
            order.setAddressShip(addressShip);
            order.setPhone(phone);
            order.setStatus(1);
            TblPaymentMethod pm = new TblPaymentMethod();
            pm.setPaymentMethodId(paymentMethod);
            order.setPaymentMethod(pm);
            TblShipMethod sm = new TblShipMethod();
            sm.setShipMethodId(shipMethod);
            order.setShipMethod(sm);

            order.setDescription(description);
            order.setTotalAmountOrder(totalAmountOrder);

            String dataObject = detail.replace("\\", "");

            int id = new UserDAO().Order(order);
            if (id == 0) {
                n.setMessage("Lỗi hệ thống ko thể đặt hàng");
            } else {

                List<TblOrderDetail> odtt = new ArrayList<>();
                //Xử lý orderdetail
                int record = 0;
                JSONArray arr = new JSONArray(dataObject);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject product = arr.getJSONObject(i);
                    int productId = product.getInt("productId");
                    String productName = product.getString("productName");
                    Double priceProductOrder = product.getDouble("priceProductOrder");
                    int quantity = product.getInt("quantity");
                    Double amount = product.getDouble("amount");
                    int status = product.getInt("status");

                    TblOrder o = new TblOrder();
                    o.setOrderId(id);

                    TblOrderDetail detail1 = new TblOrderDetail();
                    detail1.setOrderId(o);
                    TblProductDetail productDetail = new TblProductDetail();
                    productDetail.setId(productId);
                    detail1.setProductId(productDetail);
                    detail1.setProductName(productName);
                    detail1.setPriceProductOrder(priceProductOrder);
                    detail1.setQuantity(quantity);
                    detail1.setAmount(amount);
                    detail1.setStatus(status);
                    odtt.add(detail1);
                    boolean c = new UserDAO().OrderDetail(detail1);
                    if (c) {
                        record += 1;
                    }

                }
                if (record == arr.length()) {
                    if (userId != 0) {
                        UserDAO d = new UserDAO();
                        TblUser u = d.getUser(userId);
                        String admail = u.getEmail();
                        NumberFormat fomart = NumberFormat.getInstance(new Locale("vi", "VN"));
                        String text = "Bạn vừa đặt hàng tại app HieuRinShop - Chúng tôi xin chân thành cảm ơn bạn đã tin tưởng HieuRinShop<br/>"
                                + "Tổng số tiền hóa đơn của bạn là: " + fomart.format(totalAmountOrder) + "<br/>"
                                + "Chúng tôi sẽ sớm tiến hành check đơn hàng và vận chuyển cho bạn sớm nhất";
                        try {
                            EmailUtil.sendMail(admail, "Thông báo đơn đặt hàng HieuRinShop", text);
                        } catch (MessagingException ex) {
                            Logger.getLogger(PaymentWebservice.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    n.setId(1);
                    n.setMessage("Đặt hàng thành công");
                } else {

                    boolean delete = new UserDAO().OrderEror(order);
                    if (delete) {
                        n.setId(0);
                        n.setMessage("Lỗi đặt hàng chi tiết");
                    } else {
                        n.setId(0);
                        n.setMessage("Lỗi đặt hàng");

                    }

                }

            }
        } catch (JSONException ex) {
            Logger.getLogger(PaymentWebservice.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lõi đặt hàng" + ex.getMessage());
            n.setMessage("Lỗi js");
            n.setId(0);
        }

        String bs = son.toJson(n);
        return bs;
    }

    @GET
    @Path(value = "/getPaymentMethod")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaymentMethod() {
        List<PaymentMethod> a = new ProductDAO().getAllPayment();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/checkOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkOrder(@QueryParam("userId") int id) {
        List<Order> a = new ProductDAO().getOrderbyUser(id);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/checkOrder1")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkOrder1() {
        List<Order> a = new ProductDAO().getOrderbyUser();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/checkOrderDetail")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkOrderDetail(@QueryParam("userId") int id) {
        List<OrderDetail> a = new ProductDAO().getOrderDetailbyUser(id);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/checkCountOder")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCountOder(@QueryParam("userId") int id) {
        List<Order> a = new ProductDAO().getOrderbyUser(id);

        int count = a.size();
        Result rs = new Result();
        if (count > 0) {
            rs.setId(1);
            rs.setMessage("Ok");
        } else {
            rs.setId(0);
            rs.setMessage("Bạn chưa có đặt hàng");
        }

        Gson son = new Gson();
        String data = son.toJson(rs);
        return data;
    }

    @GET
    @Path(value = "/checkOrderDetail2")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkOrderDetail() {
        List<OrderDetail> a = new ProductDAO().getOrderDetailbyUser2();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/getShipMethod")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getShipMethod() {
        List<ShipMethod> a = new ProductDAO().getAllShip();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
}
