package com.pricebasket.app.service;


import com.pricebasket.app.dal.ItemDAO;
import com.pricebasket.app.model.Item;

public class ItemService {
    ItemDAO itemDao;
    public ItemService(ItemDAO itemDao){
        this.itemDao = itemDao;
    }

    public Item getItem(String itemName){
        return itemDao.getItem(itemName);
    }
}
