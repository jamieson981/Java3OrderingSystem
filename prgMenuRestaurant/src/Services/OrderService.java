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
    public int save(int tableNo, BigDecimal total, String paymentType) {  
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();

        String sql = "INSERT INTO Orders (total, table_no, payment_type) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        
        try {
            stmt = conn.prepareStatement(sql, new String[] {"id"} );
            stmt.setBigDecimal(1, total);
            stmt.setInt(2, tableNo);
            stmt.setString(3, paymentType);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
               int id = rs.getInt(1);
               return id;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public void saveItem(int orderId, int menuItemId) {
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();

        String sql = "INSERT INTO OrderItems (order_id, menuItem_id) VALUES (?, ?)";
        PreparedStatement stmt;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            stmt.setInt(2, menuItemId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
        
}
