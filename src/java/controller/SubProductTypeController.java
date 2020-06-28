/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BackEndDAO.OrderDAO;
import BackEndDAO.ProducerDAO;
import BackEndDAO.ProductTypeDAO;
import BackEndDAO.SubProductTypeDAO;
import entities.TblOrder;
import entities.TblOrderDetail;
import entities.TblProducer;
import entities.TblProduct;
import entities.TblProductType;
import entities.TblSubProductType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/Admin")
public class SubProductTypeController {

    SubProductTypeDAO pd = new SubProductTypeDAO();
    ProductTypeDAO ptd = new ProductTypeDAO();

    @RequestMapping(value = "/listSubType")
    public String getAllr(HttpSession session, Model model) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblSubProductType> allProducer = pd.getAllSub();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("list", allProducer);
        return "Admin/ListSubTypeProduct";
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public String UpdateProduct(HttpSession session, Model model, @ModelAttribute("order") TblOrder p, HttpServletRequest request) {

        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        String path = request.getRealPath("/Views/Admin/images/product");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Views\\Admin\\images\\product";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");

        String dateString = format.format(new Date());

        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fi : list) {
                if (fi.isFormField() == false) {
                    String name = fi.getName();
                    String extension = name.substring(name.lastIndexOf("."));

                    fi.write(new File(path + "/" + dateString + extension));
                } else {
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "orderId":
                                p.setOrderId(Integer.parseInt(value));
                                break;
                            case "status":
                                p.setStatus(Integer.parseInt(value));
                                break;

                        }
                    }

                }
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean a = pd.updateOrder(p);
        if (a) {
            OrderDAO ord = new OrderDAO();
            List<TblOrderDetail> allProduct = ord.getOrderDetailbyId(p.getOrderId());
            TblOrder order = ord.getOrderbyId(p.getOrderId());
            model.addAttribute("order", order);
            model.addAttribute("listOrderDetail", allProduct);
            
            return "redirect: listOrder.htm";
        } else {
            model.addAttribute("messs", "Cập nhật thất bại");
            return "Admin/ListOrderDetail";
        }
    }

    @RequestMapping(value = "/insertSubType", method = RequestMethod.POST)
    public String insertSubType(HttpSession session, @ModelAttribute("subType") TblSubProductType p, Model model) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        boolean a = pd.insertSubProductType(p);
        if (a) {
            List<TblSubProductType> b = pd.getAllSub();
//         model.addAllAttributes("list",allProduct);
            model.addAttribute("list", b);

            return "Admin/ListSubTypeProduct";
        } else {
            model.addAttribute("messs", "Them moi ko thanh cong");
            return "Admin/InsertSubType";
        }

    }

    @RequestMapping(value = "/insertSubType", method = RequestMethod.GET)
    public String a(HttpSession session, Model model) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblProductType> listT = ptd.getAllType();
        model.addAttribute("listT", listT);
        model.addAttribute("subType", new TblSubProductType());
        return "Admin/InsertSubType";
    }
}
