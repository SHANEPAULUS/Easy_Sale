package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Item;
import com.experts.easysale.domain.ItemList;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.repository.ItemListRepository;
import com.experts.easysale.services.ItemListService;
import com.experts.easysale.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class ItemListServiceImpl implements ItemListService {
    @Autowired
    ItemListRepository repository;

    @Override
    public List<ItemList> getAllItemLists() {
        List<ItemList> allItemLists=new ArrayList<ItemList>();

        Iterable<ItemList> itemList=repository.findAll();
        for(ItemList items:itemList)
        {
            allItemLists.add(items);
        }

        return allItemLists;
    }

    @Override
    public ItemList addItemList(ItemList itemList) {
        return repository.save(itemList);
    }

    @Override
    public ItemList getItemList(long id) {
        return repository.findOne(id);
    }

    @Override
    public ItemList updateItemList(ItemList itemList) {
        return repository.save(itemList);
    }

    @Override
    public void deleteItemList(ItemList itemList) {
        repository.delete(itemList);
    }
}
