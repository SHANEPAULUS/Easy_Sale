package com.experts.easysale.repository;

import com.experts.easysale.App;
import com.experts.easysale.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by SHANE on 2015/10/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SaleCrudTest extends AbstractTestNGSpringContextTests{
    private Long id=1L;

    @Autowired
    SaleRepository repository;

    @Test
    public void testCreate() throws Exception {
       Sale sale=new Sale
               .Builder("2015/10/13")
               .expire("2015/11/01")
               .build();

        repository.save(sale);
        Assert.assertNotNull(sale);
    }

    @Test
    public void testRead() throws Exception {
        Sale sale=repository.findOne(id);
        Assert.assertNotNull(sale);
    }

    @Test
    public void testUpdate() throws Exception {
        Sale sale=repository.findOne(id);
        Sale newSale=new Sale
                .Builder(sale.getPostedDate())
                .copy(sale)
                .expire("2015/12/01")
                .build();

        repository.save(newSale);
        Sale updatedSale=repository.findOne(id);
        Assert.assertEquals("2015/12/01",updatedSale.getExpireDate());

    }

    @Test
    public void testDelete() throws Exception {
        Sale sale=repository.findOne(id);
        repository.delete(sale);

        Sale deletedSale=repository.findOne(id);
        Assert.assertNull(deletedSale);
    }
}
