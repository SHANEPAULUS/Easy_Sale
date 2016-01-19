package com.experts.easysale.api;
import com.experts.easysale.domain.ItemList;
import com.experts.easysale.services.ItemListService;
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
@RequestMapping(value="/itemlists/**")
public class ItemListPage {
    @Autowired
    ItemListService service;

    @RequestMapping(value="/itemlists",method= RequestMethod.GET)
    ResponseEntity<List<ItemList>> getAllItemLists()
    {
        List<ItemList> itemLists=service.getAllItemLists();
        if(itemLists.isEmpty())
        {
            return new ResponseEntity<List<ItemList>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ItemList>>(itemLists,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ItemList> addItemList(@RequestBody ItemList itemList)
    {
        service.addItemList(itemList);

        return new ResponseEntity<ItemList>(itemList,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ItemList> getItemList(@PathVariable("id")long id)
    {
        ItemList itemList=service.getItemList(id);
        if(itemList==null)
        {
            return new ResponseEntity<ItemList>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ItemList>(itemList,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ItemList> updateItemList(@PathVariable("id")long id,@RequestBody ItemList itemList)
    {
        ItemList oldItemList=service.getItemList(id);

        if(oldItemList==null)
        {
            return new ResponseEntity<ItemList>(HttpStatus.NOT_FOUND);
        }

        ItemList newItemList=new ItemList
                .Builder(itemList.getQuantity())
                .copy(itemList)
                .id(id)
                .build();

        service.updateItemList(newItemList);
        return new ResponseEntity<ItemList>(newItemList,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<ItemList> deleteItemList(@PathVariable("id") long id)
    {
        ItemList itemList=service.getItemList(id);
        if(itemList==null)
        {
            return new ResponseEntity<ItemList>(HttpStatus.NOT_FOUND);
        }

        service.deleteItemList(itemList);
        return new ResponseEntity<ItemList>(HttpStatus.NO_CONTENT);
    }
}
