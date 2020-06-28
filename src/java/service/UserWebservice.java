/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities_extend.UserDAO;
import com.google.gson.Gson;
import entities_extend.Result;
import entities_extend.User;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
@Path(value = "/user")
public class UserWebservice {
    
    @GET
    @Path(value = "/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String userLogin(@QueryParam("username") String user, @QueryParam("password") String pass) {
        User a = new UserDAO().login(user, pass);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
    
    @GET
    @Path(value = "/register")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String Regiss(@QueryParam("data") String data) {
        User user = new User();
        Gson son = new Gson();
        Result n = new Result();
        try {
            JSONObject rootJSON = new JSONObject(data);
            String username = rootJSON.getString("username");
            String password = rootJSON.getString("password");
            String fullName = rootJSON.getString("fullName");
             String address = rootJSON.getString("address");
            String email = rootJSON.getString("email");
            String birthDay = rootJSON.getString("birthDay");
            boolean sex = rootJSON.getBoolean("sex");
            String avatar = rootJSON.getString("avatar");
            String phone = rootJSON.getString("phone");
            int point = rootJSON.getInt("point");
            Integer status = rootJSON.getInt("status");

            /// Check
             
            boolean a = new UserDAO().checkuser(username);
            if (a) {
                user.setFullName(fullName);
                user.setUserName(username);
                user.setPassword(password);
                user.setAddress(address);
                user.setEmail(email);
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    user.setBirthDay(f.parse(birthDay));
                } catch (ParseException ex) {
                    Logger.getLogger(UserWebservice.class.getName()).log(Level.SEVERE, null, ex);
                }
                user.setSex(sex);
                user.setAvatar(avatar.replace("\\",""));
                user.setPhone(phone);
                user.setPoint(BigInteger.valueOf(point));
                user.setStatus(status);
                boolean c =  new UserDAO().regis(user);
                if (c) {
                    n.setMessage("Đăng ký thành công-- Quay lại để đăng nhập");
                }
                else{
                n.setMessage("Lỗi hệ thống-- quay lại sau");
                }
            }else{
            
             n.setMessage("Tài khoản đã tồn tại. Xin chọn tài khoản khác");
            }
            
        } catch (JSONException ex) {
            Logger.getLogger(UserWebservice.class.getName()).log(Level.SEVERE, null, ex);
        }

//        byte[] decoded = Base64.getDecoder().decode(data);
//        String b = new String(decoded);
        // boolean b = new UserDAO().regis(user);
        //return "Dữ liệu: "+data;
       
       
        
        String bs = son.toJson(n);
        return bs;
    }
    
    @GET
    @Path(value = "/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getA() {
        List<User> a = new UserDAO().getAlll();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }

    @GET
    @Path(value = "/check")
    @Produces(MediaType.APPLICATION_JSON)
    public String check(@QueryParam("username") String username) {
        boolean a = new UserDAO().checkuser(username);
        Result n = new Result();
        n.setMessage("" + a);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
    
}
