package com.experts.easysale.api;
import com.experts.easysale.domain.Item;
import com.experts.easysale.domain.ItemList;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@RestController
@RequestMapping(value="/items/**")
public class ItemPage {
    @Autowired
    ItemService service;

    @RequestMapping(value="/items",method= RequestMethod.GET)
    ResponseEntity<List<Item>> getAllItems()
    {
        List<Item> allItems=service.getAllItems();
        if(allItems.isEmpty())
        {
            return  new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Item>>(allItems,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/itemlist",method= RequestMethod.GET)
    ResponseEntity<List<ItemList>> getItemList(@PathVariable("id") long id)
    {
        List<ItemList> itemLists=service.getItemList(id);
        if(itemLists.isEmpty())
        {
            return new ResponseEntity<List<ItemList>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ItemList>>(itemLists,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/orderline",method= RequestMethod.GET)
    ResponseEntity<List<OrderLine>> getOrderLine(@PathVariable("id")long id)
    {
        List<OrderLine> orderLines=service.getOrderLine(id);
        if(orderLines.isEmpty())
        {
            return new ResponseEntity<List<OrderLine>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<OrderLine>>(orderLines,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Item> getItem(@PathVariable("id") long id)
    {
        Item item=service.getItem(id);

        if(item==null)
        {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Item>(item,HttpStatus.CREATED);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Item> addItem(@RequestBody Item item)
    {
        service.addItem(item);
        return new ResponseEntity<Item>(item,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Item> updateItem(@PathVariable("id") long id,@RequestBody Item item)
    {
        Item oldItem=service.getItem(id);
        if(oldItem==null)
        {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        Item newItem=new Item
                .Builder(item.getDescription())
                .copy(item)
                .id(id)
                .build();
        service.updateItem(newItem);
        return new ResponseEntity<Item>(newItem,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<Item> deleteItem(@PathVariable("id")long id)
    {
        Item item=service.getItem(id);
        if(item==null)
        {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        service.deleteItem(item);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
}
