/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.MenuItem;
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
public class MenuService {
    public List<MenuItem> getItems() {
        List<MenuItem> items = new ArrayList<MenuItem>();
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();
        
        String sql = "SELECT * FROM MenuItem";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                MenuItem item = new MenuItem();
                item.setId(set.getInt("id"));
                item.setItemName(set.getString("itemName"));
                item.setCategory(set.getString("category"));
                item.setPhoto(set.getString("photo"));
                item.setPrice(set.getBigDecimal("price"));
                item.setIngredients(set.getString("ingredients"));
                items.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
        return items;
    }
    
    public List<MenuItem> getItemsByCategory(String category) {
        List<MenuItem> items = new ArrayList<MenuItem>();
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();
        
        String sql = "SELECT * FROM MenuItem where category = ?";        
        PreparedStatement stmt;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,category);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                MenuItem item = new MenuItem();
                item.setId(set.getInt("id"));
                item.setItemName(set.getString("itemName"));
                item.setCategory(set.getString("category"));
                item.setPhoto(set.getString("photo"));
                item.setPrice(set.getBigDecimal("price"));                
                item.setIngredients(set.getString("ingredients"));
                items.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
        return items;
    }
    
        public MenuItem getItemByName(String itemName) {
        MenuItem item = new MenuItem();
        DBService dbservice = new DBService();
        Connection conn = dbservice.connect();
        
        String sql = "SELECT * FROM MenuItem where itemName = ? LIMIT 1";        
        PreparedStatement stmt;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,itemName);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                item.setId(set.getInt("id"));
                item.setItemName(set.getString("itemName"));
                item.setCategory(set.getString("category"));
                item.setPhoto(set.getString("photo"));
                item.setPrice(set.getBigDecimal("price"));
                item.setIngredients(set.getString("ingredients"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
        return item;
    }
}
