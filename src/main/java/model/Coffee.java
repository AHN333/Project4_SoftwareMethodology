package model;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private String cupSize;
    ArrayList<String> addOns = new ArrayList<String>();

    public Coffee(String cupSize, ArrayList addOns){
        this.cupSize = cupSize;
        this.addOns = addOns;
    }


    @Override
    public double itemPrice(int quantity) {
        double price = 0;
        return price;
    }
}
