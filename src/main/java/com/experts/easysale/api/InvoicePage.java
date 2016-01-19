package com.experts.easysale.api;
import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.services.InvoiceService;
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
@RequestMapping(value="/invoices/**")
public class InvoicePage {
    @Autowired
    InvoiceService service;

    @RequestMapping(value="/invoices",method= RequestMethod.GET)
    ResponseEntity<List<Invoice>> getAllInvoices()
    {
        List<Invoice> invoiceList=service.getAllInvoice();
        if(invoiceList.isEmpty())
        {
            return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Invoice>>(invoiceList,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Invoice> getInvoice(@PathVariable("id") long id)
    {
        Invoice invoice=service.getInvoice(id);
        if(invoice==null)
        {
            return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Invoice>(invoice,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/orderline",method= RequestMethod.GET)
    ResponseEntity<List<OrderLine>> getInvoiceOrderLine(@PathVariable("id") long id)
    {
        List<OrderLine> orderlines=service.getItems(id);

        if(orderlines.isEmpty())
        {
            return new ResponseEntity<List<OrderLine>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<OrderLine>>(orderlines,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Invoice> updateInvoice(@PathVariable("id") long id,@RequestBody Invoice invoice)
    {
        Invoice oldInvoice=service.getInvoice(id);
        if(oldInvoice==null)
        {
            return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
        }

        Invoice newInvoice=new Invoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .id(id)
                .build();
        service.updateInvoice(newInvoice);

        return new ResponseEntity<Invoice>(newInvoice,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<Invoice> deleteInvoice(@PathVariable("id")long id)
    {
        Invoice invoice=service.getInvoice(id);

        if(invoice==null)
        {
            return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
        }

        service.deleteInvoice(invoice);
        return new ResponseEntity<Invoice>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice)
    {
        service.addInvoice(invoice);

        return new ResponseEntity<Invoice>(invoice,HttpStatus.CREATED);
    }
}
