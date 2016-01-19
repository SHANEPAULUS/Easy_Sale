package com.experts.easysale.services;

import com.experts.easysale.domain.Invoice;
import com.experts.easysale.domain.OrderLine;

import java.util.List;

/**
 * Created by SHANE on 2015/10/13.
 */
public interface InvoiceService {
    List<Invoice> getAllInvoice();
    List<OrderLine> getItems(long id);
    Invoice getInvoice(long id);
    Invoice addInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);
    void deleteInvoice(Invoice invoice);
}
