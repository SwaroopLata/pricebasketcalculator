package com.pricebasket.app.service;


import com.pricebasket.app.model.BasketResult;
import com.pricebasket.app.model.Item;
import com.pricebasket.app.model.MultiItemDiscOffer;
import com.pricebasket.app.model.SingleItemDiscOffer;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    OfferService offerServiceMock = mock(OfferService.class);
    ItemService itemServiceMock = mock(ItemService.class);

    @Test
    public void ShouldReturnCorrectTotalAndSubTotalWithoutAnyOffers() {

        when(itemServiceMock.getItem("Apples")).thenReturn(new Item("Apples",1.00));
        when(itemServiceMock.getItem("Bread")).thenReturn(new Item("Bread",.50));


        String[] bItems = new String[]{"Apples", "Bread"};

        BasketService basketService = new BasketService(itemServiceMock, offerServiceMock);
        BasketResult result = basketService.ProcessBasket(bItems);
        assertEquals(Double.toString(result.getTotal()), "1.5");
        assertEquals(Double.toString(result.getSubTotal()), "1.5");

    }

    @Test
    public void ShouldReturnCorrectTotalAndSubTotalWithSingleItemOffer() {

        when(itemServiceMock.getItem("Apples")).thenReturn(new Item("Apples",1.00));
        when(itemServiceMock.getItem("Bread")).thenReturn(new Item("Bread",.50));

        when(offerServiceMock.getSinleItemOffers()).thenReturn(Arrays.asList(
                new SingleItemDiscOffer("Apples", 10)
        ));


        String[] bItems = new String[]{"Apples", "Bread"};

        BasketService basketService = new BasketService(itemServiceMock, offerServiceMock);
        BasketResult result = basketService.ProcessBasket(bItems);
        assertEquals(Double.toString(result.getTotal()), "1.4");
        assertEquals(Double.toString(result.getSubTotal()), "1.5");

    }

    @Test
    public void ShouldReturnCorrectTotalAndSubTotalWithMultiItemOffer() {

        when(itemServiceMock.getItem("Soup")).thenReturn(new Item("Soup",1.00));
        when(itemServiceMock.getItem("Bread")).thenReturn(new Item("Bread",.50));

        when(offerServiceMock.getMultiItemOffers()).thenReturn(Arrays.asList(
                new MultiItemDiscOffer("Soup", "Bread", 2, 50)
        ));


        String[] bItems = new String[]{"Soup", "Soup" , "Bread"};

        BasketService basketService = new BasketService(itemServiceMock, offerServiceMock);
        BasketResult result = basketService.ProcessBasket(bItems);
        assertEquals(Double.toString(result.getTotal()), "2.25");
        assertEquals(Double.toString(result.getSubTotal()), "2.5");

    }

    @Test
    public void ShouldReturnCorrectTotalAndSubTotalWithBothSingleAndMultiItemOffer() {

        when(itemServiceMock.getItem("Soup")).thenReturn(new Item("Soup",1.00));
        when(itemServiceMock.getItem("Bread")).thenReturn(new Item("Bread",1.00));
        when(itemServiceMock.getItem("Apples")).thenReturn(new Item("Apples",1.00));
        when(itemServiceMock.getItem("Milk")).thenReturn(new Item("Milk",.50));

        when(offerServiceMock.getSinleItemOffers()).thenReturn(Arrays.asList(
                new SingleItemDiscOffer("Apples", 10)
        ));

        when(offerServiceMock.getMultiItemOffers()).thenReturn(Arrays.asList(
                new MultiItemDiscOffer("Soup", "Bread", 2, 50)
        ));


        String[] bItems = new String[]{"Apples","Milk",  "Soup", "Soup", "Bread" };

        BasketService basketService = new BasketService(itemServiceMock, offerServiceMock);
        BasketResult result = basketService.ProcessBasket(bItems);
        assertEquals(Double.toString(result.getTotal()), "3.9000000000000004");
        assertEquals(Double.toString(result.getSubTotal()), "4.5");

    }

}