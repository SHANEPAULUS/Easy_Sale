package com.experts.easysale.repository;

import com.experts.easysale.App;
import com.experts.easysale.domain.Item;
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
public class ItemCrudTest extends AbstractTestNGSpringContextTests {
    private Long id=1L;

    @Autowired
    private ItemRepository repository;

    @Test
    public void testCreate() throws Exception {
        Item apples=new Item
                .Builder("Irish Apples")
                .quantity(20)
                .price(300D)
                .build();

        repository.save(apples);
        id=apples.getId();
        Assert.assertNotNull(id);
    }

    @Test
    public void testRead() throws Exception {
        Item apples=repository.findOne(id);
        Assert.assertNotNull(apples);
        Assert.assertEquals(300D,apples.getPrice());
    }

    @Test
    public void testUpdate() throws Exception {
        Item apples=repository.findOne(id);

        Item newApples=new Item
                .Builder(apples.getDescription())
                .copy(apples)
                .price(200D)
                .build();

        repository.save(newApples);
        Item updatedItem=repository.findOne(id);
        Assert.assertEquals(200D,updatedItem.getPrice());
    }
}
