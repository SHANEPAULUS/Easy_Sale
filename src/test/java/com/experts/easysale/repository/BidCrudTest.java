package com.experts.easysale.repository;

import com.experts.easysale.App;
import com.experts.easysale.domain.Bid;
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
public class BidCrudTest extends AbstractTestNGSpringContextTests {
    private Long id=1L;

    @Autowired
    BidReposity reposity;

    @Test
    public void testCreate() throws Exception {
        Bid bid=new Bid
                .Builder(300.00)
                .build();
        reposity.save(bid);

        Assert.assertNotNull(bid.getId());
    }
}
