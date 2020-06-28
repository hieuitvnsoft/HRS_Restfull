/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import service.PaymentWebservice;
import service.ProductWebservice;
import service.UserWebservice;


/**
 *
 * @author admin
 */
@ApplicationPath(value = "/rest")
public class ApplicationConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addResources(resources);
        return resources;
    }

    private void addResources(Set<Class<?>> resources) {
        resources.add(UserWebservice.class);
        resources.add(ProductWebservice.class);
        resources.add(PaymentWebservice.class);
    }
    
}
