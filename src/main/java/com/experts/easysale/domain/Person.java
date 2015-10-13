/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author shane
 */
@Entity
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private int age;
    @Embedded
    private Contact contact;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Invoice> invoices;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Sale> sales;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Bid> bidList;

    public Person() {
    }

    public Person(Builder builder) {
        this.age=builder.age;
        this.id=builder.id;
        this.contact=builder.contact;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.password=builder.password;
        this.sales=builder.sales;
        this.invoices=builder.invoices;
        this.role=builder.role;
        this.bidList=builder.bidList;
    }
    
    public static class Builder{
        private String firstName;
        private String lastName;
        private String password;
        private String role;
        private int age;
        private Contact contact; 
        private Long id;
        private List<Invoice> invoices;
        private List<Sale> sales;
        private List<Bid> bidList;
        
        public Builder(String value)
        {
            this.lastName=value;
        }

        public Builder bidList(List<Bid> list)
        {
            this.bidList=list;
            return this;
        }
        
        public Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }
        
        public Builder age(int value)
        {
            this.age=value;
            return this;
        }

        public Builder role(String role)
        {
            this.role=role;
            return this;
        }

        public Builder password(String value) throws Exception
        {
            this.password=convertPasswordToMD5(value);
            return this;
        }

        public Builder sale(List<Sale> value)
        {
            this.sales=value;
            return this;
        }

        public Builder invoices(List<Invoice> value)
        {
            this.invoices=value;
            return this;
        }
        
        public Builder contact(Contact value)
        {
            this.contact=value;
            return this;
        }
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder copy(Person value)
        {
            this.age=value.age;
            this.firstName=value.firstName;
            this.lastName=value.lastName;
            this.contact=value.contact;
            this.id=value.id;
            this.password=value.password;
            this.sales=value.sales;
            this.invoices=value.invoices;
            this.bidList=value.bidList;
            return this;
        }
        
        public Person build()
        {
            return new Person(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public String getRole() {
        return role;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    private static String convertPasswordToMD5(String pass) throws NoSuchAlgorithmException {
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[]=md.digest();

        StringBuffer sb=new StringBuffer();
        for(int x=0;x<byteData.length;x++)
        {
            sb.append(Integer.toString((byteData[x]&0xff)+0x100,16).substring(1));
        }
        return sb.toString();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                ", invoices=" + invoices +
                ", sales=" + sales +
                ", bidList=" + bidList +
                '}';
    }
}
