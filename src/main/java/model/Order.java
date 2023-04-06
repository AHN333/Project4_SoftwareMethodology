package model;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    ArrayList<String> menuItems = new ArrayList<String>();

    public Order(int orderNumber, ArrayList menuItems){
        this.orderNumber = orderNumber;
        this.menuItems = menuItems;
    }
}
