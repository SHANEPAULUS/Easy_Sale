package com.experts.easysale.repository;


import com.experts.easysale.App;
import com.experts.easysale.domain.Buyer;
import com.experts.easysale.domain.Person;
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
    private Long id;

    @Autowired
    BuyerRepository repository;

    @Test
    public void testCreate() throws Exception {
        Person buyer=new Buyer
                .Builder("Paulus")
                .firstName("Anil")
                .password("myPassword")
                .age(21)
                .build();

        repository.save(buyer);
    }
}
