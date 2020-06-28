/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import entities_extend.Product;
import entities_extend.ProductDAO;
import entities_extend.ProductDetail;
import entities_extend.ProductType;
import entities_extend.SubProductType;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */
@Path(value = "/product")
public class ProductWebservice {

    @GET
    @Path(value = "/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProduct() {
        List<Product> a = new ProductDAO().getAlll();
        
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
    @GET
    @Path(value = "/getAllProductType")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProductType() {
       List<ProductType>  a= new ProductDAO().getAllProductType();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
     @GET
    @Path(value = "/getAllSubProductType")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllSubProductType() {
       List<SubProductType>  a= new ProductDAO().getAllSubProductType();
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
     @GET
    @Path(value = "/getAllProductByName")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProductByName(@QueryParam("id" ) int  id, @QueryParam("name") @DefaultValue("") String name) {
       List<Product>  a= new ProductDAO().getProductByName(id, name);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
    @GET
    @Path(value = "/getAllProductDetail")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProductDetails(@QueryParam("id" ) int  id) {
       List<ProductDetail>  a= new ProductDAO().getAllDetail(id);
        Gson son = new Gson();
        String data = son.toJson(a);
        return data;
    }
    
}
