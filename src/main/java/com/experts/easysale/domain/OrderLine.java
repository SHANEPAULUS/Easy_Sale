/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.experts.easysale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.Order;

/**
 *
 * @author shane
 */
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    public OrderLine() {
    }

    public OrderLine(Builder builder)
    {

    }

    static class Builder{
        private Long id;
        private int quantity;

        public Builder(int value)
        {
            this.quantity=value;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder copy(OrderLine order)
        {
            this.quantity=order.quantity;
            this.id=order.id;
            return this;
        }

        public OrderLine build()
        {
            return new OrderLine(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine orderLine = (OrderLine) o;

        return id.equals(orderLine.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
