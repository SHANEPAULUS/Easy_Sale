package com.experts.easysale.api;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Sale;
import com.experts.easysale.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@RestController
@RequestMapping(value="/sales/**")
public class SalePage {

    @Autowired
    SaleService service;

    @RequestMapping(value="/",method= RequestMethod.GET)
    ResponseEntity<List<Sale>> getAllSales()
    {
        List<Sale> sales=service.getAllSales();
        if(sales.isEmpty())
        {
            return  new ResponseEntity<List<Sale>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Sale>>(sales,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/bids",method= RequestMethod.GET)
    ResponseEntity<List<Bid>> getSaleBids(@PathVariable("id")long id)
    {
        List<Bid> bids=service.getSaleBids(id);
        if(bids.isEmpty())
        {
            return new ResponseEntity<List<Bid>>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<List<Bid>>(bids,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    ResponseEntity<Sale> getSale(@PathVariable("id")long id)
    {
        Sale sale=service.getSale(id);
        if(sale==null)
        {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Sale>(sale,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    ResponseEntity<Sale> addSale(@RequestBody Sale sale)
    {
        service.addSale(sale);
        return new ResponseEntity<Sale>(sale,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT)
    ResponseEntity<Sale> updateSale(@PathVariable("id")long id,@RequestBody Sale sale)
    {
        Sale oldSale=service.getSale(id);
        if(oldSale==null)
        {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }

        Sale newSale=new Sale
                .Builder(sale.getPostedDate())
                .copy(sale)
                .id(id)
                .build();
        service.updateSale(newSale);
        return  new ResponseEntity<Sale>(newSale,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    ResponseEntity<Sale> deleteSale(@PathVariable("id")long id)
    {
        Sale sale=service.getSale(id);
        if(sale==null)
        {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }

        service.deleteSale(sale);
        return new ResponseEntity<Sale>(HttpStatus.NO_CONTENT);
    }
}
