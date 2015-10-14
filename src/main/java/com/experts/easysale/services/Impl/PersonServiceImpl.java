package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.Person;
import com.experts.easysale.domain.Sale;
import com.experts.easysale.repository.PersonRepository;
import com.experts.easysale.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> getAllPersons() {
        List<Person> allPersons=new ArrayList<Person>();

        Iterable<Person> persons=repository.findAll();
        for(Person p:persons)
        {
            allPersons.add(p);
        }

        return allPersons;
    }

    @Override
    public List<Invoice> getPersonInvoices(long id) {
        return repository.findOne(id).getInvoices();
    }

    @Override
    public List<Sale> getPersonSales(long id) {
        return repository.findOne(id).getSales();
    }

    @Override
    public List<Bid> getPersonBids(long id) {
        return repository.findOne(id).getBidList();
    }

    @Override
    public Person getPerson(long id) {
        return repository.findOne(id);
    }

    @Override
    public Person addPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        repository.delete(person);
    }
}
