/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BackEndDAO.OrderDAO;
import BackEndDAO.ProducerDAO;
import BackEndDAO.ProductDAO;
import BackEndDAO.TypeProductDAO;
import entities.TblColor;
import entities.TblOrder;
import entities.TblOrderDetail;
import entities.TblProducer;
import entities.TblProduct;
import entities.TblProductDetail;
import entities.TblSize;
import entities.TblSubProductType;
import entities.TblUser;
import entities_extend.ProductDetail;
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
public class ProductController {

    ProductDAO pd = new ProductDAO();
    OrderDAO ord = new OrderDAO();
    TypeProductDAO tpd = new TypeProductDAO();
    ProducerDAO pcd = new ProducerDAO();

    @RequestMapping(value = "/ds_sanpham")
    public String danhSachSanPham(HttpSession session, Model model) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblProduct> allProduct = pd.getAllProduct();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("listProduct", allProduct);
        return "Admin/ds_sanpham";
    }

    @RequestMapping(value = "/listUser")
    public String listUser(HttpSession session, Model model) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblUser> allProduct = pd.getAllUser();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("listUser", allProduct);
        return "Admin/ListUser";
    }

    @RequestMapping(value = "/InsertProducts", method = RequestMethod.POST)
    public String insertProduct(HttpSession session, Model model, @ModelAttribute("product") TblProduct p, HttpServletRequest request) {

///
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        String path = request.getRealPath("/Views/Image");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Views\\Image";
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
                    p.setImgProduct("HRS/Views/Image/" + dateString + extension);
                    fi.write(new File(path + "/" + dateString + extension));
                } else {
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "productName":
                                p.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                                break;
                            case "priceOlder":
                                p.setPriceOlder(Double.parseDouble(value));
                                break;
                            case "description":
                                p.setDescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                                break;
                            case "status":
                                p.setStatus(Integer.parseInt(value));
                                break;
                            case "subProductTypeId.subProductTypeId":
                                TblSubProductType spt = new TblSubProductType();
                                spt.setSubProductTypeId(Integer.parseInt(value));
                                p.setSubProductTypeId(spt);
                                break;
                            case "producerId.producerId":
                                TblProducer pdc = new TblProducer();
                                pdc.setProducerId(Integer.parseInt(value));
                                p.setProducerId(pdc);
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

        boolean a = pd.insertProduct(p);
        if (a) {
            List<TblProduct> allProducer = pd.getAllProduct();
//         model.addAllAttributes("list",allProduct);
            model.addAttribute("listProduct", allProducer);

            return "redirect: ds_sanpham.htm";
        } else {
            model.addAttribute("messs", "Them moi ko thanh cong");
            return "Admin/InsertProduct";
        }
    }

    @RequestMapping(value = "/InsertProduct", method = RequestMethod.GET)
    public String viewInsert(HttpSession session, Model model
    ) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblSubProductType> stp = tpd.getAllSubType();
        List<TblProducer> pdc = pcd.getAllProducer();
        model.addAttribute("listProducer", pdc);
        model.addAttribute("listSub", stp);
        model.addAttribute("product", new TblProduct());
        return "Admin/InsertProduct";

    }

    @RequestMapping(value = "/UpdateProduct", method = RequestMethod.GET)
    public String viewUpdateProduct(HttpSession session, Model model, @RequestParam("Id") int id) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        TblProduct p = pd.getProductById(id);

        List<TblSubProductType> stp = tpd.getAllSubType();
        List<TblProducer> pdc = pcd.getAllProducer();
        model.addAttribute("listProducer", pdc);
        model.addAttribute("listSub", stp);
        model.addAttribute("product", p);
        return "Admin/UpdateProduct";

    }

    @RequestMapping(value = "/ListProductDetail", method = RequestMethod.GET)
    public String viewProductDetail(HttpSession session, Model model, @RequestParam("Id") int id) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblProductDetail> p = pd.getAllProductDetail(id);

        List<TblColor> stp = pd.getAllColor();
        List<TblSize> pdc = pd.getAllSize();
        model.addAttribute("listSize", pdc);
        model.addAttribute("listColor", stp);
        model.addAttribute("id", id);
        model.addAttribute("productDetail", p);
        return "Admin/ListProductDetail";

    }

    @RequestMapping(value = "/InsertProductsDetails", method = RequestMethod.GET)
    public String viewInsertProductDetail(HttpSession session, Model model, @RequestParam("Id") int id
    ) {
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        List<TblColor> stp = pd.getAllColor();
        List<TblSize> pdc = pd.getAllSize();
        model.addAttribute("listSize", pdc);
        model.addAttribute("listColor", stp);

        TblProductDetail pro = new TblProductDetail();
        TblProduct product = new TblProduct(id);

        pro.setProductId(product);
        model.addAttribute("productDetail", pro);

        return "Admin/InsertProductDetail";

    }

    @RequestMapping(value = "/InsertProductDetails", method = RequestMethod.POST)
    public String insertProductDetail(HttpSession session, Model model, @ModelAttribute("product") TblProductDetail p, HttpServletRequest request) {

///
        String path = request.getRealPath("/Views/Image");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Views\\Image";
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
                    p.setImgProduct("HRS/Views/Image/" + dateString + extension);
                    fi.write(new File(path + "/" + dateString + extension));
                } else {
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "priceNew":
                                p.setPriceNew(Double.parseDouble(value));
                                break;
                            case "quantity":
                                p.setQuantity(Integer.parseInt(value));
                                break;
                            case "productId.productId":
                                TblProduct px = new TblProduct();
                                px.setProductId(Integer.parseInt(value));
                                p.setProductId(px);

                                break;

                            case "colorId.id":
                                TblColor spt = new TblColor();
                                spt.setId(Integer.parseInt(value));
                                p.setColorId(spt);
                                break;
                            case "sizeId.id":
                                TblSize pdc = new TblSize();
                                pdc.setId(Integer.parseInt(value));
                                p.setSizeId(pdc);
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

        boolean a = pd.insertProductDetail(p);
        if (a) {
            List<TblProductDetail> pr = pd.getAllProductDetail(p.getProductId().getProductId());

            List<TblColor> stp = pd.getAllColor();
            List<TblSize> pdc = pd.getAllSize();
            model.addAttribute("listSize", pdc);
            model.addAttribute("listColor", stp);
            model.addAttribute("id", p.getProductId().getProductId());
            model.addAttribute("productDetail", pr);
            return "Admin/ListProductDetail";
        } else {
            model.addAttribute("messs", "Them moi ko thanh cong");
            return "Admin/InsertProductDetail";
        }
    }

    @RequestMapping(value = "/listOrder")
    public String viewListOrder(HttpSession session, Model model) {

        List<TblOrder> allProduct = ord.getAllOrder();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("listOrder", allProduct);
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        return "Admin/ListOrder";
    }

    @RequestMapping(value = "/viewOrderDetail")
    public String viewListOrderDetail(HttpSession session, Model model, @RequestParam("Id") int id) {

        List<TblOrderDetail> allProduct = ord.getOrderDetailbyId(id);
        TblOrder order = ord.getOrderbyId(id);
        model.addAttribute("order", order);
        model.addAttribute("listOrderDetail", allProduct);
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        return "Admin/ListOrderDetail";
    }

    @RequestMapping(value = "/viewProductDetail", method = RequestMethod.GET)
    public String viewProductDetails(HttpSession session, Model model, @RequestParam("Id") int id) {

        TblProductDetail pro = ord.getProductDetail(id);

        model.addAttribute("productDetail", pro);
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        return "Admin/ViewProductDetail";
    }

    @RequestMapping(value = "/UpdateProductDetail", method = RequestMethod.GET)
    public String viewUpdateProductDetails(HttpSession session, Model model, @RequestParam("Id") int id) {

        TblProductDetail pro = ord.getProductDetail(id);
        List<TblColor> stp = pd.getAllColor();
        List<TblSize> pdc = pd.getAllSize();
        model.addAttribute("listSize", pdc);
        model.addAttribute("listColor", stp);
        model.addAttribute("productDetail", pro);

        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        return "Admin/UpdateProductDetail";
    }

    @RequestMapping(value = "/UpdateProductDetails", method = RequestMethod.POST)
    public String updateDeta(HttpSession session, Model model, @ModelAttribute("productDetail") TblProductDetail p, HttpServletRequest request) {

///
        String path = request.getRealPath("/Views/Image");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Views\\Image";
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
                    p.setImgProduct("HRS/Views/Image/" + dateString + extension);
                    fi.write(new File(path + "/" + dateString + extension));
                } else {
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "priceNew":
                                p.setPriceNew(Double.parseDouble(value));
                                break;
                            case "id":
                                p.setId(Integer.parseInt(value));
                                break;
                            case "quantity":
                                p.setQuantity(Integer.parseInt(value));
                                break;
                            case "productId.productId":
                                TblProduct px = new TblProduct();
                                px.setProductId(Integer.parseInt(value));
                                p.setProductId(px);

                                break;

                            case "colorId.id":
                                TblColor spt = new TblColor();
                                spt.setId(Integer.parseInt(value));
                                p.setColorId(spt);
                                break;
                            case "sizeId.id":
                                TblSize pdc = new TblSize();
                                pdc.setId(Integer.parseInt(value));
                                p.setSizeId(pdc);
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

        boolean a = pd.updateProductDetail(p);
        if (a) {
            List<TblProductDetail> pr = pd.getAllProductDetail(p.getProductId().getProductId());

            List<TblColor> stp = pd.getAllColor();
            List<TblSize> pdc = pd.getAllSize();
            model.addAttribute("listSize", pdc);
            model.addAttribute("listColor", stp);
            model.addAttribute("id", p.getProductId().getProductId());
            model.addAttribute("productDetail", pr);
            return "redirect:Admin/ListProductDetail.htm?Id=" + p.getProductId();
        } else {
            model.addAttribute("messs", "Them moi ko thanh cong");
            return "Admin/UpdateProductDetail";
        }
    }

    @RequestMapping(value = "/deleteProductDetail")
    public String changeStt(HttpSession session, Model model, @RequestParam("Id") int id) {

        boolean allProduct = ord.deleteOrderDetailbyId(id);
        TblOrder order = ord.getOrderbyId(id);
        model.addAttribute("order", order);
        model.addAttribute("listOrderDetail", allProduct);
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        model.addAttribute("mess", "Xóa thành công");
        return "Admin/ListOrderDetail";
    }

    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public String UpdateProduct(HttpSession session, Model model, @ModelAttribute("product") TblProduct p, HttpServletRequest request) {

        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        String path = request.getRealPath("/Views/Image");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Views\\Image";
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
                    p.setImgProduct("HRS/Views/Image/" + dateString + extension);
                    fi.write(new File(path + "/" + dateString + extension));
                } else {
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "productName":
                                p.setProductName(value);
                                break;
                            case "priceOlder":
                                p.setPriceOlder(Double.parseDouble(value));
                                break;
                            case "description":
                                p.setDescription(value);
                                break;
                            case "status":
                                p.setStatus(Integer.parseInt(value));
                                break;
                            case "subProductTypeId.subProductTypeId":
                                TblSubProductType spt = new TblSubProductType();
                                spt.setSubProductTypeId(Integer.parseInt(value));
                                p.setSubProductTypeId(spt);
                                break;
                            case "producerId.producerId":
                                TblProducer pdc = new TblProducer();
                                pdc.setProducerId(Integer.parseInt(value));
                                p.setProducerId(pdc);
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

        boolean a = pd.updateProduct(p);
        if (a) {
            List<TblProduct> allProducer = pd.getAllProduct();
//         model.addAllAttributes("list",allProduct);
            model.addAttribute("listProduct", allProducer);

            return "Admin/ds_sanpham";
        } else {
            model.addAttribute("messs", "Them moi ko thanh cong");
            return "Admin/UpdateProduct";
        }
    }
}
