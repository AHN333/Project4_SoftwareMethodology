package model;

import javafx.collections.ObservableList;

import java.util.*;

public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public Order(int orderNumber, ArrayList menuItems){
        this.orderNumber = orderNumber;
        this.menuItems = menuItems;
    }

    /**
     * Adds one item to the hashmap
     * @param item
     * @param amount
     */
    public void add(MenuItem item){
        this.menuItems.add(item);
    }

    public void addDonut(String type, String flavor, int amount){
        this.menuItems.add(new Donut(type,flavor,amount));
    }

//    public String getDisplayString(MenuItem item){
//        String disp = "";
//        if(item instanceof Coffee){
//            disp = ((Coffee) item).getCupSize();
//        } else if (item instanceof Donut) {
//            disp = ((Donut) item).flavor +" "+ ((Donut) item).type;
//        }
//        return disp + "\t x" + this.menuItems.get(item);
//    }

    /**
     * Removes entire quantity of selectedItem
     * @param selectedItem Name of item to be removed
     */
    public void remove(MenuItem selectedItem) {
        this.menuItems.remove(selectedItem);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotal(){
        double sub = 0.0;
        for (MenuItem item:
             this.menuItems) {
            sub += item.itemPrice();
        }
        return sub * (1.0 + MenuItem.TAX);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
