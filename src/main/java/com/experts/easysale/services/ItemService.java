package com.experts.easysale.services;

import com.experts.easysale.domain.Item;
import com.experts.easysale.domain.ItemList;
import com.experts.easysale.domain.OrderLine;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface ItemService {
    List<Item> getAllItems();
    List<ItemList> getItemList(long id);
    List<OrderLine> getOrderLine(long id);
    Item getItem(long id);
    Item addItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Item item);
}
