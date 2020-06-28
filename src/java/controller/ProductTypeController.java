/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BackEndDAO.OrderDAO;
import BackEndDAO.ProductTypeDAO;
import entities.TblProductType;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/Admin")
public class ProductTypeController {

    ProductTypeDAO pd = new ProductTypeDAO();

    @RequestMapping(value = "/listType")
    public String getAllType(HttpSession session, Model model) {
        List<TblProductType> a = pd.getAllType();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("listType", a);
        int i1 = new OrderDAO().countOrderNew();
        int i2 = new OrderDAO().countOrderDetroy();
        session.setAttribute("orderNew", i1);
        session.setAttribute("orderDetroy", i2);
        return "Admin/ListProducer";
    }

}
