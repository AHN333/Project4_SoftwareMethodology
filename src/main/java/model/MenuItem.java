package model;

public abstract class MenuItem {
    public final static double YEAST_PRICE = 1.59;
    public final static double CAKE_PRICE = 1.79;
    public final static double HOLE_PRICE = 0.39;

    public final static double SHORT_PRICE = 1.89;
    public final static double TALL_PRICE = 2.29;
    public final static double GRANDE_PRICE = 2.69;
    public final static double VENTI_PRICE = 3.09;
    public final static double ADDON_PRICE = 0.30;
    public abstract double itemPrice(int quantity);
}
