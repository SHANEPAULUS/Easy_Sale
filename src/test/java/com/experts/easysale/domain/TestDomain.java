/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author shane
 */
public class TestDomain {
    
    @Test
    public void testPerson() throws Exception{
        Person person = new Person
                .Builder("Paulus")
                .firstName("Shane")
                .age(25)
                .build();

        Assert.assertNotNull(person);
        Assert.assertEquals("Shane",person.getFirstName());
                        
    }

    @Test
    public void testSeller() throws Exception {
        Person seller=new Seller
                .Builder("Malema")
                .firstName("Julius")
                .age(49)
                .build();
        Assert.assertNotNull(seller);
        Assert.assertEquals(49,seller.getAge());
    }

    @Test
    public void testBuyer() throws Exception {
        Person buyer=new Buyer
                .Builder("Goliath")
                .firstName("Wessel")
                .age(60)
                .build();
        Assert.assertNotNull(buyer);
        Assert.assertEquals("Wessel Goliath",buyer.getFirstName()+" "+buyer.getLastName());
    }

    @Test
    public void testItem() throws Exception {
        Item baseball=new Item
                .Builder("Signed Bulls baseball")
                .price(300.00)
                .quantity(1)
                .build();

        Assert.assertNotNull(baseball);
        Assert.assertEquals(300.00,baseball.getPrice());
    }
}
