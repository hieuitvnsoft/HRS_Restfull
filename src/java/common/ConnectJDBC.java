/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class ConnectJDBC {
    final static String host="jdbc:sqlserver://localhost\\MSI\\SQLEXPRESS:1433;databaseName=HIEURINSHOP";
    final static String username="sa";
    final static String pass ="1234$";
    Connection conn;
    public Connection ConnectJDBC() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection(host, username, pass);
          
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi đạo đức");
            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Mời import JDBC");
            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
    }
}
