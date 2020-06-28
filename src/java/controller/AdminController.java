/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BackEndDAO.*;
import entities.TblAdmin;
import entities.TblProduct;
import entities.TblUser;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/Admin")
public class AdminController {

    private AdminDAO ad = new AdminDAO();
    private ProductDAO pd = new ProductDAO();
    private OrderDAO od = new OrderDAO();

    @RequestMapping(value = "/home")
    public String homeAdmin(HttpSession session, Model model) {
        if (session == null || session.getAttribute("loginAdmin") == null) {

            return "Admin/login";
        } else {

            TblAdmin a = (TblAdmin) session.getAttribute("loginAdmin");
            model.addAttribute("adminName", a.getFullName());
            model.addAttribute("adminImage", a.getAvatar());

            return "Admin/home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model m) {

        TblAdmin admin = ad.checkLogin(username, password);
        if (admin != null) {
            //HttpSession loginAdmin = (HttpSession) list;
            session.setAttribute("loginAdmin", admin);
            session.setAttribute("adminName", admin.getFullName());
            session.setAttribute("adminImage", admin.getAvatar());
            int i1 = new OrderDAO().countOrderNew();
            int i2 = new OrderDAO().countOrderDetroy();
            session.setAttribute("orderNew", i1);
            session.setAttribute("orderDetroy", i2);
            return "Admin/home";
        } else {
            m.addAttribute("messs", "Tài khoản hoặc mật khẩu chưa đúng! Xin kiểm tra lại");
            return "Admin/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model m) {
        session.setAttribute("loginAdmin", null);
        return "redirect:/Admin/home.htm";

    }
   

}
