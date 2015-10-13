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
    private Long id=2L;

    @Autowired
    private InvoiceRepository repository;

    @Test
    public void testCreate() throws Exception {
        Date today=new Date(15,10,13);
        Invoice invoice=new Invoice
                .Builder(today)
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

    }

    @Test
    public void testDelete() throws Exception {

    }
}
