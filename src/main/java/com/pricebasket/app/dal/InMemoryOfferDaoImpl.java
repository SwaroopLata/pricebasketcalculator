package com.pricebasket.app.dal;



import com.pricebasket.app.model.MultiItemDiscOffer;
import com.pricebasket.app.model.SingleItemDiscOffer;

import java.util.Arrays;
import java.util.List;

public class InMemoryOfferDaoImpl implements OfferDAO {
    private List<SingleItemDiscOffer> singleOffers;
    List<MultiItemDiscOffer> multiItemOffers;

    public InMemoryOfferDaoImpl(){
        singleOffers = Arrays.asList(
                new SingleItemDiscOffer("Apples", 10)
        );

        multiItemOffers = Arrays.asList(
                new MultiItemDiscOffer("Soup", "Bread", 2, 50)
        );

    }

    @Override
    public List<SingleItemDiscOffer> getSinleItemOffers() {
        return singleOffers;
    }

    @Override
    public List<MultiItemDiscOffer> getMultiItemOffers() {
        return multiItemOffers;
    }
}
