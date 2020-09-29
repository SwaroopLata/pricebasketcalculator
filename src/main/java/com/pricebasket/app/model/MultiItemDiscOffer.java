package com.pricebasket.app.model;

public class MultiItemDiscOffer {
    private String souceitemName;
    private String offerItemName;
    private int srcQuantity;
    private double disc;

    public String getSouceitemName() {
        return souceitemName;
    }

    public String getOfferItemName() {
        return offerItemName;
    }

    public int getSrcQuantity() {
        return srcQuantity;
    }

    public double getDisc() {
        return disc;
    }

    public MultiItemDiscOffer(String souceitemName, String offerItemName, int srcQuantity, double disc) {
        this.souceitemName = souceitemName;
        this.offerItemName = offerItemName;
        this.srcQuantity = srcQuantity;
        this.disc = disc;
    }
}
