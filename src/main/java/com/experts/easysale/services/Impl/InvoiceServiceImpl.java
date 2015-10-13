package com.experts.easysale.services.Impl;

import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.OrderLine;
import com.experts.easysale.repository.InvoiceRepository;
import com.experts.easysale.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository repository;

    @Override
    public List<Invoice> getAllInvoice() {
        List<Invoice> allInvoices=new ArrayList<Invoice>();

        Iterable<Invoice> invoices=repository.findAll();

        for(Invoice inv:invoices)
        {
            allInvoices.add(inv);
        }
        return allInvoices;
    }

    @Override
    public List<OrderLine> getItems(long id) {
        return repository.findOne(id).getInvoiceItems();
    }

    @Override
    public Invoice getInvoice(long id) {
        return repository.findOne(id);
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        repository.delete(invoice);
    }
}
