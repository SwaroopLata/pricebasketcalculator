package com.pricebasket.app.model;

public class SingleItemDiscOffer {
    public String getItemName() {
        return itemName;
    }

    private String itemName;

    public double getDisc() {
        return disc;
    }

    private double disc;

    public SingleItemDiscOffer(String itemName, double disc) {
        this.itemName = itemName;
        this.disc = disc;
    }
}
