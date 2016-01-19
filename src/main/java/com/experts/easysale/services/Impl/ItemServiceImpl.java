package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Item;
import com.experts.easysale.domain.ItemList;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.repository.ItemRepository;
import com.experts.easysale.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> getAllItems() {
        List<Item> allItems=new ArrayList<Item>();

        Iterable<Item> items=repository.findAll();
        for(Item i:items)
        {
            allItems.add(i);
        }

        return allItems;
    }

    @Override
    public List<ItemList> getItemList(long id) {
        return repository.findOne(id).getItemList();
    }

    @Override
    public List<OrderLine> getOrderLine(long id) {
        return repository.findOne(id).getOrderList();
    }

    @Override
    public Item getItem(long id) {
        return repository.findOne(id);
    }

    @Override
    public Item addItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        repository.delete(item);
    }
}
