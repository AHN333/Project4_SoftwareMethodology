package model;

public class Donut extends MenuItem{
    private String flavor;
    private String type;

    public Donut(String flavor, String type, int quantity){
        super(quantity);
        this.flavor = flavor;
        this.type = type;
    }

    @Override
    public double itemPrice() {
        double price = MenuItem.DONUT_MAP.get(type.toLowerCase());
        return price * quantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.flavor +" "+this.type+"\tx"+this.quantity;
    }
}
