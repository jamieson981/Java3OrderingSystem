/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Alex
 */
public class TableNumber {
    private int id;
    private int custOrderId;
    private int orderItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustOrderId() {
        return custOrderId;
    }

    public void setCustOrderId(int custOrderId) {
        this.custOrderId = custOrderId;
    }

    public int getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(int orderItems) {
        this.orderItems = orderItems;
    }

}
