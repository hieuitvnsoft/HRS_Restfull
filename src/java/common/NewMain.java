/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String date="Aug 21, 2019";
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ds  = new SimpleDateFormat("MMM dd, yyyy").parse(date);
            System.out.println(ds);
            System.out.println(d.format(ds));
        } catch (ParseException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
