package com.group9.model;

import java.util.ArrayList;

/**
 * Coffee class holds the cup size and add-ons.
 * @author William Barrese, Andy Nguyen
 */
public class Coffee extends MenuItem {
    /**
     * Cup size variable.
     */
    private String cupSize;
    /**
     * ArrayList for coffee add-ons.
     */
    private ArrayList<String> addOns = new ArrayList<String>();

    /**
     * Coffee constructor with cup size, add-ons, and quantity.
     * @param cupSize Cupsize, short, venti etc...
     * @param addOns List of addons
     * @param quantity Amount of cups of this coffee being added
     */
    public Coffee(String cupSize, ArrayList addOns, int quantity){
        super(quantity);
        this.cupSize = cupSize;
        this.addOns = addOns;
    }

    /**
     * Method to calculate price.
     * @return item price times the quantity
     */
    @Override
    public double itemPrice() {
        double price = SIZE_MAP.get(this.cupSize.toLowerCase()) + (this.addOns.size() * ADDON_PRICE);
        return price * this.quantity;
    }

    /**
     * Getter method for cup size.
     * @return cup size
     */
    public String getCupSize() {
        return cupSize;
    }

    /**
     * ToString method for coffee size, add-ons, and quantity.
     * @return String displayed in GUI for coffee menu items
     */
    @Override
    public String toString() {
        return this.cupSize + " " + this.addOns.size() + " addon(s) x" + this.quantity ;
    }
}
