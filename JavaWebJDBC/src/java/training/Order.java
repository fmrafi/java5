/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tanvir
 */
public class Order {
    private int orderID;
    private String customer;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    private Date orderDate;
    private List<OrderLine> items;

    public Order() {
        items = new ArrayList<OrderLine>();
    }
    
    public List<OrderLine> getLines() {
        return items;
    }

    public void setLines(List<OrderLine> users) {
        this.items = users;
    }
    
}
