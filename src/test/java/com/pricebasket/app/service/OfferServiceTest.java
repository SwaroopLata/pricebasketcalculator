package com.pricebasket.app.service;

import com.pricebasket.app.dal.OfferDAO;
import com.pricebasket.app.model.MultiItemDiscOffer;
import com.pricebasket.app.model.SingleItemDiscOffer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceTest {
    OfferDAO offerDAO = mock(OfferDAO.class);

    @Test
    public void ShouldReturnSingleItemOffersIfExists() {

        when(offerDAO.getSinleItemOffers()).thenReturn(Arrays.asList(
                new SingleItemDiscOffer("Apples", 10)
        ));

        List<SingleItemDiscOffer> expectedOffers = Arrays.asList(
                new SingleItemDiscOffer("Apples", 10)
        );
        OfferService offerService = new OfferService(offerDAO);
        List<SingleItemDiscOffer> offers = offerService.getSinleItemOffers();
        assertEquals(offers.get(0).getItemName(), expectedOffers.get(0).getItemName());
        assertEquals(Double.toString(offers.get(0).getDisc()), Double.toString(expectedOffers.get(0).getDisc()));
    }

    @Test
    public void ShouldReturnMultiItemOffersIfExists() {

        when(offerDAO.getMultiItemOffers()).thenReturn(Arrays.asList(
                new MultiItemDiscOffer("Soup", "Bread", 2, 50)
        ));

        List<MultiItemDiscOffer> expectedOffers = Arrays.asList(
                new MultiItemDiscOffer("Soup", "Bread", 2, 50)
        );
        OfferService offerService = new OfferService(offerDAO);
        List<MultiItemDiscOffer> offers = offerService.getMultiItemOffers();
        assertEquals(offers.get(0).getOfferItemName(), expectedOffers.get(0).getOfferItemName());
        assertEquals(offers.get(0).getSouceitemName(), expectedOffers.get(0).getSouceitemName());
        assertEquals(Double.toString(offers.get(0).getDisc()), Double.toString(expectedOffers.get(0).getDisc()));
    }
}