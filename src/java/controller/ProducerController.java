/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BackEndDAO.ProducerDAO;
import entities.TblAdmin;
import entities.TblProducer;
import java.util.List;
import javax.servlet.http.HttpSession;
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
public class ProducerController {

    ProducerDAO pd = new ProducerDAO();

    @RequestMapping(value = "/listProducer")
    public String getAllProducer(HttpSession session, Model model) {
        List<TblProducer> allProducer = pd.getAllProducer();
//         model.addAllAttributes("list",allProduct);
        model.addAttribute("listProducer", allProducer);
        return "Admin/ListProducer";
    }

   

    @RequestMapping(value = "/insertProducer", method = RequestMethod.POST)
    public String insertProducer(HttpSession session, Model model, @ModelAttribute("producer") TblProducer p) {
      

            boolean a = pd.insertProducer(p);
            if (a) {
                List<TblProducer> allProducer = pd.getAllProducer();
//         model.addAllAttributes("list",allProduct);
                model.addAttribute("listProducer", allProducer);

                return "Admin/ListProducer";
            } else {
                 model.addAttribute("messs", "Them moi ko thanh cong");
                return "Admin/InsertProducer";
            }
    }

    @RequestMapping(value = "/insertProducer", method = RequestMethod.GET)
    public String a(HttpSession session, Model model) {
        return "Admin/InsertProducer";

    }
}
