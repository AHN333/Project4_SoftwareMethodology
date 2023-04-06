package com.group9.model;

import java.util.HashMap;

/**
 * MenuItem class holds properties and prices of menu items.
 * @author William Barrese, Andy Nguyen
 */
public abstract class MenuItem {
    /**
     *Price for yeast donut.
     */
    public final static double YEAST_PRICE = 1.59;
    /**
     *Price for cake donut.
     */
    public final static double CAKE_PRICE = 1.79;
    /**
     *Price for donut hole.
     */
    public final static double HOLE_PRICE = 0.39;
    /**
     *Price for short coffee.
     */
    public final static double SHORT_PRICE = 1.89;
    /**
     *Price for tall coffee.
     */
    public final static double TALL_PRICE = 2.29;
    /**
     *Price for grande coffee.
     */
    public final static double GRANDE_PRICE = 2.69;
    /**
     *Price for venti coffee.
     */
    public final static double VENTI_PRICE = 3.09;
    /**
     *Price for coffee add-ons.
     */
    public final static double ADDON_PRICE = 0.30;
    /**
     *Sales tax percentage.
     */
    public final static double TAX = 0.06625;
    /**
     * HashMap holds cup sizes and price.
     */
    public static final HashMap<String, Double> SIZE_MAP = new HashMap<>();
    static {
        SIZE_MAP.put("short", SHORT_PRICE);
        SIZE_MAP.put("tall", TALL_PRICE);
        SIZE_MAP.put("grande", GRANDE_PRICE);
        SIZE_MAP.put("venti", VENTI_PRICE);
    }

    /**
     * HashMap holds donut types and price.
     */
    public static final HashMap<String, Double> DONUT_MAP = new HashMap<>();
    static {
        DONUT_MAP.put("yeast donut", YEAST_PRICE);
        DONUT_MAP.put("cake donut", CAKE_PRICE);
        DONUT_MAP.put("donut hole", HOLE_PRICE);
    }

    /**
     * Variable for quantity.
     */
    int quantity;

    /**
     * Constructor with quantity defined.
     * @param quantity Amount of this item
     */
    public MenuItem(int quantity){
        this.quantity = quantity;
    }

    /**
     * Getter method for quantity.
     * @return Amount of this item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Abstract method for item price.
     * @return Price of menu item.
     */
    public abstract double itemPrice();
}
