package com.pricebasket.app.service;

import com.pricebasket.app.dal.InMemoryItemDAOImpl;
import com.pricebasket.app.dal.ItemDAO;
import com.pricebasket.app.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
    ItemDAO itemDAOMock = mock(ItemDAO.class);
    @Test
    public void ShouldReturnItemsIfProductExists() {
        when(itemDAOMock.getItem("Apples")).thenReturn(new Item("Apples",1.00));

        ItemService itemService = new ItemService(itemDAOMock);
        Item item = itemService.getItem("Apples");
        assertEquals(item.getItemName(), "Apples");
        assertEquals(Double.toString(item.getPrice()), "1.0");
    }

    @Test
    public void ShouldReturnNullIfProductNotExists() {
        when(itemDAOMock.getItem("Banana")).thenReturn(null);

        ItemService itemService = new ItemService(itemDAOMock);
        Item item = itemService.getItem("Banana");
        assertEquals(item, null);
    }

}