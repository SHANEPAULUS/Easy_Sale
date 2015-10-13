package com.experts.easysale.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SHANE on 2015/10/12.
 */
@Entity
public class Item implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Double price;
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Items_id")
    private List<Sale> sale;

    public Item() {
    }

    public Item(Builder builder) {
        this.description=builder.description;
        this.id=builder.id;
        this.price=builder.price;
        this.quantity=builder.quantity;
        this.sale=builder.sale;
    }

    public static class Builder{
        private Long id;
        private String description;
        private Double price;
        private int quantity;
        private List<Sale> sale;

        public Builder(String value)
        {
            this.description=value;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder sale(List<Sale> list)
        {
            this.sale=list;
            return this;
        }

        public Builder price(Double value)
        {
            this.price=value;
            return this;
        }

        public Builder quantity(int value)
        {
            this.quantity=value;
            return this;
        }

        public Builder copy(Item value)
        {
            this.price=value.price;
            this.quantity=value.quantity;
            this.description=value.description;
            this.id=value.id;
            this.sale=value.sale;
            return this;
        }

        public Item build()
        {
            return new Item(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Sale> getSale() {
        return sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id.equals(item.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sale=" + sale +
                '}';
    }
}
