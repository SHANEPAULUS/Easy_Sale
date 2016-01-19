package com.experts.easysale.api;
import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.Person;
import com.experts.easysale.domain.Sale;
import com.experts.easysale.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@RestController
@RequestMapping(value="/persons/**")
public class PersonPage {
    @Autowired
    PersonService service;

    @RequestMapping(value="/persons",method= RequestMethod.GET)
    ResponseEntity<List<Person>> getAllPersons()
    {
        List<Person> allPersons=service.getAllPersons();
        if(allPersons.isEmpty())
        {
            return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Person>>(allPersons,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/invoices",method= RequestMethod.GET)
    ResponseEntity<List<Invoice>> getPersonInvoices(@PathVariable("id") long id)
    {
        List<Invoice> invoiceList=service.getPersonInvoices(id);
        if(invoiceList.isEmpty())
        {
            return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Invoice>>(invoiceList,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/sales",method= RequestMethod.GET)
    ResponseEntity<List<Sale>> getPersonSales(@PathVariable("id")long id)
    {
        List<Sale> sales=service.getPersonSales(id);
        if(sales.isEmpty())
        {
            return new ResponseEntity<List<Sale>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Sale>>(sales,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/bids",method= RequestMethod.GET)
    ResponseEntity<List<Bid>> getPersonBids(@PathVariable("id")long id)
    {
        List<Bid> bids=service.getPersonBids(id);
        if(bids.isEmpty())
        {
            return  new ResponseEntity<List<Bid>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Bid>>(bids,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> getPerson(@PathVariable("id")long id)
    {
        Person person=service.getPerson(id);
        if(person==null)
        {
            return  new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Person>(person,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> addPerson(@RequestBody Person person)
    {
        service.addPerson(person);
        return new ResponseEntity<Person>(person,HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> updatePerson(@PathVariable("id")long id,@RequestBody Person person)
    {
        Person oldPerson=service.getPerson(id);
        if(oldPerson==null)
        {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        Person newPerson=new Person
                .Builder(person.getLastName())
                .copy(person)
                .id(id)
                .build();
        service.updatePerson(newPerson);
        return  new ResponseEntity<Person>(newPerson,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    ResponseEntity<Person> deletePerson(@PathVariable("id")long id)
    {
        Person person=service.getPerson(id);
        if(person==null)
        {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        service.deletePerson(person);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
}
