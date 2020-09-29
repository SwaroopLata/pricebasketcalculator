package com.pricebasket.app.dal;

import com.pricebasket.app.model.Item;

public interface ItemDAO {
    Item getItem(String itemName);
}
