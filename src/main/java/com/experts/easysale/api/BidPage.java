package com.experts.easysale.api;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */@RestController
   @RequestMapping(value="/bids/**")
public class BidPage {
    @Autowired
    BidService service;

    @RequestMapping(value="/",method= RequestMethod.GET)
    ResponseEntity<List<Bid>> getAllBids()
    {
        List<Bid> bids=service.getAllBids();
        if(bids.isEmpty())
        {
            return new ResponseEntity<List<Bid>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Bid>>(bids,HttpStatus.OK);

    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Bid> addBid(@RequestBody Bid bid)
    {
        service.addBid(bid);

        return new ResponseEntity<Bid>(bid,HttpStatus.CREATED);
    }


    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Bid> getBid(@PathVariable("id") long id)
    {
        Bid bid=service.getBid(id);
        if(bid==null)
        {
            return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Bid>(bid,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT)
    ResponseEntity<Bid> updateBid(@PathVariable("id") long id,@RequestBody Bid bid)
    {
        Bid oldBid=service.getBid(id);

        if(oldBid==null)
        {
            return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
        }

        Bid newBid=new Bid
                .Builder(bid.getAmount())
                .copy(bid)
                .id(id)
                .build();
        service.updateBid(newBid);
        return new ResponseEntity<Bid>(newBid,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<Bid> deleteBid(@PathVariable("id") long id)
    {
        Bid bid=service.getBid(id);
        if(bid==null)
        {
            return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
        }

        service.deleteBid(bid);
        return new ResponseEntity<Bid>(HttpStatus.NO_CONTENT);
    }
}
