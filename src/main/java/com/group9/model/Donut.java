package com.group9.model;

/**
 * Donut class for donut types and flavors.
 * @author William Barrese, Andy Nguyen
 */
public class Donut extends MenuItem{
    /**
     * Donut flavor.
     */
    private String flavor;
    /**
     * Donut type.
     */
    private String type;

    /**
     * Constructor for donut with flavor, type, and quantity.
     * @param flavor Flavor of donut
     * @param type Type of donuts
     * @param quantity Amount of donuts
     */
    public Donut(String flavor, String type, int quantity){
        super(quantity);
        this.flavor = flavor;
        this.type = type;
    }

    /**
     * Method to calculate price of donuts.
     * @return price of donut times the quantity.
     */
    @Override
    public double itemPrice() {
        double price = MenuItem.DONUT_MAP.get(type.toLowerCase());
        return price * quantity;
    }

    /**
     * Getter method for donut flavor.
     * @return flavor of donut
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Getter method for donut type.
     * @return Type of donut
     */
    public String getType() {
        return type;
    }

    /**
     * ToString method for donut flavor, type, and quantity.
     * @return String used by GUI to display a donut menu item
     */
    @Override
    public String toString() {
        return this.flavor +" "+this.type+"\tx"+this.quantity;
    }
}
