/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;

import java.io.Serializable;
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
    private int age;
    @Embedded
    private Contact contact;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Item> items;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Invoice> invoices;


    public Person() {
    }

    public Person(Builder builder) {
        this.age=builder.age;
        this.id=builder.id;
        this.contact=builder.contact;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.password=builder.password;
        this.items=builder.items;
        this.invoices=builder.invoices;
    }
    
    static class Builder{
        private String firstName;
        private String lastName;
        private String password;
        private int age;
        private Contact contact; 
        private Long id;
        private List<Invoice> invoices;
        private List<Item> items;
        
        public Builder(String value)
        {
            this.lastName=value;
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

        public Builder password(String value)
        {
            this.password=value;
            return this;
        }

        public Builder items(List<Item> value)
        {
            this.items=value;
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
            this.items=value.items;
            this.invoices=value.invoices;
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

    public List<Item> getItems() {
        return items;
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
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", contact=" + contact + ", id=" + id + '}';
    }
    
}
