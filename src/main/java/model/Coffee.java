package model;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private String cupSize;
    private ArrayList<String> addOns = new ArrayList<String>();

    public Coffee(String cupSize, ArrayList addOns, int quantity){
        super(quantity);
        this.cupSize = cupSize;
        this.addOns = addOns;
    }


    @Override
    public double itemPrice() {
        double price = MenuItem.SIZE_MAP.get(this.cupSize.toLowerCase()) + (this.addOns.size() * MenuItem.ADDON_PRICE);
        return price * this.quantity;
    }

    public String getCupSize() {
        return cupSize;
    }

    @Override
    public String toString() {
        return this.cupSize + " " + this.addOns.size() + " addon(s) x" + this.quantity ;
    }
}
