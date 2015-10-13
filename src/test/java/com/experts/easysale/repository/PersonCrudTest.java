package com.experts.easysale.repository;

import com.experts.easysale.App;
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
public class PersonCrudTest extends AbstractTestNGSpringContextTests {
    private Long id=1L;
    @Autowired
    private PersonRepository repository;

    @Test
    public void testCreate() throws Exception {
        Person seller=new Person
                .Builder("Paulus")
                .firstName("Shane")
                .age(21)
                .password("password")
                .role("Seller")
                .build();

        repository.save(seller);
        Assert.assertNotNull(seller.getId());
    }
}
