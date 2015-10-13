package com.experts.easysale.repository;


import com.experts.easysale.App;
import com.experts.easysale.domain.Buyer;
import com.experts.easysale.domain.Person;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by SHANE on 2015/10/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BuyerCrudTest extends AbstractTestNGSpringContextTests {
    private Long id=1L;

    @Autowired
    BuyerRepository repository;

    @Test
    public void testCreate() throws Exception {
        Person buyer=new Buyer
                .Builder("Jay Jay")
                .firstName("Paulsen")
                .password("myPassword")
                .age(21)
                .build();
        repository.save(buyer);
        id=buyer.getId();
    }

    @Test
    public void testRead() throws Exception {
        Person buyer=repository.findOne(id);
        Assert.assertNotNull(buyer);
    }

    @Test
    public void testUpdate() throws Exception {
        Person buyer=repository.findOne(id);
        Person newPerson=new Buyer
                .Builder(buyer.getLastName())
                .copy(buyer)
                .age(20)
                .build();

        repository.save(newPerson);
        Person updated=repository.findOne(id);
        Assert.assertEquals(20,updated.getAge());
    }

    @Test
    public void testDelete() throws Exception {
        Person person=repository.findOne(id);
        repository.delete(person);

        Person deletedPerson=repository.findOne(id);
        Assert.assertNull(deletedPerson);
    }
}
