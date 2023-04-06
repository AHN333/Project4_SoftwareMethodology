package model;

import java.util.ArrayList;

public class Coffee {
    private String cupSize;
    ArrayList<String> addOns = new ArrayList<String>();

    public Coffee(String cupSize, ArrayList addOns){
        this.cupSize = cupSize;
        this.addOns = addOns;
    }


}
