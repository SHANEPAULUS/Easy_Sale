package com.experts.easysale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by SHANE on 2015/10/13.
 */
@Entity
public class ItemList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    public ItemList() {
    }

    public ItemList(Builder builder) {
        this.id=builder.id;
        this.quantity=builder.quantity;
    }

    public static class Builder{
        private Long id;
        private int quantity;

        public Builder(int quantity)
        {
            this.quantity=quantity;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder copy(ItemList list)
        {
            this.id=list.id;
            this.quantity=list.quantity;
            return this;
        }

        public ItemList build()
        {
            return new ItemList(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
