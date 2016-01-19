package com.experts.easysale.services;

import com.experts.easysale.domain.Bid;
import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.Person;
import com.experts.easysale.domain.Sale;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface PersonService {
    List<Person> getAllPersons();
    List<Invoice> getPersonInvoices(long id);
    List<Sale> getPersonSales(long id);
    List<Bid> getPersonBids(long id);

    Person getPerson(long id);
    Person addPerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(Person person);
}
