package model;

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
     * @param flavor
     * @param type
     * @param quantity
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
     * @return
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Getter method for donut type.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * ToString method for donut flavor, type, and quantity.
     * @return
     */
    @Override
    public String toString() {
        return this.flavor +" "+this.type+"\tx"+this.quantity;
    }
}
