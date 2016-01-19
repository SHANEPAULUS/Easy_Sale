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
    private List<ItemList> itemList;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Items_id")
    private List<OrderLine> orderList;

    public Item() {
    }

    public Item(Builder builder) {
        this.description=builder.description;
        this.id=builder.id;
        this.price=builder.price;
        this.quantity=builder.quantity;
        this.itemList=builder.itemList;
        this.orderList=builder.orderList;
    }

    public static class Builder{
        private Long id;
        private String description;
        private Double price;
        private int quantity;
        private List<ItemList> itemList;
        private List<OrderLine> orderList;

        public Builder(String value)
        {
            this.description=value;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder order(List<OrderLine> list)
        {
            this.orderList=list;
            return this;
        }

        public Builder itemList(List<ItemList> list)
        {
            this.itemList=list;
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
            this.itemList=value.itemList;
            this.orderList=value.orderList;
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

    public List<OrderLine> getOrderList() {
        return orderList;
    }

    public List<ItemList> getItemList() {
        return itemList;
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
                ", itemList=" + itemList +
                ", orderList=" + orderList +
                '}';
    }
}
