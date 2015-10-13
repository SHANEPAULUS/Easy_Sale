package com.experts.easysale.services;

import com.experts.easysale.domain.Item;
import com.experts.easysale.domain.ItemList;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface ItemListService {
    List<ItemList> getAllItemLists();
    ItemList addItemList(ItemList itemList);
    ItemList getItemList(long id);
    ItemList updateItemList(ItemList itemList);
    void deleteItemList(ItemList itemList);
}
