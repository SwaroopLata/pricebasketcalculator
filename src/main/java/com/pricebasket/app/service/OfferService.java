package com.pricebasket.app.service;



import com.pricebasket.app.dal.OfferDAO;
import com.pricebasket.app.model.MultiItemDiscOffer;
import com.pricebasket.app.model.SingleItemDiscOffer;

import java.util.List;

public class OfferService {
    OfferDAO offerDao;
    public OfferService(OfferDAO offerDao){
        this.offerDao = offerDao;
    }

    public List<SingleItemDiscOffer> getSinleItemOffers() {
        return offerDao.getSinleItemOffers();
    }

    public List<MultiItemDiscOffer> getMultiItemOffers() {
        return offerDao.getMultiItemOffers();
    }
}
