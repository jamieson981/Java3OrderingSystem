/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class DBService {
    private static final String DBUSER = "alexJamieson";
    private static final String DBPASS = "JavaProject";
    private static Connection conn;
    
    public static Connection connect(){
        conn = null;
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://159.203.101.106/orderingSystem", DBUSER, DBPASS);
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Database access error",
                        JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
         
        return conn;
    }
}
