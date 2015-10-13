/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author shane
 */
@Embeddable
public class Contact {
    private String address;
    private String email;

    public Contact() {
    }

    public Contact(Builder builder) {
        this.address=builder.address;
        this.email=builder.email;
    }

    static class Builder{
        private String address;
        private String email;

        public Builder(String value)
        {
            this.email=value;
        }

        public Builder address(String value)
        {
            this.address=value;
            return this;
        }

        public Builder copy(Contact contact)
        {
            this.address=contact.address;
            this.email=contact.email;
            return this;
        }

        public Contact build()
        {
            return new Contact(this);
        }
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
