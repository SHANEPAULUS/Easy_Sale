package com.experts.easysale.api;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.services.OrderLineService;
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
@RequestMapping(value="/orderlines/**")
public class OrderLinePage {
    @Autowired
    OrderLineService service;

    @RequestMapping(value="/orderlines",method= RequestMethod.GET)
    ResponseEntity<List<OrderLine>> getAllOrderLines()
    {
        List<OrderLine> allOrderLines=service.getAllOrderLines();
        if(allOrderLines.isEmpty())
        {
            return new ResponseEntity<List<OrderLine>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<OrderLine>>(allOrderLines,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    ResponseEntity<OrderLine> getOrderLine(@PathVariable("id")long id)
    {
        OrderLine orderLine=service.getOrderLine(id);
        if(orderLine==null)
        {
            return new ResponseEntity<OrderLine>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<OrderLine>(orderLine,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderLine> addOrderLine(@RequestBody OrderLine orderLine)
    {
        service.addOrderLine(orderLine);
        return new ResponseEntity<OrderLine>(orderLine,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderLine> updateOrderLine(@PathVariable("id")long id,@RequestBody OrderLine orderLine)
    {
        OrderLine oldOrderLine=service.getOrderLine(id);
        if(oldOrderLine==null)
        {
            return new ResponseEntity<OrderLine>(HttpStatus.NOT_FOUND);
        }

        OrderLine newOrderLine=new OrderLine
                .Builder(orderLine.getQuantity())
                .copy(orderLine)
                .id(id)
                .build();
        service.updateOrderLine(newOrderLine);
        return new ResponseEntity<OrderLine>(newOrderLine,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<OrderLine> deleteOrderLine(@PathVariable("id") long id)
    {
        OrderLine orderLine=service.getOrderLine(id);
        if(orderLine==null)
        {
            return new ResponseEntity<OrderLine>(HttpStatus.NOT_FOUND);
        }

        service.deleteOrderLine(orderLine);
        return new ResponseEntity<OrderLine>(HttpStatus.NO_CONTENT);
    }
}
