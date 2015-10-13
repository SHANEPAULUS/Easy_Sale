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
    private Date postedDate;
    private Date expireDate;
    //private List<>


    public Sale() {
    }

    public Sale(Builder builder) {
    }

    static class Builder{
        private Long id;
        private Date postedDate;
        private Date expireDate;

        public Builder(Date value)
        {
            this.postedDate=value;
        }

        public Builder expire(Date value)
        {
            this.expireDate=value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }

        public Builder copy(Sale sale)
        {
            this.expireDate=sale.expireDate;
            this.id=sale.id;
            this.postedDate=sale.postedDate;
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

    public Date getPostedDate() {
        return postedDate;
    }

    public Date getExpireDate() {
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
                "id=" + id +
                ", postedDate=" + postedDate +
                ", expireDate=" + expireDate +
                '}';
    }
}
