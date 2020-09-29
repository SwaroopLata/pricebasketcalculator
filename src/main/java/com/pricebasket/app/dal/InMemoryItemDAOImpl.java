package com.pricebasket.app.dal;


import com.pricebasket.app.model.Item;

import java.util.Arrays;
import java.util.List;

public class InMemoryItemDAOImpl implements ItemDAO {
    List<Item> items;
    public InMemoryItemDAOImpl(){
        items = Arrays.asList(
                new Item("Soup", .65),
                new Item("Bread", .80),
                new Item("Milk", 1.30),
                new Item("Apples", 1.00)
        );

    }
    public Item getItem(String itemName){
        return items.stream()
                .filter(t->t.getItemName().equals(itemName)).findFirst().orElse(null);
    }
}
