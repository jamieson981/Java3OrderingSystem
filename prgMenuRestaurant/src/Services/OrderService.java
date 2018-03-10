/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.MenuItem;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class OrderService {
    public void save(int tableNo, BigDecimal total) {        
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();
        String sql = " insert into orders (table_no, total)"
        + " values (?, ?)";
        PreparedStatement stmt;
        
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            
            stmt.setBigDecimal(tableNo, total);
            stmt.setInt(tableNo, tableNo);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
       
        
        
    }
        
}
