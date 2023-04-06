package model;

import java.util.HashMap;

public abstract class MenuItem {

    public final static double YEAST_PRICE = 1.59;
    public final static double CAKE_PRICE = 1.79;
    public final static double HOLE_PRICE = 0.39;

    public final static double SHORT_PRICE = 1.89;
    public final static double TALL_PRICE = 2.29;
    public final static double GRANDE_PRICE = 2.69;
    public final static double VENTI_PRICE = 3.09;
    public final static double ADDON_PRICE = 0.30;
    public final static double TAX = 0.06625;

    public static final HashMap<String, Double> SIZE_MAP = new HashMap<>();
    static {
        SIZE_MAP.put("short", SHORT_PRICE);
        SIZE_MAP.put("tall", TALL_PRICE);
        SIZE_MAP.put("grande", GRANDE_PRICE);
        SIZE_MAP.put("venti", VENTI_PRICE);
    }

    public static final HashMap<String, Double> DONUT_MAP = new HashMap<>();
    static {
        DONUT_MAP.put("yeast donut", YEAST_PRICE);
        DONUT_MAP.put("cake donut", CAKE_PRICE);
        DONUT_MAP.put("donut hole", HOLE_PRICE);
    }


    int quantity;

    public MenuItem(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double itemPrice();
}
