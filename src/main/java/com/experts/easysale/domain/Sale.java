package com.experts.easysale.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SHANE on 2015/10/12.
 */
@Entity
public class Sale implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postedDate;
    private String expireDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sale_id")
    private List<Bid> bids;

    //private List<>


    public Sale() {
    }

    public Sale(Builder builder) {
        this.postedDate=builder.postedDate;
        this.id=builder.id;
        this.expireDate=builder.expireDate;
        this.bids=builder.bids;
    }

    public static class Builder{
        private Long id;
        private String postedDate;
        private String expireDate;
        private List<Bid> bids;

        public Builder(String value)
        {
            this.postedDate=value;
        }

        public Builder expire(String value)
        {
            this.expireDate=value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder bids(List<Bid> list)
        {
            this.bids=list;
            return this;
        }

        public Builder copy(Sale sale)
        {
            this.expireDate=sale.expireDate;
            this.id=sale.id;
            this.postedDate=sale.postedDate;
            this.bids=sale.bids;
            return this;
        }

        public Sale build()
        {
            return new Sale(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public String getExpireDate() {
        return expireDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return id.equals(sale.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "bids=" + bids +
                ", expireDate='" + expireDate + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", id=" + id +
                '}';
    }
}
