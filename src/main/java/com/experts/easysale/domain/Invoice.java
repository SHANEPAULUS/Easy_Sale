/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author shane
 */
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Invoice_id")
    private List<OrderLine> invoiceItems;

    public Invoice() {
    }

    public Invoice(Builder builder) {
        this.date=builder.date;
        this.id=builder.id;
        this.invoiceItems=builder.invoiceItems;
    }

    public static class Builder{
        private Long id;
        private Date date;
        private List<OrderLine> invoiceItems;

        public Builder(Date date)
        {
            this.date=date;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder items(List<OrderLine> list)
        {
            this.invoiceItems=list;
            return this;
        }

        public Builder copy(Invoice invoice)
        {
            this.invoiceItems=invoice.invoiceItems;
            this.date=invoice.date;
            this.id=invoice.id;
            return this;
        }

        public Invoice build()
        {
            return new Invoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderLine> getInvoiceItems() {
        return invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        return id.equals(invoice.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", invoiceItems=" + invoiceItems +
                '}';
    }
}
