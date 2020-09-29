package com.pricebasket.app.dal;


import com.pricebasket.app.model.MultiItemDiscOffer;
import com.pricebasket.app.model.SingleItemDiscOffer;

import java.util.List;

public interface OfferDAO {
    List<SingleItemDiscOffer> getSinleItemOffers();
    List<MultiItemDiscOffer>  getMultiItemOffers();
}
