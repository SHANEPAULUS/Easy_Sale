package com.experts.easysale.repository;

import com.experts.easysale.App;
import com.experts.easysale.domain.Invoice;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by SHANE on 2015/10/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceCrudTest extends AbstractTestNGSpringContextTests{
    private Long id=1L;

    @Autowired
    private InvoiceRepository repository;

    @Test
    public void testCreate() throws Exception {

        Invoice invoice=new Invoice
                .Builder("2015/10/13")
                .build();
        repository.save(invoice);
    }

    @Test
    public void testRead() throws Exception {
        Invoice invoice=repository.findOne(id);
        Assert.assertNotNull(invoice);
    }

    @Test
    public void testUpdate() throws Exception {
        Invoice invoice=repository.findOne(id);
        Invoice newInvoice=new Invoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .build();

        repository.save(newInvoice);
        Invoice updatedInvoice=repository.findOne(id);
        //Assert.assertEquals(null,updatedInvoice.getInvoiceItems());

    }

    @Test
    public void testDelete() throws Exception {
        Invoice invoice=repository.findOne(id);
        repository.delete(invoice);

        Invoice deletedInvoice=repository.findOne(id);
        Assert.assertNull(deletedInvoice);

    }
}
