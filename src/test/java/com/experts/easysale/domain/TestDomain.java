/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.sql.Date;

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
                .password("Shane")
                .age(60)
                .build();
        Assert.assertNotNull(buyer);
        Assert.assertEquals("Wessel Goliath", buyer.getFirstName() + " " + buyer.getLastName());
        System.out.println("Password: "+buyer.getPassword());
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

    @Test
    public void testInvoice() throws Exception {
        Invoice invoice=new Invoice
                .Builder("2015/10/13")
                .build();

        Assert.assertNotNull(invoice);

    }

    @Test
    public void testPass() throws Exception {
        String pass="Shane";
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[]=md.digest();

        StringBuffer sb=new StringBuffer();
        for(int x=0;x<byteData.length;x++)
        {
            sb.append(Integer.toString((byteData[x]&0xff)+0x100,16).substring(1));
        }

        System.out.println("Getting the password..");
        System.out.println(sb.toString());

    }
}
